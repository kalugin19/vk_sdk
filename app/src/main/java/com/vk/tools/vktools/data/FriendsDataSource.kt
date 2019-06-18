package com.vk.tools.vktools.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.PositionalDataSource
import com.vk.sdk.api.*
import com.vk.sdk.api.methods.VKApiFriends
import com.vk.sdk.api.methods.VKApiUsers
import com.vk.sdk.api.model.VKApiModel
import com.vk.tools.vktools.data.base.NetworkState
import com.vk.tools.vktools.data.entities.Friend
import com.vk.tools.vktools.data.util.ResponseParser
import java.util.concurrent.Executor

class FriendsDataSource(private val retryExecutor: Executor) : PositionalDataSource<Friend>() {

    private var retry: (() -> Any)? = null

    val networkState = MutableLiveData<NetworkState>()

    val initialLoad = MutableLiveData<NetworkState>()
    fun retryAllFailed() {
        val prevRetry = retry
        retry = null
        prevRetry?.let {
            retryExecutor.execute {
                it.invoke()
            }
        }
    }

    private fun getUsers(ids: List<Long>): VKRequest? {
        val req = VKApiUsers().get(VKParameters.from(VKApiConst.USER_IDS, ids,
            VKApiConst.FIELDS, "photo_100",
            VKApiConst.LANG, "ru"
            ))
        return req;
    }

    private fun getFriends(size: Int, position: Int): VKRequest? {
        return VKApiFriends().get(
            VKParameters.from(
                VKApiConst.COUNT, if (size < 10) {
                    size
                } else 10,
                VKApiConst.OFFSET, position,
                VKApiConst.LANG, "ru",
//                "order", "name",
                VKApiConst.VERSION, "5.92",
                VKApiConst.FIELDS, "photo_100, last_seen, "
            )
        )
    }

    override fun loadRange(params: LoadRangeParams, callback: LoadRangeCallback<Friend>) {
        networkState.postValue(NetworkState.LOADING)
        getFriends(params.loadSize, params.startPosition)
            ?.executeSyncWithListener(
                object :
                    VKRequest.VKRequestListener() {
                    override fun onComplete(response: VKResponse?) {
                        retry = null
                        response?.responseString?.let {
                            callback.onResult(
                                ResponseParser.parseFriends(it)
                            )
                        }
                        networkState.postValue(NetworkState.LOADED)
                        super.onComplete(response)
                    }

                    override fun onError(error: VKError?) {
                        super.onError(error)
                        retry = {
                            loadRange(params, callback)
                        }
                        val error = NetworkState.error(error?.errorMessage ?: "unknown error")
                        networkState.postValue(error)
                    }
                })
    }

    override fun loadInitial(params: LoadInitialParams, callback: LoadInitialCallback<Friend>) {
        networkState.postValue(NetworkState.LOADING)
        initialLoad.postValue(NetworkState.LOADING)
        getFriends(params.requestedLoadSize, params.requestedStartPosition)
            ?.executeSyncWithListener(
                object :
                    VKRequest.VKRequestListener() {
                    override fun onComplete(response: VKResponse?) {
                        retry = null
                        networkState.postValue(NetworkState.LOADED)
                        initialLoad.postValue(NetworkState.LOADED)
                        response?.responseString?.let {
                            try {
                                val friends = ResponseParser.parseFriends(it)
                                val ids =  friends.toTypedArray().map {
                                    it.id
                                }
                                getUsers(ids)!!.executeWithListener(object: VKRequest.VKRequestListener(){
                                    override fun attemptFailed(
                                        request: VKRequest?,
                                        attemptNumber: Int,
                                        totalAttempts: Int
                                    ) {
                                        super.attemptFailed(request, attemptNumber, totalAttempts)
                                    }



                                    override fun onProgress(
                                        progressType: VKRequest.VKProgressType?,
                                        bytesLoaded: Long,
                                        bytesTotal: Long
                                    ) {
                                        super.onProgress(progressType, bytesLoaded, bytesTotal)
                                    }

                                    override fun onError(error: VKError?) {
                                        super.onError(error)
                                    }

                                    override fun onComplete(response: VKResponse?) {
                                        response?.responseString.let { it1->
                                            it1?.let { it2 ->
                                                val users = ResponseParser.parseUsers(it2)
                                                callback.onResult(
                                                    users,
                                                    params.requestedStartPosition,
                                                    params.requestedLoadSize
                                                )
                                            }
                                        }
                                    }
                                })
                            } catch (e: Exception) {
                                networkState.postValue(NetworkState.error(e.message))
                            }
                        }
//                        super.onComplete(response)
                    }

                    override fun onError(error: VKError?) {
                        super.onError(error)
                        retry = {
                            loadInitial(params, callback)
                        }

                        val error = NetworkState.error(error?.errorMessage ?: "unknown error")
                        networkState.postValue(error)
                        initialLoad.postValue(error)
                    }
                })
    }

}
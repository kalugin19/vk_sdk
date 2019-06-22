package com.vk.tools.vktools.data

import androidx.lifecycle.MutableLiveData
import androidx.paging.PositionalDataSource
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKSdk
import com.vk.sdk.api.*
import com.vk.sdk.api.methods.VKApiFriends
import com.vk.sdk.api.methods.VKApiUsers
import com.vk.sdk.api.model.VKApiModel
import com.vk.tools.vktools.data.base.NetworkState
import com.vk.tools.vktools.data.entities.Friend
import com.vk.tools.vktools.data.util.ResponseParser
import java.lang.Exception
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

    private fun getUsers(size: Int, position: Int): VKRequest? {
        val req = VKApiUsers().search(VKParameters.from(
            VKApiConst.COUNT, if (size < 10) {
                size
            } else 10,
            VKApiConst.FIELDS, "photo_100",
            VKApiConst.OFFSET, position,
            VKApiConst.LANG, "ru",
            VKApiConst.VERSION, "5.92",
            VKApiConst.FIELDS, "photo_100, last_seen, ",
            "from_list", "friends"
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
        getUsers(params.requestedLoadSize, params.requestedStartPosition)
            ?.executeSyncWithListener(
                object :
                    VKRequest.VKRequestListener() {
                    override fun onComplete(response: VKResponse?) {
                        retry = null
                        networkState.postValue(NetworkState.LOADED)
                        initialLoad.postValue(NetworkState.LOADED)
                        response?.responseString.let { it1->
                            it1?.let { it2 ->
                                try {
                                    val users = ResponseParser.parseUsers(it2)
                                    callback.onResult(
                                        users,
                                        params.requestedStartPosition,
                                        params.requestedLoadSize
                                    )
                                } catch (e: Exception){
                                    print(e)
                                }
                            }
                        }
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
package com.vk.tools.vktools.data

import android.arch.lifecycle.MutableLiveData
import android.arch.paging.DataSource
import com.vk.tools.vktools.data.entities.Friend
import java.util.concurrent.Executors

open class FriendsDataSourceFactory : DataSource.Factory<Int, Friend>() {
    val sourceLiveData = MutableLiveData<FriendsDataSource>()

    override fun create(): DataSource<Int, Friend> {
        val source = FriendsDataSource(Executors.newFixedThreadPool(5))
        sourceLiveData.postValue(source)
        return source
    }
}
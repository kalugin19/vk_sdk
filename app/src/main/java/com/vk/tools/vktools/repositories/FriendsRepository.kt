package com.vk.tools.vktools.repositories

import android.arch.lifecycle.Transformations
import android.arch.paging.LivePagedListBuilder
import android.arch.paging.PagedList
import com.vk.tools.vktools.data.FriendsDataSourceFactory
import com.vk.tools.vktools.data.base.Listing
import com.vk.tools.vktools.data.entities.Friend
import java.util.concurrent.Executors
import javax.inject.Inject


class FriendsRepository @Inject constructor() {
    companion object {
        const val PAGE_SIZE = 10
    }

    fun loads(): Listing<Friend> {
        val sourceFactory = FriendsDataSourceFactory()
        val refreshState = Transformations.switchMap(sourceFactory.sourceLiveData) {
            it.initialLoad
        }
        return Listing(
            LivePagedListBuilder(
                sourceFactory,
                PagedList.Config.Builder()
                    .setEnablePlaceholders(false)
                    .setPageSize(PAGE_SIZE)
                    .build()
            )
                .setInitialLoadKey(0)
                .setFetchExecutor(Executors.newSingleThreadExecutor())
                .build(),
            networkState = Transformations.switchMap(sourceFactory.sourceLiveData) {
                it.networkState
            },
            retry = {
                sourceFactory.sourceLiveData.value?.retryAllFailed()
            },
            refresh = {
                sourceFactory.sourceLiveData.value?.invalidate()
            },
            refreshState = refreshState
        )
    }
}
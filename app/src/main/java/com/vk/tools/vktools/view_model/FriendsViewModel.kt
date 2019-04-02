package com.vk.tools.vktools.view_model

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Transformations
import com.vk.tools.vktools.repositories.FriendsRepository
import javax.inject.Inject

class FriendsViewModel
@Inject
constructor(
    application: Application,
    private val friendsRepository: FriendsRepository
) : AndroidViewModel(application) {

    private val interactionLiveData = MutableLiveData<Void>()

    private val result = Transformations.map(interactionLiveData) { friendsRepository.loads() }
    val friendsResult = Transformations.switchMap(result) { it.pagedList }
    val networkState = Transformations.switchMap(result){ it.networkState }
    val refreshState = Transformations.switchMap(result){ it.refreshState}

    fun loadFriends() {
        interactionLiveData.postValue(null)
    }
}
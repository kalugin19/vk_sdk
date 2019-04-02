package com.vk.tools.vktools.view.friends

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.annotation.Nullable
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.tools.vktools.R
import com.vk.tools.vktools.view.base.BaseFragment
import com.vk.tools.vktools.view_model.FriendsViewModel
import kotlinx.android.synthetic.main.fragment_friends.view.*
import javax.inject.Inject

class FriendsFragment : BaseFragment() {

    lateinit var viewModel: FriendsViewModel
    lateinit var friendsAdapter: FriendsAdapter

    companion object {
        fun getInstance(): FriendsFragment {
            return FriendsFragment()
        }
    }

    @set:Inject
    var viewModelFactory: ViewModelProvider.Factory? = null

    @Nullable
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_friends, container, false)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(FriendsViewModel::class.java)
        friendsAdapter = FriendsAdapter()
        view.list.layoutManager = LinearLayoutManager(activity)
        view.list.setHasFixedSize(true)
        view.list.adapter = friendsAdapter
        return view
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel.friendsResult.observe(this, Observer {
            friendsAdapter.submitList(it)
        })
        viewModel.networkState.observe(this, Observer {
            friendsAdapter.setNetworkState(it)
        })
        viewModel.loadFriends()
    }
}
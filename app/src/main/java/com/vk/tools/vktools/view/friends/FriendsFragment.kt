package com.vk.tools.vktools.view.friends

import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import android.os.Bundle
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.vk.tools.vktools.R
import com.vk.tools.vktools.view.base.BaseFragment
import com.vk.tools.vktools.view.base.FriendsItemDecoration
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
        view.list.addItemDecoration(FriendsItemDecoration(resources.getDimensionPixelSize(R.dimen.dividerHeight)))
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
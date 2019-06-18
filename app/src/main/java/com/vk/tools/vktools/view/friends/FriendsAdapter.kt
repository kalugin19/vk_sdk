package com.vk.tools.vktools.view.friends

import android.databinding.ViewDataBinding
import android.support.v7.util.DiffUtil
import android.view.LayoutInflater
import android.view.ViewGroup
import com.vk.tools.vktools.R
import com.vk.tools.vktools.data.base.NetworkState
import com.vk.tools.vktools.data.entities.Friend
import com.vk.tools.vktools.databinding.ItemFriendBinding
import com.vk.tools.vktools.databinding.ItemProgressBinding

class FriendsAdapter : DataBoundPagedListAdapter<Friend, ViewDataBinding>(object : DiffUtil.ItemCallback<Friend>() {
    override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem.id == newItem.id
    }
}) {
    override fun bindPartially(binding: ViewDataBinding) {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun bind(binding: ViewDataBinding, item: Friend?) {
        if (binding is ItemFriendBinding) {
            binding.friend = item
        } else {
            (binding as ItemProgressBinding).status = networkState?.status
        }
    }

    private var networkState: NetworkState? = null


    override fun onBindViewHolder(holder: DataBoundViewHolder<ViewDataBinding>, position: Int) {
        if (holder.binding is ItemProgressBinding) {
            bind(holder.binding, null)
        } else {
            super.onBindViewHolder(holder, position)
        }
    }


    override fun createBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        return if (viewType == R.layout.item_friend) {
            ItemFriendBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        } else {
            ItemProgressBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        }
    }

    private fun hasExtraRow() = networkState != null && networkState != NetworkState.LOADED

    override fun getItemViewType(position: Int): Int {
        return if (hasExtraRow() && position == itemCount - 1) {
            R.layout.item_progress
        } else {
            R.layout.item_friend
        }
    }

    override fun getItemCount(): Int {
        return super.getItemCount() + if (hasExtraRow()) 1 else 0
    }

    fun setNetworkState(newNetworkState: NetworkState?) {
        val previousState = this.networkState
        val hadExtraRow = hasExtraRow()
        this.networkState = newNetworkState
        val hasExtraRow = hasExtraRow()
        if (hadExtraRow != hasExtraRow) {
            if (hadExtraRow) {
                notifyItemRemoved(super.getItemCount())
            } else {
                notifyItemInserted(super.getItemCount())
            }
        } else if (hasExtraRow && previousState != newNetworkState) {
            notifyItemChanged(itemCount - 1)
        }
    }
}
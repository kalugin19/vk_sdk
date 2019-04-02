package com.vk.tools.vktools.view.friends

import android.arch.paging.PagedListAdapter
import android.support.v7.util.DiffUtil
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.bumptech.glide.Glide
import com.vk.tools.vktools.R
import com.vk.tools.vktools.data.base.NetworkState
import com.vk.tools.vktools.data.entities.Friend
import kotlinx.android.synthetic.main.item_friend.view.*

class FriendsAdapter : PagedListAdapter<Friend, RecyclerView.ViewHolder>(object : DiffUtil.ItemCallback<Friend>() {
    override fun areContentsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem == newItem
    }

    override fun areItemsTheSame(oldItem: Friend, newItem: Friend): Boolean {
        return oldItem.id == newItem.id
    }
}) {

    private var networkState: NetworkState? = null


    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            R.layout.item_friend -> (holder as FriendHolder).bind(position, getItem(position))
            R.layout.item_progress -> (holder as NetworkStateItemViewHolder).bindTo(
                networkState
            )
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            R.layout.item_friend -> FriendHolder.create(parent)
            R.layout.item_progress -> NetworkStateItemViewHolder.create(parent)
            else -> throw IllegalArgumentException("unknown view type $viewType")
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


    class FriendHolder(view: View) : RecyclerView.ViewHolder(view) {

        fun bind(position: Int, post: Friend?) {
            post?.photo?.let {
                Glide.with(itemView.context).load(it).into(itemView.friend_photo)
            }
            itemView.friend_name.text = post?.lastName + " " + position
        }

        companion object {
            fun create(parent: ViewGroup): FriendHolder {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_friend, parent, false)
                return FriendHolder(view)
            }
        }

    }
}
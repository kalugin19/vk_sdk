package com.vk.tools.vktools.view.friends

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.vk.tools.vktools.R
import com.vk.tools.vktools.data.base.NetworkState
import com.vk.tools.vktools.data.base.Status

class NetworkStateItemViewHolder(view: View)
    : RecyclerView.ViewHolder(view) {
    private val progressBar = view.findViewById<ProgressBar>(R.id.progress)
//    private val retry = view.findViewById<Button>(R.id.retry_button)
//    private val errorMsg = view.findViewById<TextView>(R.id.error_msg)
    init {
//        retry.setOnClickListener {
//            retryCallback()
//        }
    }
    fun bindTo(networkState: NetworkState?) {
        progressBar.visibility = toVisibility(networkState?.status == Status.RUNNING)
//        retry.visibility = toVisibility(networkState?.status == Status.FAILED)
//        errorMsg.visibility = toVisibility(networkState?.msg != null)
//        errorMsg.text = networkState?.msg
    }

    companion object {
        fun create(parent: ViewGroup): NetworkStateItemViewHolder {
            val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_progress, parent, false)
            return NetworkStateItemViewHolder(view)
        }

        fun toVisibility(constraint : Boolean): Int {
            return if (constraint) {
                View.VISIBLE
            } else {
                View.GONE
            }
        }
    }
}

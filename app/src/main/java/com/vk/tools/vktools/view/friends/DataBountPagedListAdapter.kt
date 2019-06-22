package com.vk.tools.vktools.view.friends

import androidx.paging.PagedListAdapter
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import android.view.ViewGroup

/**
 * A generic RecyclerView adapter that uses Data Binding
 *
 * @param <T> Type of the items in the list
 * @param <V> The type of the ViewDataBinding
 * */
abstract class DataBoundPagedListAdapter<T, V : ViewDataBinding> protected constructor(diffCallback: DiffUtil.ItemCallback<T>) :
    PagedListAdapter<T, DataBoundViewHolder<V>>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataBoundViewHolder<V> {
        val binding = createBinding(parent, viewType)
        return DataBoundViewHolder(binding)
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int) {
        val item = getItem(position)
        bind(holder.binding, item)
        holder.binding.executePendingBindings()
    }

    override fun onBindViewHolder(holder: DataBoundViewHolder<V>, position: Int, payloads: List<Any>) {
        if (payloads.isNotEmpty()) {
            bindPartially(holder.binding)
        } else {
            super.onBindViewHolder(holder, position, payloads)
        }
    }

    protected abstract fun bind(binding: V, item: T?)

    protected abstract fun createBinding(parent: ViewGroup, viewType: Int): V

    protected abstract fun bindPartially(binding: V)
}

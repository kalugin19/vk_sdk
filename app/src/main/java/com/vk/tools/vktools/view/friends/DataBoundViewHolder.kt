package com.vk.tools.vktools.view.friends

import android.databinding.ViewDataBinding
import android.support.v7.widget.RecyclerView

class DataBoundViewHolder<T : ViewDataBinding>(val binding: T) : RecyclerView.ViewHolder(binding.root)

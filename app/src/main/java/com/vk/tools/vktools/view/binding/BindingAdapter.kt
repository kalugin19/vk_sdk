package com.vk.tools.vktools.view.binding

import android.databinding.BindingAdapter
import android.widget.ImageView
import com.vk.tools.vktools.GlideApp

class BindingAdapter {

    companion object {
        @BindingAdapter("src")
        @JvmStatic
        fun loadImageResource(imageView: ImageView, path: String) {
            val context = imageView.context
            GlideApp
                .with(context)
                .load(path)
                .into(imageView)
        }
    }

}
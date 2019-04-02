package com.vk.tools.vktools.view

import android.os.Bundle
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.tools.vktools.R
import com.vk.tools.vktools.view.base.BaseActivity
import com.vk.tools.vktools.view.friends.FriendsFragment
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onResume() {
        super.onResume()
        if (!VKSdk.isLoggedIn()) {
            VKSdk.login(
                this@MainActivity,
                VKScope.AUDIO,
                VKScope.DOCS,
                VKScope.FRIENDS,
                VKScope.GROUPS,
                VKScope.MESSAGES,
                VKScope.NOTES,
                VKScope.OFFLINE,
                VKScope.PHOTOS,
                VKScope.WALL,
                VKScope.VIDEO
            )
        } else {
            friends.setOnClickListener {
                supportFragmentManager.beginTransaction()
                    .add(R.id.container, FriendsFragment.getInstance()).commit()
            }
        }
    }
}

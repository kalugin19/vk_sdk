package com.vk.tools.vktools.view

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import com.vk.sdk.VKScope
import com.vk.sdk.VKSdk
import com.vk.sdk.VKServiceActivity
import com.vk.tools.vktools.R
import com.vk.tools.vktools.view.base.BaseActivity
import com.vk.tools.vktools.view.friends.FriendsFragment


class MainActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        if (requestCode == VKServiceActivity.VKServiceType.Authorization.outerCode && resultCode == Activity.RESULT_OK) {
            showFriends()
        }
        super.onActivityResult(requestCode, resultCode, data)
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
            showFriends()
        }
    }

    fun showFriends() {
        supportFragmentManager.beginTransaction()
            .replace(R.id.container, FriendsFragment.getInstance()).commit()
    }
}

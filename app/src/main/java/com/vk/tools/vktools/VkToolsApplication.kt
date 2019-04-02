package com.vk.tools.vktools

import android.app.Activity
import android.app.Application
import android.app.Service
import android.content.BroadcastReceiver
import android.content.Context
import android.support.multidex.MultiDex
import com.vk.sdk.VKSdk
import com.vk.tools.vktools.injection.component.AppInjector
import dagger.android.*
import javax.inject.Inject

class VkToolsApplication: Application(), HasActivityInjector, HasServiceInjector, HasBroadcastReceiverInjector {

    @set:Inject
    var dispatchingAndroidInjector: DispatchingAndroidInjector<Activity>? = null
    @set:Inject
    var dispatchingServiceInjector: DispatchingAndroidInjector<Service>? = null
    @set:Inject
    var dispatchingBroadcastReceiverInjector: DispatchingAndroidInjector<BroadcastReceiver>? = null


    override fun onCreate() {
        super.onCreate()
        VKSdk.initialize(this)
        AppInjector.init(this)
    }

    override fun activityInjector(): DispatchingAndroidInjector<Activity>? {
        return dispatchingAndroidInjector
    }

    override fun serviceInjector(): DispatchingAndroidInjector<Service>? {
        return dispatchingServiceInjector
    }

    override fun broadcastReceiverInjector(): DispatchingAndroidInjector<BroadcastReceiver>? {
        return dispatchingBroadcastReceiverInjector
    }

    override fun attachBaseContext(base: Context) {
        super.attachBaseContext(base)
        MultiDex.install(this)
    }

}
package com.vk.tools.vktools.view.base

import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import javax.inject.Inject

/**
 * Activity : Base
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @set:Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }
}

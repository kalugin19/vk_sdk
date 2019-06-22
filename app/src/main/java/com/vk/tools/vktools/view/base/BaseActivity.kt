package com.vk.tools.vktools.view.base

import androidx.fragment.app.Fragment
import androidx.appcompat.app.AppCompatActivity
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.HasSupportFragmentInjector

import javax.inject.Inject

/**
 * Activity : Base
 */
abstract class BaseActivity : AppCompatActivity(), HasSupportFragmentInjector {

    @set:Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<androidx.fragment.app.Fragment>? = null

    override fun supportFragmentInjector(): DispatchingAndroidInjector<androidx.fragment.app.Fragment>? {
        return dispatchingAndroidInjector
    }
}

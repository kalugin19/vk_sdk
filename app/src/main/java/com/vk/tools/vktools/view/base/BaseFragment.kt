package com.vk.tools.vktools.view.base

import android.content.Context
import android.support.v4.app.Fragment
import dagger.android.DispatchingAndroidInjector
import dagger.android.support.AndroidSupportInjection
import dagger.android.support.HasSupportFragmentInjector

import javax.inject.Inject

/**
 * Fragment : Base
 */
abstract class BaseFragment : Fragment(), HasSupportFragmentInjector {

    @set:Inject
    internal var dispatchingAndroidInjector: DispatchingAndroidInjector<Fragment>? = null

    override fun onAttach(context: Context?) {
        AndroidSupportInjection.inject(this)
        super.onAttach(context)
    }

    override fun supportFragmentInjector(): DispatchingAndroidInjector<Fragment>? {
        return dispatchingAndroidInjector
    }
}

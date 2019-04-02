package com.vk.tools.vktools.injection.module

import com.vk.tools.vktools.view.MainActivity
import com.vk.tools.vktools.injection.scope.PerActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

/**
 * ActivityModule
 */
@Module
abstract class ActivityModule {
    @PerActivity
    @ContributesAndroidInjector(modules = [FragmentBuildersModule::class])
    abstract fun contributeMainActivity(): MainActivity
}

//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract LoginActivity contributeInputActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
//    abstract EmrWorkActivity contributeEmrWorkActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract CoordinateWorkFullScreenDialog contributeCoordinateWorkFullScreenDialog();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract ReviewActivity contributeReviewActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
//    abstract WorkCardActivity contributeWorkCardActivity();
//
//
//    @PerActivity
//    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
//    abstract CounterRenewalActivity contributeCounterActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract SplashActivity contributeSplashActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract GalleryActivity contributeGalleryActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector(modules = FragmentBuildersModule.class)
//    abstract NotificationsActivity contributeNotificationsActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract ServiceActivity contributeServiceActivity();
//
//    @PerActivity
//    @ContributesAndroidInjector
//    abstract UpdateAppActivity contributeUpdateAppActivity();
package com.vk.tools.vktools.injection.component

import android.app.Application
import com.vk.tools.vktools.VkToolsApplication
import com.vk.tools.vktools.injection.module.ActivityModule
import com.vk.tools.vktools.injection.module.AppModule
import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjectionModule

import javax.inject.Singleton

/**
 * AppComponent
 */
@Singleton
@Component(
    modules = [AndroidInjectionModule::class, AppModule::class, ActivityModule::class]
)
interface AppComponent {
    @Component.Builder
    interface Builder {
        @BindsInstance
        fun application(application: Application): Builder

        fun build(): AppComponent
    }

    fun inject(application: VkToolsApplication)
}
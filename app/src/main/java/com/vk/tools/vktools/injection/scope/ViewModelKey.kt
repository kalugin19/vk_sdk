package com.vk.tools.vktools.injection.scope

import android.arch.lifecycle.ViewModel
import dagger.MapKey

import java.lang.annotation.*
import kotlin.reflect.KClass

/**
 * Scope: ViewModel
 */
@Documented
@Target(AnnotationTarget.FUNCTION, AnnotationTarget.PROPERTY_GETTER, AnnotationTarget.PROPERTY_SETTER)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class ViewModelKey(val value: KClass<out ViewModel>)

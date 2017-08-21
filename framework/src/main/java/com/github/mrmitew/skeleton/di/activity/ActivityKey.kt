package com.github.mrmitew.skeleton.di.activity

import android.app.Activity
import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class ActivityKey(val value: KClass<out Activity>)
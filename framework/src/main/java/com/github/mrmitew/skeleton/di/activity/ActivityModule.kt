package com.github.mrmitew.skeleton.di.activity

import android.support.v4.app.FragmentActivity
import dagger.Module
import dagger.Provides

@Module
abstract class ActivityModule<out T> constructor(protected val activity: T) where T:FragmentActivity {

    @Provides
    @ActivityScope
    fun provideActivity():T{return activity}
}
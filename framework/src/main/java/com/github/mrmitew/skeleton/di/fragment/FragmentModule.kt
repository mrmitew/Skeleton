package com.github.mrmitew.skeleton.di.fragment

import android.app.Fragment
import dagger.Module
import dagger.Provides

@Module
abstract class FragmentModule<out T: Fragment> (protected val fragment:T) {

    @Provides
    @FragmentScope
    fun provideFragment() : T {
        return fragment
    }
}
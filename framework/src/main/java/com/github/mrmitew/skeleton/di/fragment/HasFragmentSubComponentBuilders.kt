package com.github.mrmitew.skeleton.di.fragment

import android.app.Fragment

interface HasFragmentSubComponentBuilders {
    fun getFragmentComponentBuilder(fragmentClass : Class<out Fragment>): FragmentComponentBuilder<*,*>
}
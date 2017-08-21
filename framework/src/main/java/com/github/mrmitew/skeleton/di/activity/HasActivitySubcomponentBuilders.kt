package com.github.mrmitew.skeleton.di.activity

import android.support.v4.app.FragmentActivity

interface HasActivitySubcomponentBuilders  {
    fun getActivityComponentBuilder(activityClass: Class<out FragmentActivity>): ActivityComponentBuilder<*,*>
}
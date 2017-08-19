package com.github.mrmitew.skeleton.di.activity

import android.app.Activity
import android.support.v4.app.FragmentActivity

interface HasActivitySubcomponentBuilders  {

    fun getActivityComponentBuilder(activityClass: Class<out Activity>)
            : ActivityComponentBuilder<ActivityModule<FragmentActivity>,ActivityComponent<FragmentActivity>>

}
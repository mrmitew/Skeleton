package com.github.mrmitew.skeleton.welcome.view

import android.os.Bundle
import com.github.mrmitew.skeleton.R
import com.github.mrmitew.skeleton.base.view.BaseActivity
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent

class WelcomeActivity : BaseActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)
    }

    override fun injectMembers(hasActivitySubcomponentBuilders: HasActivitySubcomponentBuilders) {
        val componentBuilder = hasActivitySubcomponentBuilders.getActivityComponentBuilder(WelcomeActivity::class.java) as WelcomeActivityComponent.Builder

        componentBuilder
                .activityModule(WelcomeActivityComponent.WelcomeActivityModule(this@WelcomeActivity))
                .build()
                .injectMembers(this@WelcomeActivity)
    }
}
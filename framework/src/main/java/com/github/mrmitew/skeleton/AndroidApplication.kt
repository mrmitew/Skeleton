package com.github.mrmitew.skeleton

import android.app.Activity
import android.app.Application
import android.content.Context
import android.support.v4.app.FragmentActivity
import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder
import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders
import com.github.mrmitew.skeleton.di.application.ApplicationComponent
import com.github.mrmitew.skeleton.di.application.DaggerApplicationComponent
import javax.inject.Inject
import javax.inject.Provider

class AndroidApplication : Application(), HasActivitySubcomponentBuilders {

    @Inject lateinit var activityComponentBuilders: Map<Class<out Activity>, @JvmSuppressWildcards Provider<ActivityComponentBuilder<*, *>>>

    private lateinit var mApplicationComponent: ApplicationComponent

    companion object {
        operator fun get(context: Context):  HasActivitySubcomponentBuilders{
            return context.applicationContext as HasActivitySubcomponentBuilders
        }
    }

    override fun onCreate() {
        super.onCreate()

        mApplicationComponent = DaggerApplicationComponent.create()
        mApplicationComponent.inject(this)
    }

    override fun getActivityComponentBuilder(activityClass: Class<out FragmentActivity>): ActivityComponentBuilder<*, *> {
        return activityComponentBuilders[activityClass]!!.get()
    }


}
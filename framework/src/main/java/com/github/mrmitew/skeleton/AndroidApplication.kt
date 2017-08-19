//package com.github.mrmitew.skeleton
//
//import android.app.Activity
//import android.app.Application
//import android.app.Fragment
//import android.support.v4.app.FragmentActivity
//import com.github.mrmitew.skeleton.di.activity.ActivityComponent
//import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder
//import com.github.mrmitew.skeleton.di.activity.ActivityModule
//import com.github.mrmitew.skeleton.di.activity.HasActivitySubcomponentBuilders
//import com.github.mrmitew.skeleton.di.application.ApplicationComponent
//import dagger.internal.DaggerCollections
//import javax.inject.Inject
//import javax.inject.Provider
//
//class AndroidApplication : Application(),HasActivitySubcomponentBuilders {
//
//    @field:[Inject]
//    lateinit var mActivityComponentBuilders : Map<Class<out Activity>,
//            Provider<ActivityComponentBuilder<
//                            ActivityModule<FragmentActivity>,
//                            ActivityComponent<FragmentActivity>>>>
//
//    private lateinit var mApplicationComponent: ApplicationComponent
//
//    override fun onCreate() {
//        super.onCreate()
//
//        mApplicationComponent =
//    }
//
//    override fun getActivityComponentBuilder(activityClass: Class<out Activity>): ActivityComponentBuilder<ActivityModule<FragmentActivity>, ActivityComponent<FragmentActivity>> {
//        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
//    }
//
//
//}
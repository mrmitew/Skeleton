package com.github.mrmitew.skeleton.welcome.di

import com.github.mrmitew.skeleton.di.activity.ActivityComponent
import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder
import com.github.mrmitew.skeleton.di.activity.ActivityModule
import com.github.mrmitew.skeleton.di.activity.ActivityScope
import com.github.mrmitew.skeleton.welcome.view.WelcomeActivity
import dagger.Module
import dagger.Subcomponent

@ActivityScope
@Subcomponent(
        modules =  arrayOf(WelcomeActivityComponent.WelcomeActivityModule::class)
)
interface WelcomeActivityComponent : ActivityComponent<WelcomeActivity> {

    @Subcomponent.Builder
    interface Builder : ActivityComponentBuilder<WelcomeActivityModule, WelcomeActivityComponent>

    @Module
    class WelcomeActivityModule constructor(activity: WelcomeActivity) : ActivityModule<WelcomeActivity>(activity)

}
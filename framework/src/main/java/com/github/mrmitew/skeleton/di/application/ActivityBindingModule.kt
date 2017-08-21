package com.github.mrmitew.skeleton.di.application

import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder
import com.github.mrmitew.skeleton.di.activity.ActivityKey
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent
import com.github.mrmitew.skeleton.welcome.view.WelcomeActivity
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module( subcomponents = arrayOf(WelcomeActivityComponent::class))
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(WelcomeActivity::class)
    abstract fun mainActivityComponentBuilder(impl: WelcomeActivityComponent.Builder) : ActivityComponentBuilder<*, *>

}
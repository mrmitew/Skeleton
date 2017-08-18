package com.github.mrmitew.skeleton.di.application;

import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder;
import com.github.mrmitew.skeleton.di.activity.ActivityKey;
import com.github.mrmitew.skeleton.welcome.di.WelcomeActivityComponent;
import com.github.mrmitew.skeleton.welcome.view.WelcomeActivity;

import dagger.Binds;
import dagger.Module;
import dagger.multibindings.IntoMap;

/**
 * All components defined here will become subcomponents of the parent component - ApplicationComponent
 */
@Module(
        subcomponents = {
                WelcomeActivityComponent.class,
        })
abstract class ActivityBindingModule {
    @Binds
    @IntoMap
    @ActivityKey(WelcomeActivity.class)
    public abstract ActivityComponentBuilder welcomeActivityComponentBuilder(WelcomeActivityComponent.Builder impl);
}

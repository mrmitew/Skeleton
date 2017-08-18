package com.github.mrmitew.skeleton.di.application;

import com.github.mrmitew.skeleton.AndroidApplication;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ActivityBindingModule.class
        }
)
public interface ApplicationComponent {
    AndroidApplication inject(AndroidApplication application);
}
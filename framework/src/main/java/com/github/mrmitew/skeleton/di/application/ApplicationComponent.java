package com.github.mrmitew.skeleton.di.application;

import com.github.mrmitew.skeleton.AndroidApplication;
import com.github.mrmitew.skeleton.data.http.di.BackendApiModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ActivityBindingModule.class,
                BackendApiModule.class,
        }
)
public interface ApplicationComponent {
    AndroidApplication inject(AndroidApplication application);
}
package com.github.mrmitew.skeleton.di.application;

import com.github.mrmitew.skeleton.AndroidApplication;
import com.github.mrmitew.skeleton.data.http.di.GithubApiModule;
import com.github.mrmitew.skeleton.repository.di.RepositoryModule;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                ActivityBindingModule.class,
                RepositoryModule.class,
                GithubApiModule.class,
        }
)
public interface ApplicationComponent {
    AndroidApplication inject(AndroidApplication application);
}
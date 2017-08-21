package com.github.mrmitew.skeleton.welcome.di;

import com.github.mrmitew.skeleton.di.activity.ActivityComponent;
import com.github.mrmitew.skeleton.di.activity.ActivityComponentBuilder;
import com.github.mrmitew.skeleton.di.activity.ActivityModule;
import com.github.mrmitew.skeleton.di.activity.ActivityScope;
import com.github.mrmitew.skeleton.welcome.interactor.GetRepoListUseCaseDecorator;
import com.github.mrmitew.skeleton.welcome.view.WelcomeActivity;
import com.github.mrmitew.skeleton.welcome.view.WelcomePresenter;

import dagger.Module;
import dagger.Provides;
import dagger.Subcomponent;

@ActivityScope
@Subcomponent(
        modules = {
                WelcomeActivityComponent.WelcomeActivityModule.class,
        }
)
public interface WelcomeActivityComponent extends ActivityComponent<WelcomeActivity> {

    @Subcomponent.Builder
    interface Builder extends ActivityComponentBuilder<WelcomeActivityModule, WelcomeActivityComponent> {
    }

    @Module
    class WelcomeActivityModule extends ActivityModule<WelcomeActivity> {
        public WelcomeActivityModule(WelcomeActivity activity) {
            super(activity);
        }

        @Provides
        @ActivityScope
        public WelcomePresenter providesWelcomePresenter(GetRepoListUseCaseDecorator getRepoListUseCaseDecorator) {
            return new WelcomePresenter(provideActivity(), getRepoListUseCaseDecorator);
        }
    }
}
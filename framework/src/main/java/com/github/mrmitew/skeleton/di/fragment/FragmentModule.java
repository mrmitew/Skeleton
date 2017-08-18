package com.github.mrmitew.skeleton.di.fragment;

import android.support.v4.app.Fragment;

import dagger.Module;
import dagger.Provides;

@Module
public abstract class FragmentModule<T extends Fragment> {
    protected final T fragment;

    public FragmentModule(T fragment) {
        this.fragment = fragment;
    }

    @Provides
    @FragmentScope
    public T provideFragment() {
        return fragment;
    }
}

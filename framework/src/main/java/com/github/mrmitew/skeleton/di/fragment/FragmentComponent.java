package com.github.mrmitew.skeleton.di.fragment;

import android.support.v4.app.Fragment;

import dagger.MembersInjector;

public interface FragmentComponent<A extends Fragment> extends MembersInjector<A> {
}

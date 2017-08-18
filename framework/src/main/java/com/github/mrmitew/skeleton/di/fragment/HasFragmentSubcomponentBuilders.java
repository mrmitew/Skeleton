package com.github.mrmitew.skeleton.di.fragment;

import android.support.v4.app.Fragment;

public interface HasFragmentSubcomponentBuilders {
    FragmentComponentBuilder getFragmentComponentBuilder(Class<? extends Fragment> fragmentClass);
}
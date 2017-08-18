package com.github.mrmitew.skeleton.di.fragment;

public interface FragmentComponentBuilder<M extends FragmentModule, C extends FragmentComponent> {
    FragmentComponentBuilder<M, C> fragmentModule(M fragmentModule);
    C build();
}
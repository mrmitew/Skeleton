package com.github.mrmitew.skeleton.di.fragment

interface FragmentComponentBuilder<M:FragmentModule<*>, C:FragmentComponent<*>> {
    fun getFragmentModule(fragmentModule : M) : FragmentComponentBuilder<M,C>
}
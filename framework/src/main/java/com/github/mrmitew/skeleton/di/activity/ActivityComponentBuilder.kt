package com.github.mrmitew.skeleton.di.activity

import android.support.v4.app.FragmentActivity

interface ActivityComponentBuilder<M,C>
        where M:ActivityModule<FragmentActivity>, C:ActivityComponent<FragmentActivity> {

    fun activityModule(act : M) :ActivityComponentBuilder<M,C>
    fun build() : C
}
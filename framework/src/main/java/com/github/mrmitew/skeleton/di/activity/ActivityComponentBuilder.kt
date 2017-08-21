package com.github.mrmitew.skeleton.di.activity

interface ActivityComponentBuilder<M : ActivityModule<*>, C : ActivityComponent<*>> {
    fun activityModule(activityModule: M): ActivityComponentBuilder<M, C>
    fun build(): C
}
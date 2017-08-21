package com.github.mrmitew.skeleton.di.application

import com.github.mrmitew.skeleton.AndroidApplication
import com.github.mrmitew.skeleton.data.http.di.BackendApiModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(
        modules = arrayOf(
                ApplicationModule::class,
                ActivityBindingModule::class,
                BackendApiModule::class))

interface ApplicationComponent {
    fun inject(app: AndroidApplication) : AndroidApplication
}
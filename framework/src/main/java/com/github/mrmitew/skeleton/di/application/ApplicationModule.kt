package com.github.mrmitew.skeleton.di.application

import android.content.Context
import com.github.mrmitew.skeleton.AndroidApplication
import com.github.mrmitew.skeleton.domain.executor.JobExecutor
import com.github.mrmitew.skeleton.domain.executor.PostExecutionThread
import com.github.mrmitew.skeleton.domain.executor.ThreadExecutor
import com.github.mrmitew.skeleton.executor.UiThread
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class ApplicationModule constructor(private val mAndroidApplication: AndroidApplication){

    @Provides
    @Singleton
    fun provideApplicationContext() : Context{
        return mAndroidApplication
    }

    @Provides
    @Singleton
    fun provideUiThread(): UiThread{
        return UiThread()
    }

    @Provides
    @Singleton
    fun provideJobExecutor() : JobExecutor {
        return JobExecutor()
    }

    @Provides
    @Singleton
    fun provideThreadExecutor(jobExecutor: JobExecutor) : ThreadExecutor {
        return jobExecutor
    }

    @Provides
    @Singleton
    fun providesPostExecutionThread(uiThread: UiThread) : PostExecutionThread {
        return uiThread
    }
}
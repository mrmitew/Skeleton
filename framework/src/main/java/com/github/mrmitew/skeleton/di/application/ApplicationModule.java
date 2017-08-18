package com.github.mrmitew.skeleton.di.application;

import android.content.Context;

import com.github.mrmitew.skeleton.AndroidApplication;
import com.github.mrmitew.skeleton.domain.executor.JobExecutor;
import com.github.mrmitew.skeleton.domain.executor.PostExecutionThread;
import com.github.mrmitew.skeleton.domain.executor.ThreadExecutor;
import com.github.mrmitew.skeleton.executor.UiThread;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {
    private AndroidApplication mApplication;

    public ApplicationModule(AndroidApplication application) {
        mApplication = application;
    }

    @Provides
    @Singleton
    Context provideApplicationContext() {
        return mApplication;
    }

    @Provides
    @Singleton
    UiThread provideUiThread() {
        return new UiThread();
    }

    @Provides
    @Singleton
    JobExecutor provideJobExecutor() {
        return new JobExecutor();
    }

    @Provides
    @Singleton
    ThreadExecutor provideThreadExecutor(JobExecutor jobExecutor) {
        return jobExecutor;
    }

    @Provides
    @Singleton
    PostExecutionThread providePostExecutionThread(UiThread uiThread) {
        return uiThread;
    }
}
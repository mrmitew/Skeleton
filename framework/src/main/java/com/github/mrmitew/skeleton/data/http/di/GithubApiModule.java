package com.github.mrmitew.skeleton.data.http.di;

import com.github.mrmitew.skeleton.data.repository.github.GithubRestApi;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class GithubApiModule extends RetrofitApiModule {
    private static final String API_BASE_URL = "https://api.github.com/";

    @Override
    protected String getApiBaseUrl() {
        return API_BASE_URL;
    }

    @Provides
    @Singleton
    GithubRestApi provideBackendRestApi(Retrofit retrofit) {
        return retrofit.create(GithubRestApi.class);
    }
}

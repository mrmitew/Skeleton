package com.github.mrmitew.skeleton.data.http.di;

import dagger.Module;

@Module
public class GithubApiModule extends RetrofitApiModule {
    private static final String API_BASE_URL = "https://api.github.com/";

    @Override
    protected String getApiBaseUrl() {
        return API_BASE_URL;
    }
}

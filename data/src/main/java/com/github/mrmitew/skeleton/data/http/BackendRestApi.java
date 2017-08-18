package com.github.mrmitew.skeleton.data.http;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface BackendRestApi {
    @GET("users/{user}/repos")
    Single<List<Object>> listRepos(@Path("user") String user);
}
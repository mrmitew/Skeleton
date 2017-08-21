package com.github.mrmitew.skeleton.data.repository.github;

import com.github.mrmitew.skeleton.data.repository.github.entity.GithubRepo;

import java.util.List;

import io.reactivex.Single;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface GithubRestApi {
    @GET("users/{user}/repos")
    Single<List<GithubRepo>> listRepos(@Path("user") String user);
}
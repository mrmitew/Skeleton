package com.github.mrmitew.skeleton.data.http

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface BackendRestApi {

    @GET("users/{user}/repos")
    fun listRepos(@Path("user") user:String) : Single<List<Any>>

}
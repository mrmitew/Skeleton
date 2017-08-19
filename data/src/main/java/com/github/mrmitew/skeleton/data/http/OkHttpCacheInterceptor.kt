package com.github.mrmitew.skeleton.data.http

import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OkHttpCacheInterceptor @Inject constructor() : Interceptor {

    override fun intercept(chain: Interceptor.Chain?): Response {
        val response : Response? = chain?.proceed(chain.request())
        val cacheControl:CacheControl = CacheControl.Builder()
                .maxAge(1, TimeUnit.MINUTES)
                .build()
        try {
            return response!!.newBuilder()
                    .header("Cache-Control", cacheControl.toString())
                    .build()

        } catch (e : IOException) {
            e.printStackTrace()
            throw e
        }
    }
}
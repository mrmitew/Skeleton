package com.github.mrmitew.skeleton.data.http

import android.content.Context
import android.net.ConnectivityManager
import okhttp3.CacheControl
import okhttp3.Interceptor
import okhttp3.Response
import java.io.IOException
import java.util.concurrent.TimeUnit
import javax.inject.Inject

class OkHttpOfflineCacheInterceptor@Inject constructor (context: Context) : Interceptor {
    private val mContext: Context = context
    private val hasNetwork : Boolean
        get() {
        val cm = mContext.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        return cm.activeNetworkInfo?.isConnected ?: false
    }

    override fun intercept(chain: Interceptor.Chain?): Response {
        var request = chain?.request() ?: throw IOException()

        if(!hasNetwork) {
            val cacheControl: CacheControl = CacheControl.Builder()
                    .maxStale(7, TimeUnit.DAYS)
                    .build()

            request = request.newBuilder()
                    .cacheControl(cacheControl)
                    .build()
        }

        return chain.proceed(request)
    }
}
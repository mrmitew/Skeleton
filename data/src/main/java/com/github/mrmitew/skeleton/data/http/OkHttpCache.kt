package com.github.mrmitew.skeleton.data.http

import android.content.Context
import okhttp3.Cache
import java.io.File
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class OkHttpCache @Inject constructor(context : Context){

    private val mContext : Context = context
    private var mCache: Cache? = null

    fun create() : Cache? {
         mCache = try {
            Cache(File(mContext.cacheDir, "http-mCache"),
                    10 * 1024 * 1024)
        } catch (e : Exception) {
            e.printStackTrace()
            return null
        }

        return mCache
    }

    fun getCache() : Cache? {return mCache}
}
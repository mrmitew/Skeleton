package com.github.mrmitew.skeleton.data.http.di

import com.github.mrmitew.skeleton.BuildConfig
import com.github.mrmitew.skeleton.data.http.BackendRestApi
import com.github.mrmitew.skeleton.data.http.OkHttpCache
import com.github.mrmitew.skeleton.data.http.OkHttpOfflineCacheInterceptor
import com.google.gson.Gson
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
class BackendApiModule {
    companion object { private val API_BASE_URL = "https://api.github.com/" }

    @Provides
    @Singleton
    fun provideBackendRestApi(retrofit: Retrofit) : BackendRestApi {
        return retrofit.create(BackendRestApi::class.java)
    }

    @Provides
    @Singleton
    fun provideRetrofit(@Named("rest") okHttpClient: OkHttpClient,
                        gsonConverterFactory: GsonConverterFactory,
                        rxJava2CallAdapterFactory: RxJava2CallAdapterFactory): Retrofit {
        return Retrofit.Builder()
                .baseUrl(API_BASE_URL)
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .validateEagerly(BuildConfig.DEBUG)
                .build()
    }

    @Provides
    @Singleton
    fun provideCallAdapterFactory() : RxJava2CallAdapterFactory {
        return RxJava2CallAdapterFactory.create()
    }

    @Provides
    @Singleton
    fun provideGsonConverterFactory(gson: Gson): GsonConverterFactory {
        return GsonConverterFactory.create(gson)
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(httpLoggingInterceptor: HttpLoggingInterceptor,
                            offlineCacheInterceptor: OkHttpOfflineCacheInterceptor,
                            cacheInterceptor: OkHttpOfflineCacheInterceptor,
                            okHttpCache: OkHttpCache) : OkHttpClient {
        return OkHttpClient.Builder()
                .addInterceptor(offlineCacheInterceptor)
                .addInterceptor(cacheInterceptor)
                .addInterceptor(httpLoggingInterceptor)
                .cache(okHttpCache.create())
                .build()
    }

    @Provides
    @Singleton
    fun provideHttpLoggingInterceptor() : HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply { level = HttpLoggingInterceptor.Level.BODY }
    }

}
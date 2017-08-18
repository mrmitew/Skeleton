package com.github.mrmitew.skeleton.data.http.di;

import com.github.mrmitew.skeleton.BuildConfig;
import com.github.mrmitew.skeleton.data.gson.AutoValueGsonConverter;
import com.github.mrmitew.skeleton.data.http.OkHttpCache;
import com.github.mrmitew.skeleton.data.http.OkHttpCacheInterceptor;
import com.github.mrmitew.skeleton.data.http.OkHttpOfflineCacheInterceptor;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public abstract class RetrofitApiModule {
    protected abstract String getApiBaseUrl();

    @Provides
    @Singleton
    Retrofit provideRetrofit(final OkHttpClient okHttpClient,
                             final GsonConverterFactory gsonConverterFactory,
                             final RxJava2CallAdapterFactory rxJava2CallAdapterFactory) {
        return new Retrofit.Builder()
                .baseUrl(getApiBaseUrl())
                .client(okHttpClient)
                .addConverterFactory(gsonConverterFactory)
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .validateEagerly(BuildConfig.DEBUG)  // Fail early: check Retrofit configuration at creation time in Debug build.
                .build();
    }

    @Provides
    @Singleton
    RxJava2CallAdapterFactory providesRxJava2CallAdapterFactory() {
        return RxJava2CallAdapterFactory.create();
    }

    @Provides
    @Singleton
    GsonConverterFactory providesGsonConverterFactory(@Named("retrofit") Gson gson) {
        return GsonConverterFactory.create(gson);
    }

    @Provides
    @Singleton
    @Named("retrofit")
    Gson providesGson() {
        return new GsonBuilder()
                .registerTypeAdapterFactory(AutoValueGsonConverter.create())
                .create();
    }

    @Provides
    @Singleton
    OkHttpClient provideOkHttpClient(HttpLoggingInterceptor httpLoggingInterceptor,
                                     OkHttpOfflineCacheInterceptor offlineCacheInterceptor,
                                     OkHttpCacheInterceptor cacheInterceptor,
                                     OkHttpCache cache) {
        return new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .addInterceptor(offlineCacheInterceptor)
                .addNetworkInterceptor(cacheInterceptor)
                .cache(cache.create())
                .build();
    }

    @Provides
    @Singleton
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }
}

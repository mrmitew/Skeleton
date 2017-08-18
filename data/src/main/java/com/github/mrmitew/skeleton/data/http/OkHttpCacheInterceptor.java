package com.github.mrmitew.skeleton.data.http;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Inject;

import okhttp3.CacheControl;
import okhttp3.Interceptor;
import okhttp3.Response;

public class OkHttpCacheInterceptor implements Interceptor {
    @Inject
    public OkHttpCacheInterceptor() {
    }

    @Override
    public Response intercept(final Chain chain) throws IOException {
        Response response = chain.proceed(chain.request());

        // re-write response header to force use of cache
        CacheControl cacheControl = new CacheControl.Builder()
                .maxAge(1, TimeUnit.MINUTES)
                .build();

        return response.newBuilder()
                .header("Cache-Control", cacheControl.toString())
                .build();
    }
}

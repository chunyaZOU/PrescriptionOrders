package com.cloudcommune.yhonline.okhttp;

import com.cloudcommune.yhonline.okhttp.interceptor.NetworkInterceptor;

import java.util.concurrent.TimeUnit;

import okhttp3.Cache;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;

/**
 * Created by zcy on 2017/12/25.
 */

public class OkHttpClientManager {

    private static OkHttpClient mOkHttpClient;


    public static OkHttpClient getInstance() {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                    .addNetworkInterceptor(new NetworkInterceptor())
                    .connectTimeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

    public static OkHttpClient getInstance(Interceptor interceptor) {
        if (mOkHttpClient == null) {
            mOkHttpClient = new OkHttpClient.Builder()
                    .addInterceptor(interceptor)
                    .addNetworkInterceptor(new NetworkInterceptor())
                    .connectTimeout(Constants.TIME_OUT, TimeUnit.MILLISECONDS)
                    .build();
        }
        return mOkHttpClient;
    }

}

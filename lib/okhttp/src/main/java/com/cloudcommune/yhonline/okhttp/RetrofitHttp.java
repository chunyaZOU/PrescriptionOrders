package com.cloudcommune.yhonline.okhttp;

import com.cloudcommune.yhonline.okhttp.converter.CustomeGsonConverterFactory;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by zcy on 2017/12/25.
 */

public class RetrofitHttp {

    private static Retrofit retrofit;

    public static <T> T getHttpService(Class<T> t, String baseUrl) {
        if (retrofit == null) {
            synchronized (RetrofitHttp.class) {
                if (retrofit == null) {
                    retrofit = createRetrofit(OkHttpClientManager.getInstance(), baseUrl);
                }
            }
        }
        return retrofit.create(t);
    }

    public static <T> T getHttpService(Class<T> t, String baseUrl, OkHttpClient client) {
        if (retrofit == null) {
            synchronized (RetrofitHttp.class) {
                if (retrofit == null) {
                    retrofit = createRetrofit(client, baseUrl);
                }
            }
        }
        return retrofit.create(t);
    }

    private static Retrofit createRetrofit(OkHttpClient client, String baseUrl, Class... converter) {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(CustomeGsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(client)
                .build();
        return retrofit;
    }
}

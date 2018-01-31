package com.cloudcommune.yhonline.okhttp.interceptor;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

/**
 * Created by zcy on 2017/12/26.
 */

public class NetworkInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        /*Request.Builder builder=chain.request().newBuilder();
        builder.addHeader("Content-Type","application/json");*/
        return chain.proceed(chain.request());
    }
}

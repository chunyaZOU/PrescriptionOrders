package com.cloudcommune.yhonline.okhttp.converter;

import com.google.gson.Gson;
import com.google.gson.TypeAdapter;
import com.google.gson.reflect.TypeToken;
import com.google.gson.stream.JsonReader;
import com.google.gson.stream.JsonWriter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;
import java.nio.charset.Charset;

import okhttp3.MediaType;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import okio.Buffer;
import retrofit2.Converter;
import retrofit2.Retrofit;

/**
 * Created by zcy on 2018/1/6.
 */

public class CustomeGsonConverterFactory extends Converter.Factory {

    private final Gson gson;

    private CustomeGsonConverterFactory(Gson gson) {
        this.gson = gson;
    }

    public static CustomeGsonConverterFactory create() {
        return create(new Gson());
    }


    public static CustomeGsonConverterFactory create(Gson gson) {
        if (gson == null) throw new NullPointerException("gson==null");
        return new CustomeGsonConverterFactory(gson);
    }

    @Override
    public Converter<?, RequestBody> requestBodyConverter(Type type, Annotation[] parameterAnnotations, Annotation[] methodAnnotations, Retrofit retrofit) {
        TypeAdapter<?> adapter=gson.getAdapter(TypeToken.get(type));
        return new CustomGsonRequestBodyConverter<>(gson,adapter);
    }

    @Override
    public Converter<ResponseBody, ?> responseBodyConverter(Type type, Annotation[] annotations, Retrofit retrofit) {
        TypeAdapter<?> adapter = gson.getAdapter(TypeToken.get(type));
        return new CustomGsonResponseBodyConverter<>(gson, adapter);
    }
}

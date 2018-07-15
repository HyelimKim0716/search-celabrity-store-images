package com.kakaobank.assignment.searchimage.di;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.kakaobank.assignment.searchimage.data.KakaoSearchApi;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.schedulers.Schedulers;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    final String KAKAO_SEARCH_BASE_URL = "https://dapi.kakao.com";
    final String restApiKey = "KakaoAK 2ba807a32abccd8d8e9254d6669dcf32";




    @Provides
    Gson provideGson() {
        return new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_DASHES)
                .setDateFormat("yyyy-MM-dd hh:mm:ss")
                .create();
    }

    @Provides
    RxJava2CallAdapterFactory provideRxFactory() {
        return RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io());
    }

    @Provides
    HttpLoggingInterceptor provideHttpLoggingInterceptor() {
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        return httpLoggingInterceptor;
    }

    @Provides
    Interceptor provideInterceptor() {
        Interceptor httpInterceptor = chain -> {
            Request original = chain.request();
            Request.Builder requestBuilder = original.newBuilder();
            requestBuilder.addHeader("Authorization", restApiKey);

            Request request = requestBuilder.build();
            return chain.proceed(request);
        };

        return httpInterceptor;
    }

    @Provides
    OkHttpClient.Builder provideOkHttpClient(Interceptor interceptor, HttpLoggingInterceptor httpLoggingInterceptor) {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(30, TimeUnit.SECONDS);
        builder.readTimeout(30, TimeUnit.SECONDS);
        builder.interceptors().add(httpLoggingInterceptor);
        builder.interceptors().add(interceptor);
        return builder;
    }

    @Singleton
    @Provides
    Retrofit provideRerofit(Gson gson,
                            RxJava2CallAdapterFactory rxJava2CallAdapterFactory,
                            OkHttpClient.Builder okHttpClientBuilder) {

        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .addCallAdapterFactory(rxJava2CallAdapterFactory)
                .baseUrl(KAKAO_SEARCH_BASE_URL)
                .client(okHttpClientBuilder.build())
                .build();
    }

    @Provides
    KakaoSearchApi provideKakaoSearchApi(Retrofit retrofit) {
        return retrofit.create(KakaoSearchApi.class);
    }
}

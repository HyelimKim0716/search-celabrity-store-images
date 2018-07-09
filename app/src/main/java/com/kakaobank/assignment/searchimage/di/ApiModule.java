package com.kakaobank.assignment.searchimage.di;

import com.kakaobank.assignment.searchimage.model.image.Image;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import io.reactivex.Observable;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class ApiModule {

    final String KAKAO_SEARCH_BASE_URL = "https://dapi.kakao.com";
    final String restApiKey = "2ba807a32abccd8d8e9254d6669dcf32";
    final String SEARCH_IMAGE = "v2/search/image";



    @Provides
    @Singleton
    Retrofit provideRerofit() {
        return new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .baseUrl(KAKAO_SEARCH_BASE_URL)
                .client(new OkHttpClient.Builder().addInterceptor(new HttpLoggingInterceptor()).build())
                .build();
    }

//    @Provides
//    Observable<Image> provideImages(Retrofit retrofit) {
//    }
}

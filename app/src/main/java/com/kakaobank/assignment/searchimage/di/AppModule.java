package com.kakaobank.assignment.searchimage.di;

import android.app.Application;
import android.content.Context;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    @Provides
    @Singleton
    @Named("appContext")
    public Context provideContext(Application application) {
        return application.getApplicationContext();
    }
}

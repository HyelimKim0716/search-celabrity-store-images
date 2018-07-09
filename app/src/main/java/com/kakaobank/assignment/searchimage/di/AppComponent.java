package com.kakaobank.assignment.searchimage.di;

import android.app.Application;

import com.kakaobank.assignment.searchimage.base.BaseApplication;
import com.kakaobank.assignment.searchimage.di.binder.ActivityBinderModule;
import com.kakaobank.assignment.searchimage.di.binder.FragmentBinderModule;

import javax.inject.Singleton;

import dagger.BindsInstance;
import dagger.Component;
import dagger.android.AndroidInjector;
import dagger.android.support.AndroidSupportInjectionModule;

@Singleton
@Component(modules = {
        AndroidSupportInjectionModule.class,
        AppModule.class,
        ApiModule.class,
        ActivityBinderModule.class,
        FragmentBinderModule.class,
        ViewModelModule.class,
        ViewPagerAdapterModule.class
        })
public interface AppComponent extends AndroidInjector<BaseApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        public Builder application(Application application);

        public AppComponent build();
    }


}

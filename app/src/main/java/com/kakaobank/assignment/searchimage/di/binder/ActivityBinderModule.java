package com.kakaobank.assignment.searchimage.di.binder;

import com.kakaobank.assignment.searchimage.di.ui.MainModule;
import com.kakaobank.assignment.searchimage.ui.main.MainActivity;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class ActivityBinderModule {

    @ContributesAndroidInjector(modules = {MainModule.class})
    public abstract MainActivity bindMainActivity();
}
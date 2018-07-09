package com.kakaobank.assignment.searchimage.di.binder;

import com.kakaobank.assignment.searchimage.di.ui.SearchImageModule;
import com.kakaobank.assignment.searchimage.ui.main.search_image.SearchImageFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBinderModule {

    @ContributesAndroidInjector(modules = {SearchImageModule.class})
    public abstract SearchImageFragment provideSearchImageFragment();
}

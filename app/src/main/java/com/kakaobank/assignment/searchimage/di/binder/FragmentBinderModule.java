package com.kakaobank.assignment.searchimage.di.binder;

import com.kakaobank.assignment.searchimage.di.ui.SearchCelebrityModule;
import com.kakaobank.assignment.searchimage.di.ui.StoreCelebrityModule;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityFragment;
import com.kakaobank.assignment.searchimage.ui.main.store_celebrity.StoreCelebrityFragment;

import dagger.Module;
import dagger.android.ContributesAndroidInjector;

@Module
public abstract class FragmentBinderModule {

    @ContributesAndroidInjector(modules = {SearchCelebrityModule.class})
    public abstract SearchCelebrityFragment provideSearchImageFragment();

    @ContributesAndroidInjector(modules = {StoreCelebrityModule.class})
    public abstract StoreCelebrityFragment provideStoreImageFragment();

}

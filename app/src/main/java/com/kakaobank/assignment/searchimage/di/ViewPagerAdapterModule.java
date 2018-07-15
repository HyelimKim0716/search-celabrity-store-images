package com.kakaobank.assignment.searchimage.di;

import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityFragment;
import com.kakaobank.assignment.searchimage.ui.main.store_celebrity.StoreCelebrityFragment;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
class ViewPagerAdapterModule {

    @Provides
    @Singleton
    SearchCelebrityFragment provideSearchImageFragment() {
        return new SearchCelebrityFragment();
    }

    @Provides
    @Singleton
    StoreCelebrityFragment provideStoreImageFragment() {
        return new StoreCelebrityFragment();
    }
}

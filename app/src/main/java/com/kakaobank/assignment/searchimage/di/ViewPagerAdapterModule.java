package com.kakaobank.assignment.searchimage.di;

import com.kakaobank.assignment.searchimage.ui.main.search_image.SearchImageFragment;

import dagger.Module;
import dagger.Provides;

@Module
class ViewPagerAdapterModule {

    @Provides
    SearchImageFragment provideSearchImageFragment() {
        return new SearchImageFragment();
    }
}

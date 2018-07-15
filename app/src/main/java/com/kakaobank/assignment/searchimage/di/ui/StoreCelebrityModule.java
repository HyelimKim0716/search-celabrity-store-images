package com.kakaobank.assignment.searchimage.di.ui;

import com.kakaobank.assignment.searchimage.adapter.store_celebrity.StoreCelebrityResultListAdapter;

import dagger.Module;
import dagger.Provides;

@Module
public class StoreCelebrityModule {

    @Provides
    StoreCelebrityResultListAdapter provideStoreCelebrityResultListAdapter() {
        return new StoreCelebrityResultListAdapter();
    }
}

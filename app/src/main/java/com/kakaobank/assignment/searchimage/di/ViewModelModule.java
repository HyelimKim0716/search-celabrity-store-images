package com.kakaobank.assignment.searchimage.di;

import com.kakaobank.assignment.searchimage.ui.main.MainViewModel;
import com.kakaobank.assignment.searchimage.ui.main.search_image.SearchImageViewModel;

import dagger.Module;
import dagger.Provides;

@Module
class ViewModelModule {

    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

    @Provides
    SearchImageViewModel provideSearchImageViewModel() {
        return new SearchImageViewModel();
    }
}

package com.kakaobank.assignment.searchimage.di;

import com.kakaobank.assignment.searchimage.ui.main.MainViewModel;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewModel;
import com.kakaobank.assignment.searchimage.ui.main.store_celebrity.StoreCelebrityViewModel;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
class ViewModelModule {

    @Provides
    MainViewModel provideMainViewModel() {
        return new MainViewModel();
    }

    @Provides
    @Singleton
    SearchCelebrityViewModel provideSearchCelebrityViewModel(Retrofit retrofit) {
        return new SearchCelebrityViewModel(retrofit);
    }

    @Provides
    StoreCelebrityViewModel provideStoreCelebrityViewModel() {
        return new StoreCelebrityViewModel();
    }
}

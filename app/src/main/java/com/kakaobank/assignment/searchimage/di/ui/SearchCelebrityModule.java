package com.kakaobank.assignment.searchimage.di.ui;

import com.kakaobank.assignment.searchimage.adapter.search_celebrity.SearchCelebrityResultListAdapter;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewModel;

import dagger.Module;
import dagger.Provides;

@Module
public class SearchCelebrityModule {

    @Provides
    SearchCelebrityResultListAdapter provideSearchCelebrityResultListAdapter(SearchCelebrityViewModel viewModel) {
        return new SearchCelebrityResultListAdapter(viewModel);
    }
}

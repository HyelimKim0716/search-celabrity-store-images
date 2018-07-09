package com.kakaobank.assignment.searchimage.ui.main.search_image;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.di.ui.SearchImageModule;

import javax.inject.Inject;

import dagger.android.support.DaggerFragment;

public class SearchImageFragment extends DaggerFragment {

    @Inject
    SearchImageViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_search_image, container, false);

        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);


    }
}

package com.kakaobank.assignment.searchimage.ui.main.search_celebrity;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.adapter.search_celebrity.SearchCelebrityResultListAdapter;
import com.kakaobank.assignment.searchimage.base.BaseDataBindingFragment;
import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.databinding.FragmentSearchCelebrityBinding;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class SearchCelebrityFragment extends BaseDataBindingFragment<FragmentSearchCelebrityBinding> {

    private final String CLASS = "SearchCelebrityFragment, ";

    @Inject
    SearchCelebrityResultListAdapter mAdapter;

    @Inject
    SearchCelebrityViewModel mViewModel;

    private CompositeDisposable mDisposable = new CompositeDisposable();

    @Override
    public void onResume() {
        super.onResume();
        bind();
    }

    @Override
    public void onPause() {
        super.onPause();
        unbind();
    }

    private void bind() {
        mDisposable.add(mViewModel.mSearchCelebrityEventSender.observeOn(AndroidSchedulers.mainThread()).subscribe(this::receiveEvent));
    }


    private void unbind() {
        mDisposable.clear();
    }


    @Override
    public void setLayoutId() {
        layoutId = R.layout.fragment_search_celebrity;
    }

    @Override
    protected void initView() {
        binding.setViewModel(mViewModel);
        binding.searchCelebrityRvImageResult.setLayoutManager(new GridLayoutManager(getContext(), 2));
        binding.searchCelebrityRvImageResult.setAdapter(mAdapter);
    }


    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mViewModel.init();
    }

    private void receiveEvent(Pair<SearchCelebrityViewEvent, Object> event) {
        switch (event.first) {
            case REFRESH_SEARCH_RESULT_LIST:
                Log.d(App.TAG, CLASS + "receiveEvent, event.second = " + event.second);
                mAdapter.setImageResultList(App.mCelebrityResultList);
                Log.d(App.TAG, CLASS + "resultListSize = " + mViewModel.mCelebrityResultList.size());
                mAdapter.notifyDataSetChanged();
                break;

            case HIDE_KEYBOARD:
                    InputMethodManager imm = (InputMethodManager) getActivity().getSystemService(Context.INPUT_METHOD_SERVICE);
                    imm.hideSoftInputFromWindow(binding.searchCelebrityEtCelebrityName.getWindowToken(), 0);
                break;

            case CLICK_FAVORITE:
                try {
                    int position = (int) event.second;
                    CelebrityResult appItem = App.mCelebrityResultList.get(position);

                    mAdapter.changeItemSelectedStatus(position);
                    if (appItem.isSelected())
                        appItem.setSelected(false);
                    else
                        appItem.setSelected(true);

                    mAdapter.notifyDataSetChanged();
                } catch (Exception e) {
                    e.printStackTrace();
                    Log.e(App.TAG, CLASS + " changeAdapterPosition error : " + e.getMessage());
                }
                break;
        }
    }
}

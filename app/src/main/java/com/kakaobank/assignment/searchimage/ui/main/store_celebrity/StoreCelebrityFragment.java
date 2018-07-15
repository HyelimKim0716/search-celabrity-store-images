package com.kakaobank.assignment.searchimage.ui.main.store_celebrity;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.util.Pair;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.adapter.store_celebrity.StoreCelebrityResultListAdapter;
import com.kakaobank.assignment.searchimage.base.BaseDataBindingFragment;
import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.databinding.FragmentStoreCelebrityBinding;

import javax.inject.Inject;

import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.CompositeDisposable;

public class StoreCelebrityFragment extends BaseDataBindingFragment<FragmentStoreCelebrityBinding> {

    private final String CLASS = "SearchCelebrityFragment, ";

    @Inject
    StoreCelebrityResultListAdapter adapter;

    @Inject
    StoreCelebrityViewModel viewModel;

    private CompositeDisposable disposable = new CompositeDisposable();

    @Override
    public void onResume() {
        Log.d(App.TAG, CLASS + "onResume");
        super.onResume();
        bind();
    }

    @Override
    public void onPause() {
        super.onPause();
        Log.d(App.TAG, CLASS + "onPause");
        unbind();
    }

    private void bind() {
        disposable.add(viewModel.mSearchCelebrityEventSender.observeOn(AndroidSchedulers.mainThread()).subscribe(this::receiveEvent));
    }


    private void unbind() {
        disposable.clear();
    }

    @Override
    public void setLayoutId() {
        layoutId = R.layout.fragment_store_celebrity;
    }

    @Override
    protected void initView() {
        binding.setViewModel(viewModel);
        binding.searchCelebrityRvImageResult.setLayoutManager(new GridLayoutManager(getContext(), 3));
        binding.searchCelebrityRvImageResult.setAdapter(adapter);

    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        Log.d(App.TAG, CLASS + "onViewCreated");
        viewModel.init();
        viewModel.loadData();
    }

    private void receiveEvent(Pair<StoreCelebrityViewEvent, Object> event) {
        switch (event.first) {
            case REFRESH_SEARCH_RESULT_LIST:
                Log.d(App.TAG, "receiveEvent, event.second = " + event.second);
                adapter.setImageResultList(viewModel.mCelebrityResultList);
                adapter.notifyDataSetChanged();
                break;
        }
    }
}

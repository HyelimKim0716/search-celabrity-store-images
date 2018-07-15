package com.kakaobank.assignment.searchimage.ui.main.search_celebrity.holder;

import android.support.v4.util.Pair;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.base.BaseDataBindingViewHolder;
import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.databinding.ItemSearchCelebrityResultListBinding;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewEvent;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewModel;

public class SearchCelebrityResultListViewHolder extends BaseDataBindingViewHolder<ItemSearchCelebrityResultListBinding, CelebrityResult> {

    SearchCelebrityViewModel mViewModel;

    public SearchCelebrityResultListViewHolder(ViewGroup parent, SearchCelebrityViewModel viewModel) {
        super(parent, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_search_celebrity_result_list, parent, false));
        mViewModel = viewModel;
    }

    @Override
    public void onBindViewHolder(CelebrityResult celebrityResult, int position) {
        mBinding.setItem(celebrityResult);

        Glide.with(mContext).load(celebrityResult.getThumbnailUrl())
                .thumbnail(0.1f)
                .into(mBinding.celebrityResultItemIvCelebrity);

        mBinding.celebrityResultItemBtnFavorite.setOnClickListener(v -> {
            Log.d(App.TAG, "onBindViewHolder, FavoriteItemClicked");

           mViewModel.mSearchCelebrityEventSender.onNext(new Pair<>(SearchCelebrityViewEvent.CLICK_FAVORITE, getAdapterPosition()));
        });

    }
}

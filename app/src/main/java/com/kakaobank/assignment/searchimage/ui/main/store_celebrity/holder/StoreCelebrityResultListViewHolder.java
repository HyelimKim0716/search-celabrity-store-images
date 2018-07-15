package com.kakaobank.assignment.searchimage.ui.main.store_celebrity.holder;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bumptech.glide.Glide;
import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.base.BaseDataBindingViewHolder;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.databinding.ItemStoreCelebrityResultListBinding;

public class StoreCelebrityResultListViewHolder extends BaseDataBindingViewHolder<ItemStoreCelebrityResultListBinding, CelebrityResult> {

    public StoreCelebrityResultListViewHolder(ViewGroup parent) {
        super(parent, LayoutInflater.from(parent.getContext()).inflate(R.layout.item_store_celebrity_result_list, parent, false));
    }

    @Override
    public void onBindViewHolder(CelebrityResult celebrityResult, int position) {
        mBinding.setItem(celebrityResult);

        Glide.with(mContext).load(celebrityResult.getThumbnailUrl())
                .thumbnail(0.1f)
                .into(mBinding.celebrityResultItemIvCelebrity);

    }
}

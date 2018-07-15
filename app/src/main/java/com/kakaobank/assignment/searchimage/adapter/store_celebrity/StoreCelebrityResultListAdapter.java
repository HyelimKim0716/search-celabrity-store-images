package com.kakaobank.assignment.searchimage.adapter.store_celebrity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.ViewGroup;

import com.kakaobank.assignment.searchimage.base.BaseViewHolder;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewModel;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.holder.SearchCelebrityResultListViewHolder;
import com.kakaobank.assignment.searchimage.ui.main.store_celebrity.holder.StoreCelebrityResultListViewHolder;

import java.util.ArrayList;

public class StoreCelebrityResultListAdapter extends RecyclerView.Adapter<BaseViewHolder<CelebrityResult>> {

    private ArrayList<CelebrityResult> mImageResultList = new ArrayList<>();

    public StoreCelebrityResultListAdapter() {
        mImageResultList.clear();
    }

    public void setImageResultList(ArrayList<CelebrityResult> imageResultList) {
        mImageResultList.addAll(imageResultList);
    }

    public void addImageResultList(CelebrityResult imageResult) {
        mImageResultList.add(imageResult);
    }

    @NonNull
    @Override
    public BaseViewHolder<CelebrityResult> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StoreCelebrityResultListViewHolder(parent);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<CelebrityResult> holder, int position) {
        holder.onBindViewHolder(mImageResultList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mImageResultList.size();
    }


}
package com.kakaobank.assignment.searchimage.adapter.search_celebrity;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.ViewGroup;

import com.kakaobank.assignment.searchimage.base.BaseViewHolder;
import com.kakaobank.assignment.searchimage.common.App;
import com.kakaobank.assignment.searchimage.data.CelebrityResult;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.SearchCelebrityViewModel;
import com.kakaobank.assignment.searchimage.ui.main.search_celebrity.holder.SearchCelebrityResultListViewHolder;

import java.util.ArrayList;

public class SearchCelebrityResultListAdapter extends RecyclerView.Adapter<BaseViewHolder<CelebrityResult>> {

    private String CLASS = "SearchCelebrityResultListAdapter, ";
    private ArrayList<CelebrityResult> mCelebrityResultList = new ArrayList<>();

    private SearchCelebrityViewModel mViewModel;

    public SearchCelebrityResultListAdapter(SearchCelebrityViewModel viewModel) {
        mCelebrityResultList.clear();
        mViewModel = viewModel;
    }

    public void setImageResultList(ArrayList<CelebrityResult> imageResultList) {
        mCelebrityResultList.clear();
        mCelebrityResultList.addAll(imageResultList);
    }

    public void changeItemSelectedStatus(int position) {
        CelebrityResult item = mCelebrityResultList.get(position);

        Log.d(App.TAG, CLASS + ", changeItemSelectedStatus position = " + position + ", isSelected = " + item.isSelected());
        if (item.isSelected())
            mCelebrityResultList.get(position).setSelected(false);
        else
            mCelebrityResultList.get(position).setSelected(true);

        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public BaseViewHolder<CelebrityResult> onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new SearchCelebrityResultListViewHolder(parent, mViewModel);
    }

    @Override
    public void onBindViewHolder(@NonNull BaseViewHolder<CelebrityResult> holder, int position) {
        holder.onBindViewHolder(mCelebrityResultList.get(position), position);
    }

    @Override
    public int getItemCount() {
        return mCelebrityResultList.size();
    }


}
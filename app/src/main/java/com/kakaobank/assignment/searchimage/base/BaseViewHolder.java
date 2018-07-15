package com.kakaobank.assignment.searchimage.base;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseViewHolder<ITEM> extends RecyclerView.ViewHolder {
    Context context;

    BaseViewHolder(ViewGroup parent, View itemView) {
        super(itemView);
        context = parent.getContext();
    }

    public abstract void onBindViewHolder(ITEM item, int position);
}

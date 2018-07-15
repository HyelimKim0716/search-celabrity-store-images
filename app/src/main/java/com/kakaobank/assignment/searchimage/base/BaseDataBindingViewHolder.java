package com.kakaobank.assignment.searchimage.base;

import android.content.Context;
import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseDataBindingViewHolder<BINDING extends ViewDataBinding, ITEM> extends BaseViewHolder<ITEM> {

    protected BINDING mBinding;
    protected Context mContext;

    public BaseDataBindingViewHolder(ViewGroup parent, View itemView) {
        super(parent, itemView);
        mBinding = DataBindingUtil.bind(itemView);
        mContext = parent.getContext();
    }

}

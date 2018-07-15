package com.kakaobank.assignment.searchimage.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import dagger.android.support.DaggerFragment;

public abstract class BaseDataBindingFragment<BINDING extends ViewDataBinding> extends DaggerFragment {

    public BINDING binding = null;
    public int layoutId = -1;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        setLayoutId();
        binding = DataBindingUtil.inflate(LayoutInflater.from(getActivity()), layoutId, container, false);
        View view = binding.getRoot();

        initView();

        return view;
    }

    public abstract void setLayoutId();
    protected abstract void initView();
}

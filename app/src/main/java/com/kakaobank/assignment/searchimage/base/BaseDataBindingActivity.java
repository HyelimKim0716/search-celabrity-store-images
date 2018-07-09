package com.kakaobank.assignment.searchimage.base;

import android.databinding.DataBindingUtil;
import android.databinding.ViewDataBinding;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;

import dagger.android.support.DaggerAppCompatActivity;

public abstract class BaseDataBindingActivity<BINDING extends ViewDataBinding> extends DaggerAppCompatActivity {

    public BINDING binding = null;
    public int layoutId = -1;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setLayoutId();
        binding = DataBindingUtil.setContentView(this, layoutId);
        Log.d("BaseDataBindingActivity", "onCreate");
    }

    public abstract void setLayoutId();
}

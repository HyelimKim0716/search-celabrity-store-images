package com.kakaobank.assignment.searchimage.ui.main;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;

import com.kakaobank.assignment.searchimage.R;
import com.kakaobank.assignment.searchimage.base.BaseDataBindingActivity;
import com.kakaobank.assignment.searchimage.databinding.ActivityMainBinding;
import com.kakaobank.assignment.searchimage.ui.main.search_image.SearchImageFragment;

import javax.inject.Inject;

public class MainActivity extends BaseDataBindingActivity<ActivityMainBinding> {

    @Inject
    MainViewModel viewModel;

    @Inject
    SearchImageFragment searchImageFragment;

    @Override
    public void setLayoutId() {
        layoutId = R.layout.activity_main;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        ViewPager viewPager = findViewById(R.id.main_viewPager);
        TabLayout tabLayout = findViewById(R.id.main_tabLayout);

        MainFragmentPagerAdapter fragmentPagerAdapter = new MainFragmentPagerAdapter(getSupportFragmentManager());
        fragmentPagerAdapter.clearFragment();
        fragmentPagerAdapter.addFragment(searchImageFragment);
        fragmentPagerAdapter.addFragment(new SearchImageFragment());
        viewPager.setAdapter(fragmentPagerAdapter);
        tabLayout.setupWithViewPager(viewPager);
    }
}

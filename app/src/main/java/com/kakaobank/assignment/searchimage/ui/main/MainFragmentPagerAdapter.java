package com.kakaobank.assignment.searchimage.ui.main;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;


public class MainFragmentPagerAdapter extends FragmentPagerAdapter {

    private final int FRAGMENT_SEARCH_IMAGE_POSITION = 0;
    private final int FRAGMENT_STORE_IMAGE_POSITION = 1;

    private ArrayList<Fragment> mFragmentList = new ArrayList<>();

    MainFragmentPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    public void clearFragment() {
        mFragmentList.clear();
    }

    public void addFragment(Fragment fragment) {
        mFragmentList.add(fragment);
    }

    @Override
    public Fragment getItem(int position) {
        return mFragmentList.get(position);
    }

    @Override
    public int getCount() {
        return mFragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        String title = null;

        switch (position) {
            case FRAGMENT_SEARCH_IMAGE_POSITION:
                title = "Search ImageResult";
                break;
            case FRAGMENT_STORE_IMAGE_POSITION:
                title = "Store ImageResult";
                break;

        }

        return title;
    }
}

package com.bing.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.bing.android.ui.fragment.NewsFragment;


/**
 * Created by RF
 * on 2018/1/9.
 */

public class MainPagerAdapter extends FragmentStatePagerAdapter {
    private int mTabCount;
    public MainPagerAdapter(FragmentManager fm) {
        super(fm);
        this.mTabCount = 0;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return NewsFragment.newInstance();
            case 1:
                return NewsFragment.newInstance();
            case 2:
                return NewsFragment.newInstance();
            case 3:
                return NewsFragment.newInstance();
            default:
                return null;
        }
    }

    @Override
    public int getCount() {
        return mTabCount;
    }
    public void setCount(int count) {
        mTabCount = count;
    }
}

package com.bing.android.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.mrhmr.customer.ui.main.OwnFragment.OwnFragment;
import com.mrhmr.customer.ui.main.HomeFragment.HomeFragment;
import com.mrhmr.customer.ui.main.MarketFragment.MarketFragment;
import com.mrhmr.customer.ui.main.BeautifulDiaryFragment.BeautifulDiaryFragment;


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
                return HomeFragment.newInstance();
            case 1:
                return BeautifulDiaryFragment.newInstance();
            case 2:
                return MarketFragment.newInstance();
            case 3:
                return OwnFragment.newInstance();
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

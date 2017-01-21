package com.betterclever.aparoksha.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.betterclever.aparoksha.fragments.DaysView;
import com.betterclever.aparoksha.fragments.HighlightsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterclever on 21/01/17.
 */

public class DaysViewPagerAdapter extends FragmentPagerAdapter{

    List<Fragment> fragments;

    public DaysViewPagerAdapter(FragmentManager fm) {

        super(fm);

        fragments = new ArrayList<>();
        fragments.add(DaysView.newInstance("23-03-2017"));
        fragments.add(DaysView.newInstance("24-03-2017"));
        fragments.add(DaysView.newInstance("25-03-2017"));

    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }

}

package com.betterclever.aparoksha;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.app.ListFragment;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.View;

import com.betterclever.aparoksha.activities.HighlightsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterclever on 27/12/16.
 */

public class ViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public ViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(HighlightsFragment.newInstance());
        fragments.add(HighlightsFragment.newInstance());
        fragments.add(HighlightsFragment.newInstance());
        fragments.add(HighlightsFragment.newInstance());

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

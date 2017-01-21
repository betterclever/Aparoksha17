package com.betterclever.aparoksha.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.betterclever.aparoksha.fragments.HighlightsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterclever on 27/12/16.
 */

public class HighlightsViewPagerAdapter extends FragmentStatePagerAdapter {

    List<Fragment> fragments;

    public HighlightsViewPagerAdapter(FragmentManager fm) {
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

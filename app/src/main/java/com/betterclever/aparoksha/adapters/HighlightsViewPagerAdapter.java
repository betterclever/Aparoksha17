package com.betterclever.aparoksha.adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.util.Log;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.HighlightsFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by betterclever on 27/12/16.
 */

public class HighlightsViewPagerAdapter extends FragmentStatePagerAdapter {

    private List<HighlightsFragment> fragments;

    public HighlightsViewPagerAdapter(FragmentManager fm) {
        super(fm);
        fragments = new ArrayList<>();
        fragments.add(HighlightsFragment.newInstance(R.drawable.humble_fool_cup));
        fragments.add(HighlightsFragment.newInstance(R.drawable.hint));
        fragments.add(HighlightsFragment.newInstance(R.drawable.humble_fool_cup));
        fragments.add(HighlightsFragment.newInstance(R.drawable.hint));
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments.size();
    }
    
    public void reset(){
        for(HighlightsFragment f: fragments){
            f.reset();
            Log.i("Hi","reseting");
        }
    }
}

package com.betterclever.aparoksha.activities;

import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.adapters.DaysViewPagerAdapter;

public class DaysViewActivity extends AppCompatActivity {

    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_days_view);

        viewPager = (ViewPager) findViewById(R.id.viewPager);

        viewPager.setAdapter(new DaysViewPagerAdapter(getSupportFragmentManager()));

    }


    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onPause() {
        super.onPause();

    }

}

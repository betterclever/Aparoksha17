package com.betterclever.aparoksha.activities;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.ListFragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.SwishyTransformer;
import com.betterclever.aparoksha.ViewPagerAdapter;

import java.util.ArrayList;
import java.util.List;

import jp.wasabeef.blurry.Blurry;

public class HomeActivity extends AppCompatActivity {

    ImageView qrImageView, categoryImageView, dayImageView;
    ViewPager viewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        assignViews();
        blurViews();

        init();
    }

    private void init() {

        viewPager.setAdapter(new ViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(true,new SwishyTransformer(this));

    }

    private void blurViews() {

        qrImageView.post(new Runnable() {
            @Override
            public void run() {
                Blurry.with(HomeActivity.this)
                        .radius(10)
                        .sampling(1)
                        .color(Color.argb(100, 0, 0, 0))
                        .async()
                        .capture(qrImageView)
                        .into(qrImageView);
            }
        });

        categoryImageView.post(new Runnable() {
            @Override
            public void run() {
                Blurry.with(HomeActivity.this)
                        .radius(5)
                        .sampling(1)
                        .color(Color.argb(150, 0, 0, 0))
                        .async()
                        .capture(categoryImageView)
                        .into(categoryImageView);
            }
        });

        dayImageView.post(new Runnable() {
            @Override
            public void run() {
                Blurry.with(HomeActivity.this)
                        .radius(5)
                        .sampling(1)
                        .color(Color.argb(150, 0, 0, 0))
                        .async()
                        .capture(dayImageView)
                        .into(dayImageView);
            }
        });

    }

    private void assignViews() {

        qrImageView = (ImageView) findViewById(R.id.qrImageView);
        categoryImageView = (ImageView) findViewById(R.id.categoryImageView);
        dayImageView = (ImageView) findViewById(R.id.dayImageVew);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

    }

}

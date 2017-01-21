package com.betterclever.aparoksha.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.SwishyTransformer;
import com.betterclever.aparoksha.adapters.HighlightsViewPagerAdapter;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.Timer;
import java.util.TimerTask;

import jp.wasabeef.blurry.Blurry;

public class HomeActivity extends AppCompatActivity {

    ImageView qrImageView, categoryImageView, dayImageView;
    ViewPager viewPager;

    int currentPage = 0;
    Timer timer;
    final long DELAY_MS = 500;//delay in milliseconds before task is to be executed
    final long PERIOD_MS = 3000; // time in milliseconds between successive task executions.


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        assignViews();
        blurViews();
        qrImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startScan();
            }
        });
        dayImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v){
                HomeActivity.this.startActivity(new Intent( HomeActivity.this,DaysViewActivity.class));
            }
        });
        init();
    }

    private void init() {

        viewPager.setAdapter(new HighlightsViewPagerAdapter(getSupportFragmentManager()));
        viewPager.setPageTransformer(true,new SwishyTransformer(this));

/*
        final Handler handler = new Handler();
        final Runnable Update = new Runnable() {
            public void run() {
                if (currentPage == 4-1) {
                    currentPage = 0;
                }
                viewPager.setCurrentItem(currentPage++, true);
            }
        };

        timer = new Timer(); // This will create a new Thread
        timer .schedule(new TimerTask() { // task to be scheduled

            @Override
            public void run() {
                handler.post(Update);
            }
        }, 3000, PERIOD_MS);
*/

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


    private void startScan(){

        new IntentIntegrator(this).initiateScan();

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if(result != null) {
            if(result.getContents() == null) {
                Toast.makeText(this, "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText(this, "Scanned: " + result.getContents(), Toast.LENGTH_LONG).show();
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }

}

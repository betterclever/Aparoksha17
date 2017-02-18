package com.betterclever.aparoksha.activities;

import android.content.Intent;
import android.graphics.Color;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.Description;
import com.betterclever.aparoksha.fragments.Organizer;
import com.betterclever.aparoksha.fragments.TimeDate;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;
import jp.wasabeef.blurry.Blurry;

public class EventDetailActivity extends AppCompatActivity {

	ViewPager viewPager;
	SpaceTabLayout spaceTabLayout;
	ImageView eventImageView, categoryImageView, teamSizeImageView, durationImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);

		assignViews();

		init(savedInstanceState);
/*
		teamSizeImageView.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Blurry.with(EventDetailActivity.this)
						.radius(5)
						.sampling(2)
						.color(Color.argb(100, 0, 0, 0))
						.async()
						.capture(eventImageView)
						.into(eventImageView);
			}
		});*/
		final Handler handler = new Handler();
		handler.postDelayed(new Runnable() {
			@Override
			public void run() {
				Blurry.with(EventDetailActivity.this)
					.radius(10)
					.sampling(5)
					.color(Color.argb(100, 1, 1, 1))
					.async()
					.capture(eventImageView)
					.into(eventImageView);
			}
		}, 100);

	}

	private void init(Bundle savedInstanceState) {

		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(TimeDate.newInstance());
		fragmentList.add(Description.newInstance());
		fragmentList.add(Organizer.newInstance());

		spaceTabLayout.initialize(viewPager, getSupportFragmentManager(),
			fragmentList, savedInstanceState);

	}

	private void assignViews() {

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		spaceTabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);
		eventImageView = (ImageView) findViewById(R.id.eventImageView);
		//categoryImageView = (ImageView) findViewById(R.id.categoryImageView);

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

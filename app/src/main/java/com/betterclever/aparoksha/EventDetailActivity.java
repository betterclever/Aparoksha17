package com.betterclever.aparoksha;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.betterclever.aparoksha.fragments.TimeDate;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class EventDetailActivity extends AppCompatActivity {

	ViewPager viewPager;
	SpaceTabLayout spaceTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_event_detail);

		assignViews();

		init(savedInstanceState);

	}

	private void init(Bundle savedInstanceState) {

		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(TimeDate.newInstance());
		fragmentList.add(TimeDate.newInstance());
		fragmentList.add(TimeDate.newInstance());

		spaceTabLayout.initialize(viewPager, getSupportFragmentManager(),
			fragmentList, savedInstanceState);

	}

	private void assignViews() {

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		spaceTabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);
	}
}

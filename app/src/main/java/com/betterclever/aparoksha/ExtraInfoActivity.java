package com.betterclever.aparoksha;

import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import eu.long1.spacetablayout.SpaceTabLayout;

public class ExtraInfoActivity extends AppCompatActivity {

	ViewPager viewPager;
	SpaceTabLayout spaceTabLayout;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_extra_info);

		assignViews();

		init(savedInstanceState);

	}

	private void init(Bundle savedInstanceState) {

		List<Fragment> fragmentList = new ArrayList<>();
		fragmentList.add(Developers.newInstance());
		fragmentList.add(Developers.newInstance());
		fragmentList.add(Developers.newInstance());

		spaceTabLayout.initialize(viewPager, getSupportFragmentManager(),
			fragmentList, savedInstanceState);

	}

	private void assignViews() {

		viewPager = (ViewPager) findViewById(R.id.viewPager);
		spaceTabLayout = (SpaceTabLayout) findViewById(R.id.spaceTabLayout);
	}
}

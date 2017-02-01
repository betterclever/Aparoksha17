package com.betterclever.aparoksha.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.betterclever.aparoksha.R;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;

public class Categories extends AppCompatActivity {
	
	private WheelView wheelView;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_categories);
		
		assignViews();
		init();
	}
	
	private void init() {
		
		wheelView.setAdapter(new WheelAdapter() {
			@Override
			public Drawable getDrawable(int position) {
				return ContextCompat.getDrawable(Categories.this,R.drawable.ic_team);
			}
			
			@Override
			public int getCount() {
				return 6;
			}
		});
	}
	
	private void assignViews() {
		wheelView = (WheelView) findViewById(R.id.wheelview);
	}
}

package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;

/**
 * Created by betterclever on 1/27/2017.
 */

public class Description extends Fragment {
	
	public Description() {}
	
	public static Description newInstance() {
		
		Bundle args = new Bundle();
		
		Description fragment = new Description();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_description, container, false);
		
	}
	
}

package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.betterclever.aparoksha.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class Organizer extends Fragment {
	
	ScrollView scrollView;
	LinearLayout scrollableLayout;
	
	public Organizer() {}
	
	public static Organizer newInstance() {
		
		Bundle args = new Bundle();
		
		Organizer fragment = new Organizer();
		fragment.setArguments(args);
		return fragment;
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {
		
		View v = inflater.inflate(R.layout.fragment_organizer, container, false);
		scrollView = (ScrollView) v.findViewById(R.id.scrollView);
		scrollableLayout = (LinearLayout) v.findViewById(R.id.scrollViewLL);
		
		for (int i = 0; i < 4; i++) {
			View c = inflater.inflate(R.layout.card_organizer,scrollView,false);
			scrollableLayout.addView(c);
		}
		
		return v;
	}
	
}

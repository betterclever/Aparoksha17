package com.betterclever.aparoksha;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by betterclever on 12/21/2016.
 */

public class Developers extends Fragment {

	public Developers() {}

	public static Developers newInstance() {

		Bundle args = new Bundle();

		Developers fragment = new Developers();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		return inflater.inflate(R.layout.fragment_developers, container, false);
	}

}

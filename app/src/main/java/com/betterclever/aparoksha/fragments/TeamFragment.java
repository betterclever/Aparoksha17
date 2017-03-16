package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.adapters.PersonAdapter;
import com.betterclever.aparoksha.utils.Constants;

/**
 * Created by betterclever on 12/21/2016.
 */

public class TeamFragment extends Fragment {

	RecyclerView teamAprRecyclerView;
	RecyclerView developersRecyclerView;
	
	PersonAdapter teamAdapter;
	PersonAdapter developerAdapter;
	
	
	public TeamFragment() {}

	public static TeamFragment newInstance() {

		Bundle args = new Bundle();

		TeamFragment fragment = new TeamFragment();
		fragment.setArguments(args);

		return fragment;
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
							 Bundle savedInstanceState) {

		View v= inflater.inflate(R.layout.fragment_team, container, false);
		teamAprRecyclerView = (RecyclerView) v.findViewById(R.id.team_recyclerview);
		developersRecyclerView = (RecyclerView) v.findViewById(R.id.developers_recyclerview);
		
		LinearLayoutManager layoutManager1
			= new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
		
		LinearLayoutManager layoutManager2
			= new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
		
		teamAprRecyclerView.setLayoutManager(layoutManager1);
		developersRecyclerView.setLayoutManager(layoutManager2);
		
		teamAdapter = new PersonAdapter(getContext(),Constants.teamAprList,false);
		developerAdapter = new PersonAdapter(getContext(),Constants.developersList,true);
		
		teamAprRecyclerView.setAdapter(teamAdapter);
		developersRecyclerView.setAdapter(developerAdapter);
		
		return v;
	}

}

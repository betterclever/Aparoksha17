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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by betterclever on 12/21/2016.
 */

public class TeamFragment extends Fragment {
    
    PersonAdapter teamAdapter;
    PersonAdapter developerAdapter;
    PersonAdapter membersAdapter;
    
    @BindView(R.id.team_recyclerview)
    RecyclerView teamRecyclerView;
    @BindView(R.id.developers_recyclerview)
    RecyclerView developersRecyclerView;
    @BindView(R.id.memebers_recyclerview)
    RecyclerView memebersRecyclerView;
    
    public TeamFragment() {
    }
    
    public static TeamFragment newInstance() {
        
        Bundle args = new Bundle();
        
        TeamFragment fragment = new TeamFragment();
        fragment.setArguments(args);
        
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View v = inflater.inflate(R.layout.fragment_team, container, false);
        ButterKnife.bind(this, v);
        
        LinearLayoutManager layoutManager1
            = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
        
        LinearLayoutManager layoutManager2
            = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    
    
        LinearLayoutManager layoutManager3
            = new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false);
    
    
        teamRecyclerView.setLayoutManager(layoutManager1);
        developersRecyclerView.setLayoutManager(layoutManager2);
        memebersRecyclerView.setLayoutManager(layoutManager3);
        
        teamAdapter = new PersonAdapter(getContext(), Constants.teamAprList, false);
        developerAdapter = new PersonAdapter(getContext(), Constants.developersList, true);
        membersAdapter = new PersonAdapter(getContext(),Constants.memberList,false);
        
        teamRecyclerView.setAdapter(teamAdapter);
        developersRecyclerView.setAdapter(developerAdapter);
        memebersRecyclerView.setAdapter(membersAdapter);
        
        return v;
    }
    
}

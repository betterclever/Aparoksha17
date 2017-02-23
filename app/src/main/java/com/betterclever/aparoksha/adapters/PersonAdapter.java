package com.betterclever.aparoksha.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.TeamPerson;
import com.betterclever.aparoksha.viewholder.PersonViewHolder;

import java.util.List;

/**
 * Created by betterclever on 2/21/2017.
 */

public class PersonAdapter extends RecyclerView.Adapter<PersonViewHolder> {
    
    private List<TeamPerson> teamPersonList;
    
    public PersonAdapter(List<TeamPerson> teamPersonList){
        this.teamPersonList = teamPersonList;
    }
    
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.person_card, parent, false);
        return new PersonViewHolder(v);
    
    }
    
    @Override
    public void onBindViewHolder(PersonViewHolder holder, int position) {
        holder.assignPerson(teamPersonList.get(position));
    }
    
    @Override
    public int getItemCount() {
        return teamPersonList.size();
    }
    
}

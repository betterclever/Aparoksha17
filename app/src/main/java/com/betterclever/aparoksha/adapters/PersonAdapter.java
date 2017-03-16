package com.betterclever.aparoksha.adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
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
    private boolean isDeveloperAdapter;
    private Context context;
    
    public PersonAdapter(Context context, List<TeamPerson> teamPersonList, boolean isDeveloperAdapter){
        this.context = context;
        this.teamPersonList = teamPersonList;
        this.isDeveloperAdapter = isDeveloperAdapter;
    }
    
    @Override
    public PersonViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(
            (isDeveloperAdapter) ? R.layout.developer_card : R.layout.person_card,
            parent, false);
        return new PersonViewHolder(v, isDeveloperAdapter);
    }
    
    @Override
    public void onBindViewHolder(final PersonViewHolder holder, final int position) {
        holder.assignPerson(teamPersonList.get(position));
        if(isDeveloperAdapter){
            if(holder.getGithubImageView()!=null){
                holder.getGithubImageView().setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        String url = teamPersonList.get(position).getGithubLink();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        context.startActivity(i);
                    }
                });
            }
        }
    }
    
    @Override
    public int getItemCount() {
        return teamPersonList.size();
    }
    
}

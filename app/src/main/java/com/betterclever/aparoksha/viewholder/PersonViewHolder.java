package com.betterclever.aparoksha.viewholder;

import android.Manifest;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.activities.EventDetailActivity;
import com.betterclever.aparoksha.activities.HomeActivity;
import com.betterclever.aparoksha.model.TeamPerson;

/**
 * Created by betterclever on 2/21/2017.
 */

public class PersonViewHolder extends RecyclerView.ViewHolder {
    
    private ImageView headerImageView;
    private TextView nameTextView;
    private TextView roleTextView;
    private Button actionButton;
    private ImageView githubImageView;
    
    public PersonViewHolder(View itemView, boolean isDeveloperAdapter) {
        super(itemView);
        headerImageView = (ImageView) itemView.findViewById(R.id.profile_image);
        nameTextView = (TextView) itemView.findViewById(R.id.person_name_textview);
        roleTextView = (TextView) itemView.findViewById(R.id.role);
        actionButton = (Button) itemView.findViewById(R.id.button);
        if(isDeveloperAdapter){
            githubImageView = (ImageView) itemView.findViewById(R.id.github_image_view);
        }
    }
    
    public void assignPerson(final TeamPerson person, final HomeActivity activity){
        headerImageView.setImageResource(person.getImageRef());
        nameTextView.setText(person.getName());
        roleTextView.setText(person.getRole());
        actionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                activity.call(person.getNumber());
            }
        });
    }
    
    
    public ImageView getGithubImageView() {
        return githubImageView;
    }
}

package com.betterclever.aparoksha.activities;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.DescriptionFragment;
import com.betterclever.aparoksha.fragments.ExtraInfoFragment;
import com.betterclever.aparoksha.fragments.OrganizerFragment;
import com.betterclever.aparoksha.fragments.TimeDateFragment;
import com.betterclever.aparoksha.fragments.UpdatesFragment;
import com.betterclever.aparoksha.model.Event;
import com.betterclever.aparoksha.widgets.CircleImageView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.drawable.GlideDrawable;
import com.bumptech.glide.request.RequestListener;
import com.bumptech.glide.request.animation.GlideAnimation;
import com.bumptech.glide.request.target.SimpleTarget;
import com.bumptech.glide.request.target.Target;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import eu.long1.spacetablayout.SpaceTabLayout;
import jp.wasabeef.blurry.Blurry;

public class EventDetailActivity extends AppCompatActivity implements ValueEventListener {
    
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    @BindView(R.id.spaceTabLayout)
    SpaceTabLayout spaceTabLayout;
    @BindView(R.id.eventImageView)
    ImageView eventImageView;
    @BindView(R.id.category_imageview)
    ImageView categoryImageview;
    @BindView(R.id.event_image_view_circle)
    CircleImageView eventImageViewCircle;
    @BindView(R.id.eventTitleTextView)
    TextView eventTitleTextView;
    @BindView(R.id.team_imageview)
    ImageView teamImageview;
    
    DatabaseReference eventDbRef;
    StorageReference imageStorageRef;
    String eventID;
    
    TimeDateFragment timeDateFragment;
    DescriptionFragment descriptionFragment;
    OrganizerFragment organizerFragment;
    ExtraInfoFragment extraInfoFragment;
    UpdatesFragment updatesFragment;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_detail);
        ButterKnife.bind(this);
    
        eventID = getIntent().getStringExtra("eventID");
        init(savedInstanceState);
        
        eventDbRef = FirebaseDatabase.getInstance().getReference().child("events").child(eventID);
        
        eventDbRef.addValueEventListener(this);
    }
    
    private void init(Bundle savedInstanceState) {
        
        String extraInfoRefPath = "events/"+eventID+"/extrainfo";
        
        List<Fragment> fragmentList = new ArrayList<>();
        
        timeDateFragment = TimeDateFragment.newInstance();
        descriptionFragment = DescriptionFragment.newInstance();
        organizerFragment = OrganizerFragment.newInstance();
        extraInfoFragment = ExtraInfoFragment.newInstance(extraInfoRefPath);
        updatesFragment = UpdatesFragment.newInstance(eventID);
        
        fragmentList.add(timeDateFragment);
        fragmentList.add(descriptionFragment);
        fragmentList.add(organizerFragment);
        fragmentList.add(extraInfoFragment);
        fragmentList.add(updatesFragment);
        
        spaceTabLayout.initialize(viewPager, getSupportFragmentManager(),
            fragmentList, savedInstanceState);
    }
    
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        
        Event event = dataSnapshot.getValue(Event.class);
        imageStorageRef = FirebaseStorage.getInstance().getReference().child(event.getImage());
        
        descriptionFragment.setDescription(event.getDescription());
        timeDateFragment.update(event);
        organizerFragment.update(event.getOrganizers());
        eventTitleTextView.setText(event.getName());
        
        Glide
            .with(this)
            .using(new FirebaseImageLoader())
            .load(imageStorageRef)
            .asBitmap()
            .into(new SimpleTarget<Bitmap>(500,500) {
                @Override
                public void onResourceReady(Bitmap resource, GlideAnimation glideAnimation) {
                    Blurry.with(EventDetailActivity.this)
                        .from(resource)
                        .into(eventImageView);
                    
                    eventImageViewCircle.setImageBitmap(resource);
                }
            });
        
    }
    
    @Override
    public void onCancelled(DatabaseError databaseError) {
        
    }
}

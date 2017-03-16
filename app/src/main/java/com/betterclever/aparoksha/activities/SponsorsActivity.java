package com.betterclever.aparoksha.activities;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.Sponsor;
import com.betterclever.aparoksha.viewholder.SponsorViewHolder;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import butterknife.BindView;
import butterknife.ButterKnife;

public class SponsorsActivity extends AppCompatActivity {
    
    @BindView(R.id.sponsor_recyclerview)
    RecyclerView sponsorRecyclerview;
    
    DatabaseReference databaseReference;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sponsors);
        ButterKnife.bind(this);
        
        getSupportActionBar().setTitle("Sponsors");
        
        databaseReference = FirebaseDatabase.getInstance().getReference().child("sponsors");
        sponsorRecyclerview.setLayoutManager(new LinearLayoutManager(this));
        
        sponsorRecyclerview.setAdapter(new FirebaseRecyclerAdapter<Sponsor,SponsorViewHolder>
            (Sponsor.class,R.layout.item_sponsor, SponsorViewHolder.class,databaseReference) {
            
            @Override
            protected void populateViewHolder(SponsorViewHolder viewHolder, final Sponsor model, int position) {
                
                StorageReference ref = FirebaseStorage.getInstance().getReference().child(model.getImage());
    
                Glide.with(SponsorsActivity.this)
                    .using(new FirebaseImageLoader())
                    .load(ref)
                    .into(viewHolder.imageView);
    
                viewHolder.imageView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        
                        String url = model.getWebsite();
                        Intent i = new Intent(Intent.ACTION_VIEW);
                        i.setData(Uri.parse(url));
                        SponsorsActivity.this.startActivity(i);
    
                    }
                });
                
                viewHolder.textView.setText(model.getName());
            }
        });
        
    }
}

package com.betterclever.aparoksha.fragments;


import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.activities.EventDetailActivity;
import com.betterclever.aparoksha.model.Event;
import com.betterclever.aparoksha.viewholder.EventItemViewHolder;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

/**
 * Created by betterclever on 15/02/2016
 */
public class CategoriesFragment extends Fragment {
    
    private static final String TAG = CategoriesFragment.class.getSimpleName();
    String category;
    RecyclerView recyclerView;
    FirebaseIndexRecyclerAdapter firebaseRecyclerAdapter;
    
    public CategoriesFragment() {
    }
    
    public static CategoriesFragment newInstance(String category) {
        
        Bundle args = new Bundle();
        args.putString("CATEGORY", category);
        
        CategoriesFragment fragment = new CategoriesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        
        View v = inflater.inflate(R.layout.fragment_categories, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        
        setupRecyclerView();
        return v;
    }
    
    private void setupRecyclerView() {
        
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference("events");
        DatabaseReference keyRef = FirebaseDatabase.getInstance().getReference("categories").child(category);
    
        Log.d(TAG, "setupRecycleView() called");
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        
        firebaseRecyclerAdapter =
            new FirebaseIndexRecyclerAdapter<Event, EventItemViewHolder>(
                Event.class,
                R.layout.item_days_view,
                EventItemViewHolder.class,
                keyRef,
                eventsRef) {
                @Override
                protected void populateViewHolder(EventItemViewHolder viewHolder,
                                                  Event model, final int position) {
                    viewHolder.getDateTextView().setText(model.getTime());
                    viewHolder.getEventNameTextView().setText(model.getName());
    
                    StorageReference ref = FirebaseStorage.getInstance().getReference().child(model.getImage());
                    
                    Log.d(TAG,ref.toString());
                    
                    Glide.with(getActivity())
                        .using(new FirebaseImageLoader())
                        .load(ref)
                        .into(viewHolder.getEventImageView());
    
                    viewHolder.getEventImageView().setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {
                            Intent intent = new Intent(getActivity(), EventDetailActivity.class);
                            String id = firebaseRecyclerAdapter.getRef(position).getKey();
                            intent.putExtra("eventID",id);
                            getContext().startActivity(intent);
                        }
                    });
                    
                }
            };
        
        recyclerView.setAdapter(firebaseRecyclerAdapter);
        
    }
    
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        category = getArguments().getString("CATEGORY");
    }
}

package com.betterclever.aparoksha.fragments;


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
import com.betterclever.aparoksha.model.Event;
import com.betterclever.aparoksha.viewholder.EventItemViewHolder;
import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by betterclever on 15/02/2016
 */
public class Categories extends Fragment {
    
    private static final String TAG = Categories.class.getSimpleName();
    String category;
    RecyclerView recyclerView;
    
    public Categories() {
    }
    
    public static Categories newInstance(String category) {
        
        Bundle args = new Bundle();
        args.putString("CATEGORY", category);
        
        Categories fragment = new Categories();
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
        
        final FirebaseIndexRecyclerAdapter firebaseRecyclerAdapter =
            new FirebaseIndexRecyclerAdapter<Event, EventItemViewHolder>(
                Event.class,
                R.layout.item_days_view,
                EventItemViewHolder.class,
                keyRef,
                eventsRef) {
                @Override
                protected void populateViewHolder(EventItemViewHolder viewHolder,
                                                  Event model, int position) {
                    viewHolder.getDateTextView().setText(model.getTime());
                    viewHolder.getEventNameTextView().setText(model.getName());
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

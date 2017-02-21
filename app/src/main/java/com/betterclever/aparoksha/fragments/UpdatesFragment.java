package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.Update;
import com.betterclever.aparoksha.viewholder.UpdateViewholder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class UpdatesFragment extends Fragment {
    
    RecyclerView recyclerView;
    
    public UpdatesFragment() {
        
    }
    
    public static UpdatesFragment newInstance() {
        
        Bundle args = new Bundle();
        
        UpdatesFragment fragment = new UpdatesFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v =  inflater.inflate(R.layout.fragment_updates, container, false);
        recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        init();
        return v;
    }
    
    private void init() {
    
        DatabaseReference ref = FirebaseDatabase.getInstance().getReference("updates");
        FirebaseRecyclerAdapter adapter = new FirebaseRecyclerAdapter<Update,UpdateViewholder>(
            Update.class,
            R.layout.update_card,
            UpdateViewholder.class,
            ref
        ) {
            @Override
            protected void populateViewHolder(UpdateViewholder viewHolder, Update model, int position) {
                viewHolder.setData(model);
            }
        };
        
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setAdapter(adapter);
    }
    
    
}

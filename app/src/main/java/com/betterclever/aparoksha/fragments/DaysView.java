package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.Event;
import com.betterclever.aparoksha.viewholder.EventItemViewHolder;
import com.bumptech.glide.Glide;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.storage.images.FirebaseImageLoader;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

public class DaysView extends Fragment {

    public static final String TAG = DaysView.class.getSimpleName();

    String date = "23-03-2017";

    public DaysView() {}

    public static DaysView newInstance(String date) {

        Bundle args = new Bundle();

        args.putString("DATE",date);

        DaysView fragment = new DaysView();
        fragment.setArguments(args);

        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        date = getArguments().getString("DATE");

        View v = inflater.inflate(R.layout.fragment_days_view, container, false);

        RecyclerView recyclerView = (RecyclerView) v.findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);

        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("events");
        Query query = databaseReference.orderByChild("date").equalTo(date);

        query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                Log.i(TAG, "onDataChange: "+ dataSnapshot.toString());
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Log.i(TAG,databaseError.toString());
            }
        });

        Log.i(TAG, "onCreateView: called");

        final FirebaseRecyclerAdapter firebaseRecyclerAdapter =
                new FirebaseRecyclerAdapter<Event,EventItemViewHolder> (
                        Event.class,
                        R.layout.item_days_view,
                        EventItemViewHolder.class,
                        query) {
            @Override
            protected void populateViewHolder(EventItemViewHolder viewHolder,
                                              Event model, int position) {


                Log.i("Hi","Yo");
/*
                StorageReference ref = FirebaseStorage.getInstance().getReference().child(model.getImage());

                Glide.with(getActivity())
                        .using(new FirebaseImageLoader())
                        .load(ref)
                        .into(viewHolder.getEventImageView());
*/

                viewHolder.getDateTextView().setText(model.getDate());
                viewHolder.getEventNameTextView().setText(model.getName());

            }
        };

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),2));
        //recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));
        recyclerView.setAdapter(firebaseRecyclerAdapter);

        return v;

    }

}

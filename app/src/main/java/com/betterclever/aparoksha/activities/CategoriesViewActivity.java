package com.betterclever.aparoksha.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.FrameLayout;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.Categories;
import com.betterclever.aparoksha.model.Event;
import com.betterclever.aparoksha.viewholder.EventItemViewHolder;
import com.firebase.ui.database.FirebaseIndexRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.lukedeighton.wheelview.transformer.ScalingItemTransformer;
import com.lukedeighton.wheelview.transformer.WheelItemTransformer;
import com.lukedeighton.wheelview.transformer.WheelSelectionTransformer;

import java.util.ArrayList;

public class CategoriesViewActivity extends AppCompatActivity {
    
    private static final String TAG = CategoriesViewActivity.class.getSimpleName();
    private WheelView wheelView;
    private RecyclerView recyclerView;
    
    String categories[] = {"Web", "Coding", "Flagship"};
    
    
    ArrayList<FirebaseIndexRecyclerAdapter> adapters;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        
        assignViews();
        init();
    }
    
    private void init() {
        
        adapters = new ArrayList<>();
        initAdapters();
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.ic_team);
            }
            
            @Override
            public int getCount() {
                return 6;
            }
        });
        
        wheelView.setWheelItemTransformer(new ScalingItemTransformer());
        
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {
                
                Log.i("position", String.valueOf(position));
                if (position%2 == 1) {
                    Log.i("position", "Web");
                    recyclerView.setAdapter(adapters.get(position%2));
                }
                
                if (position%2 == 0) {
                    Log.i("position", "coding");
                    recyclerView.setAdapter(adapters.get(position%2));
                }
            }
        });
        
    }
    
    private void initAdapters() {
        
        DatabaseReference eventsRef = FirebaseDatabase.getInstance().getReference().child("events");
        DatabaseReference categoryRef = FirebaseDatabase.getInstance().getReference().child("categories");
        
        for (String category : categories) {
            DatabaseReference keyRef = categoryRef.child(category);
            
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
            adapters.add(firebaseRecyclerAdapter);
        }
        
    }
    
    private void assignViews() {
        wheelView = (WheelView) findViewById(R.id.wheelview);
        recyclerView = (RecyclerView) findViewById(R.id.recyclerView);
    }
    
    
}

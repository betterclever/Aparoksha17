package com.betterclever.aparoksha.activities;

import android.graphics.drawable.Drawable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
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
import java.util.StringTokenizer;

public class CategoriesViewActivity extends AppCompatActivity {
    
    private static final String TAG = CategoriesViewActivity.class.getSimpleName();
    private WheelView wheelView;
    
    String categories[] = {"Web", "Coding", "Flagship"};
    
    ArrayList<Categories> fragments;
    FragmentManager fm;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        
        assignViews();
        init();
    }
    
    private void init() {
        
        fragments = new ArrayList<>();
        
        fm = getSupportFragmentManager();
        
        //initAdapters();
        initFragments();
        
        //recyclerView.setLayoutManager(new LinearLayoutManager(this));
        
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                switch (position){
                    case 0:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.symbol);
                    case 1:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.computer);
                    case 2:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.android);
                    case 3:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.web);
                    case 4:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.quiz);
                    case 5:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.game);
                    case 6:return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.electronics);
                    
                    default: return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.ic_team);
                }
            }
            
            @Override
            public int getCount() {
                return 7;
            }
        });
        
        wheelView.setWheelItemTransformer(new ScalingItemTransformer());
        
        wheelView.setOnWheelItemSelectedListener(new WheelView.OnWheelItemSelectListener() {
            @Override
            public void onWheelItemSelected(WheelView parent, Drawable itemDrawable, int position) {
                
                Log.i("position", String.valueOf(position));
                if (position%2 == 1) {
                    Log.i("position", "Web");
                    showFragment(position%2);
    
                }
                
                if (position%2 == 0) {
                    Log.i("position", "coding");
                    showFragment(position%2);
                }
            }
        });
        
    }
    
    private void initFragments() {
        for(String category: categories){
            fragments.add(Categories.newInstance(category));
        }
        
        getSupportFragmentManager().beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left,0,0,android.R.anim.slide_out_right)
            .add(R.id.frame_container,fragments.get(0),categories[0]).commit();
    }
    
    
    private void assignViews() {
        wheelView = (WheelView) findViewById(R.id.wheelview);
    }
    
    private void showFragment(int position){
        
        if( fm.getFragments().contains(fragments.get(position))){
            for(Fragment f: fm.getFragments()){
                fm.beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right)
                    .hide(f)
                    .commit();
            }
            fm.beginTransaction()
                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right)
                .show(fragments.get(position)).commit();
        }
        else {
            for(Fragment f: fm.getFragments()){
                fm.beginTransaction()
                    .setCustomAnimations(
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right,
                        android.R.anim.slide_in_left,
                        android.R.anim.slide_out_right)
                    .hide(f).commit();
            }
            fm.beginTransaction()
                .setCustomAnimations(
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right,
                    android.R.anim.slide_in_left,
                    android.R.anim.slide_out_right)
                .add(R.id.frame_container, fragments.get(position)).commit();
        }
        
    }
    
    
}

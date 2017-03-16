package com.betterclever.aparoksha.activities;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.FrameLayout;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.CategoriesFragment;
import com.hanks.htextview.HTextView;
import com.lukedeighton.wheelview.WheelView;
import com.lukedeighton.wheelview.adapter.WheelAdapter;
import com.lukedeighton.wheelview.transformer.ScalingItemTransformer;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

public class CategoriesViewActivity extends AppCompatActivity {
    
    private static final String TAG = CategoriesViewActivity.class.getSimpleName();
    @BindView(R.id.wheelview)
    WheelView wheelView;
    @BindView(R.id.category_textview)
    HTextView categoryTextview;
    @BindView(R.id.frame_container)
    FrameLayout frameContainer;
    
    String categories[] = {"Flagship", "Coding", "Web", "Quiz", "Gaming", "Electronics", "Graphics"};
    
    ArrayList<CategoriesFragment> fragments;
    FragmentManager fm;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        ButterKnife.bind(this);
        init();
    }
    
    private void init() {
        
        fragments = new ArrayList<>();
        
        fm = getSupportFragmentManager();
        
        initFragments();
        
        categoryTextview.animateText("Flagship");
        
        wheelView.setAdapter(new WheelAdapter() {
            @Override
            public Drawable getDrawable(int position) {
                switch (position) {
                    case 0:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.symbol);
                    case 1:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.computer);
                    case 2:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.web);
                    case 3:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.quiz2);
                    case 4:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.game);
                    case 5:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.electronics);
                    case 6:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.graphics);
                    
                    default:
                        return ContextCompat.getDrawable(CategoriesViewActivity.this, R.drawable.ic_team);
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
                showFragment(position);
                categoryTextview.animateText(categories[position]);
                
            }
        });
        
    }
    
    private void initFragments() {
        for (String category : categories) {
            fragments.add(CategoriesFragment.newInstance(category));
        }
        
        getSupportFragmentManager().beginTransaction()
            .setCustomAnimations(android.R.anim.slide_in_left, 0, 0, android.R.anim.slide_out_right)
            .add(R.id.frame_container, fragments.get(0), categories[0]).commit();
    }
    
    private void showFragment(int position) {
        
        if (fm.getFragments().contains(fragments.get(position))) {
            for (Fragment f : fm.getFragments()) {
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
        } else {
            for (Fragment f : fm.getFragments()) {
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

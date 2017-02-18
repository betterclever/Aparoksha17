package com.betterclever.aparoksha.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.widget.FrameLayout;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.Developers;
import com.betterclever.aparoksha.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    
    Fragment homeFragment,developersFragment,contactFragment;
    
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_developers:
                    
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,developersFragment).commit();
                    
                    return true;
                
                case R.id.navigation_home:
                    
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,homeFragment).commit();
                    
                    return true;
                case R.id.navigation_contact:
                    
                    getSupportFragmentManager().beginTransaction()
                        .replace(R.id.frame,contactFragment).commit();
                    
                    return true;
            }
            return false;
        }
        
    };
    
    private void assignViews() {
        bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottom_nav_view);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
    }
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        assignViews();
        setSupportActionBar(toolbar);
        init();
    }
    
    private void init() {
        homeFragment = new HomeFragment();
        developersFragment = new Developers();
        contactFragment = new Developers();
    
        getSupportFragmentManager().beginTransaction()
            .add(R.id.frame,homeFragment).commit();
        
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }
    
    
}

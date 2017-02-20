package com.betterclever.aparoksha.activities;

import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.MenuItem;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.Developers;
import com.betterclever.aparoksha.fragments.HomeFragment;

public class HomeActivity extends AppCompatActivity {
    
    private static final String TAG = HomeActivity.class.getSimpleName();
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    
    Fragment homeFragment,developersFragment,contactFragment;
    
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_developers:
                    setFragment(developersFragment);
                    return true;
                case R.id.navigation_home:
                    setFragment(homeFragment);
                    return true;
                case R.id.navigation_contact:
                    setFragment(contactFragment);
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
        homeFragment = HomeFragment.newInstance();
        developersFragment = Developers.newInstance();
        contactFragment = Developers.newInstance();
    
        setFragment(homeFragment);
        
        bottomNavigationView.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        bottomNavigationView.getMenu().getItem(1).setChecked(true);
    }
    
    private void setFragment(Fragment f){
        FragmentManager fm = getSupportFragmentManager();
        
        if(fm.getFragments()==null){
            fm.beginTransaction().add(R.id.frame,f).commit();
            return;
        }
        
        if(fm.getFragments().contains(f)){
            Log.d(TAG, "setFragment() called with: f = [" + f + "]");
            FragmentTransaction ft = fm.beginTransaction();
            for(Fragment fragment: fm.getFragments()){
                if(fragment!=null){
                    ft.hide(fragment);
                }
            }
            ft.show(f);
            ft.commit();
        }
        else {
            FragmentTransaction ft = fm.beginTransaction();
            for(Fragment fragment: fm.getFragments()){
                if(fragment!=null){
                    ft.hide(fragment);
                }
            }
            ft.add(R.id.frame,f);
            ft.commit();
        }
    }
    
    
    
}

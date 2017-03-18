package com.betterclever.aparoksha.activities;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v4.app.ActivityCompat;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.fragments.TeamFragment;
import com.betterclever.aparoksha.fragments.HomeFragment;
import com.betterclever.aparoksha.fragments.UpdatesFragment;
import com.google.firebase.messaging.FirebaseMessaging;
import com.google.firebase.messaging.RemoteMessage;

import java.util.List;

public class HomeActivity extends AppCompatActivity {
    
    private static final String TAG = HomeActivity.class.getSimpleName();
    BottomNavigationView bottomNavigationView;
    Toolbar toolbar;
    
    private String numberToCall;
    Fragment homeFragment,developersFragment, updatesFragment;
    
    public static final  int CALL_PERMISSSION_STATUS = 123;
    
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
        = new BottomNavigationView.OnNavigationItemSelectedListener() {
        
        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_team:
                    setFragment(developersFragment);
                    return true;
                case R.id.navigation_home:
                    setFragment(homeFragment);
                    return true;
                case R.id.navigation_updates:
                    setFragment(updatesFragment);
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
        developersFragment = TeamFragment.newInstance();
        updatesFragment = UpdatesFragment.newInstance();
    
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
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_main, menu);
        return true;
    }
    
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        
        switch (item.getItemId()){
            case R.id.action_sponsers:
                startActivity(new Intent(this, SponsorsActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
            case R.id.action_about_us:
                startActivity(new Intent(this,AboutUsActivity.class));
                overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                break;
        }
        
        return super.onOptionsItemSelected(item);
    }
    
    public void call(String number){
        
        numberToCall = number;
        Intent intent = new Intent(Intent.ACTION_CALL);
        intent.setData(Uri.parse("tel:" + number));
        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {
            ActivityCompat.requestPermissions(this,
                new String[]{Manifest.permission.CALL_PHONE},CALL_PERMISSSION_STATUS);
            return;
        }
        startActivity(intent);
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
    
    @Override
    public void onRequestPermissionsResult(int requestCode,
                                           String permissions[], int[] grantResults) {
        switch (requestCode) {
            case CALL_PERMISSSION_STATUS: {
                if (grantResults.length > 0
                    && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
    
                    Intent intent = new Intent(Intent.ACTION_CALL);
                    intent.setData(Uri.parse("tel:" + numberToCall));
                    startActivity(intent);
                    
                } else {
                    Toast.makeText(this,"Calling permission not granted. Grant permission in Settings",Toast.LENGTH_SHORT);
                }
                return;
            }
        }
    }
    
    
}


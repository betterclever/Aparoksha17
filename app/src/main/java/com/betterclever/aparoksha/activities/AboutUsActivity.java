package com.betterclever.aparoksha.activities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.betterclever.aparoksha.R;

public class AboutUsActivity extends AppCompatActivity {
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_us);
    }
    
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
    }
}

package com.betterclever.aparoksha.activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.betterclever.aparoksha.R;
import com.github.jorgecastillo.FillableLoader;
import com.github.jorgecastillo.State;
import com.github.jorgecastillo.listener.OnStateChangeListener;

public class SplashActivity extends AppCompatActivity {
    
    FillableLoader fillableLoader;
    FillableLoader fillableLoader2;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        
        fillableLoader = (FillableLoader) findViewById(R.id.fillableLoader);
        fillableLoader2 = (FillableLoader) findViewById(R.id.fillableLoader2);
        
        String path1 = getResources().getString(R.string.fillable_path);
        String path2 = getResources().getString(R.string.text_fillable_path);
        fillableLoader.setSvgPath(path1);
        fillableLoader2.setSvgPath(path2);
        fillableLoader.start();
        fillableLoader2.start();
        
        fillableLoader2.setOnStateChangeListener(new OnStateChangeListener() {
            @Override
            public void onStateChange(int state) {
                if(state == State.FINISHED){
                    startActivity(new Intent(SplashActivity.this,HomeActivity.class));
                    finish();
                }
            }
        });
        
    }
}

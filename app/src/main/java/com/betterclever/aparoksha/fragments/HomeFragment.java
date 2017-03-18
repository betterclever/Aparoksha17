package com.betterclever.aparoksha.fragments;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.SwishyTransformer;
import com.betterclever.aparoksha.activities.CategoriesViewActivity;
import com.betterclever.aparoksha.activities.DaysViewActivity;
import com.betterclever.aparoksha.activities.EventDetailActivity;
import com.betterclever.aparoksha.adapters.HighlightsViewPagerAdapter;
import com.betterclever.aparoksha.utils.AutoScrollViewPager;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;


public class HomeFragment extends Fragment {
    
    private static final String TAG = HomeFragment.class.getSimpleName();
    AutoScrollViewPager viewPager;
    Button scanButton, categoryButton, dayButton;
    SwishyTransformer transformer;
    HighlightsViewPagerAdapter adapter;
    
    public HomeFragment() {
        
    }
    
    public static HomeFragment newInstance() {
        
        Bundle args = new Bundle();
        
        HomeFragment fragment = new HomeFragment();
        fragment.setArguments(args);
        return fragment;
    }
    
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_home, container, false);
    
        Log.d(TAG,
            "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        
        assignViews(v);
        init();
        return v;
    }
    
    private void init() {
        
        transformer = new SwishyTransformer();
        adapter = new HighlightsViewPagerAdapter(getActivity().getSupportFragmentManager());
        
        viewPager.setAdapter(adapter);
        viewPager.setPageTransformer(true, transformer);;
        viewPager.startAutoScroll(1000);
        viewPager.setAutoScrollDurationFactor(15);
    
        scanButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                IntentIntegrator.forSupportFragment(HomeFragment.this).initiateScan();
            }
        });
        
        categoryButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), CategoriesViewActivity.class));
                ((Activity) getContext()).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        
        dayButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(getActivity(), DaysViewActivity.class));
                ((Activity) getContext()).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
            }
        });
        
    }
    
    private void assignViews(View v){
        viewPager = (AutoScrollViewPager) v.findViewById(R.id.viewPager);
        categoryButton = (Button) v.findViewById(R.id.category_button);
        dayButton = (Button) v.findViewById(R.id.day_button);
        scanButton = (Button) v.findViewById(R.id.scan_button);
    }
    
    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data);
        if (result != null) {
            if (result.getContents() == null) {
                Toast.makeText(getContext(), "Cancelled", Toast.LENGTH_LONG).show();
            } else {
                String scannedString = result.getContents();
                Log.d(TAG, "onActivityResult: "+scannedString);
                if(scannedString.endsWith("aparoksha17-made-by-betterclever")){
                    try {
                        int code = Integer.parseInt(scannedString.substring(0, 3));
                        if(code <= 140 && code >= 100) {
                            Intent intent = new Intent(getActivity(),EventDetailActivity.class);
                            intent.putExtra("eventID",Integer.toString(code));
                            startActivity(intent);
                            ((Activity) getContext()).overridePendingTransition(R.anim.slide_in, R.anim.slide_out);
                        }
                        else {
                            Toast.makeText(getContext(), "Invalid QR Code", Toast.LENGTH_LONG).show();
                        }
                    }
                    catch (NumberFormatException e){
                        Toast.makeText(getContext(), "Invalid QR Code", Toast.LENGTH_LONG).show();
                    }
                }
                else {
                    Toast.makeText(getContext(), "Invalid QR Code", Toast.LENGTH_LONG).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    
    @Override
    public void onResume() {
        super.onResume();
        Log.d(TAG, "onResume() called");
    }
    
    
    @Override
    public void onViewStateRestored(@Nullable Bundle savedInstanceState) {
        super.onViewStateRestored(savedInstanceState);
    }
    
    @Override
    public void onHiddenChanged(boolean hidden) {
        super.onHiddenChanged(hidden);
        if(!hidden){
            final Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {
                    
                    for(int i=0;i<viewPager.getChildCount();i++){
                        View v = viewPager.getChildAt(i);
                        v.setTranslationX(0);
                        v.setTranslationY(0);
                        v.setVisibility(View.VISIBLE);
                    }
                }
            }, 400);
        }
    }
}

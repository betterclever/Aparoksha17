package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.betterclever.aparoksha.R;


public class HighlightsFragment extends Fragment {
    
    private static final String TAG = HighlightsFragment.class.getSimpleName();
    private ImageView highlightsView;
    private ImageView placeholderView;
    public String name;
    
    public HighlightsFragment() {}

    public static HighlightsFragment newInstance(int image_resid, String name) {

        Bundle args = new Bundle();
        args.putInt("IMAGERES",image_resid);
        args.putString("name",name);
        
        HighlightsFragment fragment = new HighlightsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int image_resid = getArguments().getInt("IMAGERES");
        name = getArguments().getString("name");
        
        View v = inflater.inflate(R.layout.fragment_highlights, container, false);
        
        highlightsView = (ImageView) v.findViewById(R.id.highlight_image_view);
        placeholderView = (ImageView) v.findViewById(R.id.placeholder_view);
    
        highlightsView.setVisibility(View.VISIBLE);
        placeholderView.setVisibility(View.INVISIBLE);
        
        Log.d(TAG,"Name: " + name);
        Log.d(TAG,"ImageRes ID: " + image_resid);
        
        Log.d(TAG, "onCreateView() called with: inflater = [" + inflater + "], container = [" + container + "], savedInstanceState = [" + savedInstanceState + "]");
        
        highlightsView.setImageResource(image_resid);
        
        return v;
    }
    
    public void reset() {
        if(highlightsView!=null) {
            
            highlightsView.setVisibility(View.VISIBLE);
            placeholderView.setVisibility(View.INVISIBLE);
    
            Log.d(TAG, "reset() called");
        }
    }
    
    @Override
    public void onResume() {
        super.onResume();
    
        if(highlightsView!=null) {
            highlightsView.setVisibility(View.VISIBLE);
            placeholderView.setVisibility(View.INVISIBLE);
    
            Log.d(TAG, "onResume: called");
        }
    }
}

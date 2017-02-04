package com.betterclever.aparoksha.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.betterclever.aparoksha.R;


public class HighlightsFragment extends Fragment {
    
    private ImageView highlightsView;
    
    public HighlightsFragment() {}

    public static HighlightsFragment newInstance(int image_resid) {

        Bundle args = new Bundle();
        args.putInt("IMAGERES",image_resid);
        
        HighlightsFragment fragment = new HighlightsFragment();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        int image_resid = getArguments().getInt("IMAGERES");
        
        View v = inflater.inflate(R.layout.fragment_highlights, container, false);
        highlightsView = (ImageView) v.findViewById(R.id.highlight_image_view);
        highlightsView.setImageResource(image_resid);
        
        return v;
    }

}

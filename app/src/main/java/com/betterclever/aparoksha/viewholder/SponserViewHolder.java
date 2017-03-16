package com.betterclever.aparoksha.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betterclever.aparoksha.R;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by betterclever on 3/16/2017.
 */

public class SponserViewHolder extends RecyclerView.ViewHolder {
    
    @BindView(R.id.sponsor_imageview)
    public ImageView imageView;
    
    @BindView(R.id.sponsor_textview)
    public TextView textView;
    
    public SponserViewHolder(View itemView) {
        super(itemView);
        ButterKnife.bind(this,itemView);
    }
}

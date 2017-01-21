package com.betterclever.aparoksha.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.betterclever.aparoksha.R;

/**
 * Created by betterclever on 20/01/17.
 */

public class EventItemViewHolder extends RecyclerView.ViewHolder {

    private ImageView eventImageView;
    private TextView eventNameTextView;
    private TextView dateTextView;

    public EventItemViewHolder(View itemView) {
        super(itemView);
        eventImageView = (ImageView) itemView.findViewById(R.id.event_image_view);
        eventNameTextView = (TextView) itemView.findViewById(R.id.event_name_textview);
        dateTextView = (TextView) itemView.findViewById(R.id.date_textview);
    }

    public ImageView getEventImageView() {
        return eventImageView;
    }

    public TextView getEventNameTextView() {
        return eventNameTextView;
    }

    public TextView getDateTextView() {
        return dateTextView;
    }
}

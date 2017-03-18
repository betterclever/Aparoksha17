package com.betterclever.aparoksha.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.betterclever.aparoksha.R;
import com.betterclever.aparoksha.model.Update;

/**
 * Created by betterclever on 2/20/2017.
 */

public class UpdateViewholder extends RecyclerView.ViewHolder {
    
    private TextView topicTV,dateTV,timeTV,messageTV;
    private View rootView;
    
    public UpdateViewholder(View itemView) {
        super(itemView);
        topicTV = (TextView) itemView.findViewById(R.id.topic);
        dateTV = (TextView) itemView.findViewById(R.id.date);
        timeTV = (TextView) itemView.findViewById(R.id.time);
        messageTV = (TextView) itemView.findViewById(R.id.detail);
        rootView = itemView.findViewById(R.id.rootView);
    }
    
    public TextView getTopicTV() {
        return topicTV;
    }
    
    public TextView getDateTV() {
        return dateTV;
    }
    
    public TextView getTimeTV() {
        return timeTV;
    }
    
    public TextView getMessageTV() {
        return messageTV;
    }
    
    public void setData(Update data) {
        topicTV.setText(data.getTitle());
        dateTV.setText(data.getDate());
        timeTV.setText(data.getTime());
        messageTV.setText(data.getMessage());
    }
    
    public View getRootView() {
        return rootView;
    }
}

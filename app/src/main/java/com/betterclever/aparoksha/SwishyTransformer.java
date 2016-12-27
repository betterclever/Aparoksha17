package com.betterclever.aparoksha;

import android.content.Context;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * Created by betterclever on 26/12/16.
 */

public class SwishyTransformer implements ViewPager.PageTransformer {

    public static final float MIN_SCALE = 0.2f;

    public ImageView imageView;
    public RelativeLayout.LayoutParams params;

    public SwishyTransformer(Context context){
        imageView = (ImageView) LayoutInflater.from(context).inflate(R.layout.aparoksha_logo,null);
        params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);
    }

    @Override
    public void transformPage(View page, float position) {


        System.out.println("position " + position);
        if(position < -1){

        }
        else if(position < -0.6f) {
            // -1 to -0.6

            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            page.setTranslationX(0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.ic_qr_code);
            view.setRotation(4*360*position);

        }
        else if(position < -0.4f){
            // -0.6 to -0.4
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            page.setTranslationX(0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.ic_qr_code);
            view.setRotation(4*360*position);

        }

        else if(position < 0.0f){
            //-0.4 to 0.0
            RelativeLayout rl = (RelativeLayout) page;
            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.sample);
            view.setRotation(0);

            float scaleFactor = 1 - 2 * Math.abs(position);
            page.setScaleY(scaleFactor);
            page.setScaleX(scaleFactor);
            System.out.println("pw : "+page.getWidth());
            page.setTranslationX((1-scaleFactor)/2f * page.getWidth());
        }

        else if(position < 0.4f){
            //0.0 to 0.4

            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.sample);
            view.setRotation(0);

            float scaleFactor = 1 - 2 * Math.abs(position);
            page.setScaleY(scaleFactor);
            page.setScaleX(scaleFactor);
            System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- (1-scaleFactor)/2f * page.getWidth());
        }

        else if(position < 0.6f){
            //0.4 to 0.6
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- 0.4f * page.getWidth());

            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.ic_qr_code);
            view.setRotation(4*360*position);

        }

        else if(position < 1f){
            //0.6 to 1
            page.setScaleX(0.2f);
            page.setScaleY(0.2f);
            System.out.println("pw : "+page.getWidth());
            page.setTranslationX(- 0.4f * page.getWidth());


            RelativeLayout rl = (RelativeLayout) page;

            ImageView view = (ImageView) rl.findViewById(R.id.highlightImageView);
            view.setImageResource(R.drawable.ic_qr_code);
            view.setRotation(4*360*position);
        }

        else {

        }
    }
}

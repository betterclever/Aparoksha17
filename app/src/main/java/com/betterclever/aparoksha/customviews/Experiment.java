package com.betterclever.aparoksha.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;

/**
 * Created by betterclever on 24/01/17.
 */

public class Experiment extends View {
    
    private static final String TAG = Experiment.class.getSimpleName() ;
    Paint p;
    Paint.Style style;
    int width, height;
    private Path path;
    
    LinearGradient gradient;
    
    float delta =0;
    int n = 20;
    float cx,cy;
    float radius = 200;

    public Experiment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        path = new Path();
        path.addCircle(width/2,height/2,50, Path.Direction.CW);
        p = new Paint();
        width = getMeasuredWidth();
        height = getMeasuredHeight();
        cx = width/2;
        cy = height/2;
        
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
        cx = width/2;
        cy = height/2;
        
        gradient = new LinearGradient(cx-200,cy-200,cx+300,cy+200,
            Color.argb(128,255,255,0),Color.argb(128,255,128,50), Shader.TileMode.MIRROR);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
    
        //Log.i(TAG, "onDraw() called with: canvas = [" + canvas + "]");
        //radius += 0.5;
        //p.setStyle(Paint.Style.FILL);
        //p.setColor(Color.CYAN);
        
        canvas.drawColor(0, PorterDuff.Mode.CLEAR);
        
        delta += 0.05;
        for (int i = 0; i < n ; i++) {
            
            float pivx = (float) (cx+radius*Math.cos(i*2*Math.PI/n + delta));
            float pivy = (float) (cy+radius*Math.sin(i*2*Math.PI/n + delta));
           
            //Log.i("pivx", String.valueOf(pivx));
            //Log.i("pivy", String.valueOf(pivy));
            
            p.setShader(gradient);
            canvas.translate(pivx,pivy);
            canvas.rotate((float) (i*360/n));
            canvas.translate(-pivx,-pivy);
    
            canvas.drawRect(pivx,pivy,pivx+40,pivy+200,p);
            //canvas.drawCircle(pivx,pivy,30,p);
            
            //Log.i("angle", String.valueOf((float) (-i*2*Math.PI/n)));
            canvas.translate(pivx,pivy);
            canvas.rotate((float) (-i*360/n));
            canvas.translate(-pivx,-pivy);
    
        }
        //canvas.drawCircle(width/2,height/2,radius,p);
        
        Log.i(TAG, String.valueOf(canvas.isHardwareAccelerated()));
        invalidate();
    }
}

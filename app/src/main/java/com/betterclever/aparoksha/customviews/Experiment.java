package com.betterclever.aparoksha.customviews;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by betterclever on 24/01/17.
 */

public class Experiment extends View {

    Paint p;
    int width, height;
    private Path path;
    int radius = 60;

    public Experiment(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        path = new Path();
        path.addCircle(width/2,height/2,50, Path.Direction.CW);

        width = getMeasuredWidth();
        height = getMeasuredHeight();
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        width = w;
        height = h;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        p.setStyle(Paint.Style.FILL);
        p.setColor(Color.CYAN);
        canvas.drawCircle(width/2,height/2,radius,p);

    }
}

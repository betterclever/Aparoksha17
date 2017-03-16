package com.betterclever.aparoksha.customviews;

import android.content.Context;
import android.opengl.GLSurfaceView;
import android.util.AttributeSet;

/**
 * Created by betterclever on 24/01/17.
 */

public class MySurfaceView extends GLSurfaceView {

    private Renderer renderer;

    public MySurfaceView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

}

package com.valiantdots.hueview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.LinearLayout;

/**
 * Created by Kenny Paredes
 */

public class HueView_LinearLayout extends LinearLayout {
    Colorify colorify;

    public HueView_LinearLayout(Context context) {
        super(context);
        initialize();
    }

    public HueView_LinearLayout(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize(){
        colorify=new Colorify(this,0);
    }

    public void initialize( double sat,double light,int speed){
        colorify.stopRepeating();
        colorify = new Colorify(sat,light,speed,this,0,null,null,0,0);
    }

    public void stop(String hexColor){
        colorify.stopRepeating();
        colorify.stopColor(hexColor);
    }
}

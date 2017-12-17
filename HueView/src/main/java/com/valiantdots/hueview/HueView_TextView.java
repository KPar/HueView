package com.valiantdots.hueview;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

/**
 * Created by Kenny Paredes
 */

public class HueView_TextView extends android.support.v7.widget.AppCompatTextView {
    Colorify colorify;

    public HueView_TextView(Context context) {
        super(context);
        initialize();
    }

    public HueView_TextView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initialize();
    }

    private void initialize(){
        colorify=new Colorify(this,1);
    }

   //apply to background
    public void initialize(double sat,double light,int speed){
        colorify.stopRepeating();
        colorify = new Colorify(sat,light,speed,this, 1, null,null,0,0);
    }

    //apply to background with static text color
    public void initializeStaticText(double sat,double light,int speed, String textColor){
        colorify.stopRepeating();
        colorify = new Colorify(sat,light,speed,this, 1, null,textColor,0,0);
    }

    //apply to text
    public void initialize( double sat,double light,int speed, String backgroundColor){
        colorify.stopRepeating();
        colorify = new Colorify(sat,light,speed,this, 1, backgroundColor,null,0,0);
    }

    public void stop(String hexColor){
        colorify.stopRepeating();
        colorify.stopColor(hexColor);
    }
}

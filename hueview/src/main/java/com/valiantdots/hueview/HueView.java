package com.valiantdots.hueview;


import android.view.View;

/**
 * Created by Kenny Paredes.
 */

public class HueView {
    Colorify colorify;
    public void toolbarAllIcons(View toolbar){
        if(colorify!=null) {
            colorify.stopRepeating();
        }
        colorify = new Colorify(toolbar, 2);
    }

    public void toolbarOverflow(double sat, double light, int speed, View toolbar){
        if(colorify!=null) {
            colorify.stopRepeating();
        }
        colorify = new Colorify(sat,light,speed,toolbar, 2, null,null,0,0);

    }

    public void toolbarSingleIcon(double sat, double light, int speed, View toolbar, int iconPosition){
        if(colorify!=null) {
            colorify.stopRepeating();
        }
        colorify = new Colorify(sat,light,speed,toolbar, 2, null,null,1,iconPosition);
    }

    public void toolbarAllIcons(double sat, double light, int speed, View toolbar){
        if(colorify!=null) {
            colorify.stopRepeating();
        }
        colorify = new Colorify(sat,light,speed,toolbar, 2, null,null,2,0);
    }

    public void toolbarStop(String hexColor) {
        colorify.stopRepeating();
        colorify.stopToolbarColor(hexColor);
    }
}

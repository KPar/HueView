package com.valiantdots.hueview;

import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.os.Handler;
import android.support.v7.view.menu.ActionMenuItemView;
import android.support.v7.widget.ActionMenuView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.support.v7.widget.Toolbar;

/**
 * Created by Kenny Paredes
 */

class Colorify {
    private Handler handler = new Handler();
    View layout;
    TextView textView;
    double sat,light;
    int hue =0;
    int speed=10;
    int bgOrText=0;
    int staticText=0;
    Toolbar toolbar;
    int toolbarIconRange=2;
    int iconPos=0;
    int viewType=0;

    public Colorify(double sat, double light,int speed, View view,int viewType, String backgroundColor, String textColor, int toolbarIconRange,int iconPosition) {
        this.sat=sat;
        this.light=light;
        this.speed=speed;
        this.viewType=viewType;
        iconPos=iconPosition;

        if(sat>1.0){
            this.sat=1.0;
        }
        if(light>1.0){
            this.light=1.0;
        }
        switch (viewType){
            case 0:
                layout = view;
                runnable.run();
                break;
            case 1:
                textView = (TextView) view;
                if(backgroundColor!=null) {
                    textView.setBackgroundColor(Color.parseColor(backgroundColor));
                    bgOrText=1;
                }
                if(bgOrText==0 && textColor!=null){
                    staticText=1; //this instance involves a static text color
                    textView.setTextColor(Color.parseColor(textColor));
                }
                textViewRunnable.run();
                break;
            case 2: //toolbar
                toolbar=(Toolbar) view;
                this.toolbarIconRange=toolbarIconRange;
                toolbarRunnable.run();
                break;
        }
    }

    //default
    public Colorify(View view,int viewType) {
        this.sat=.85;
        this.light=.7;
        switch (viewType){
            case 0:
                layout=view;
                runnable.run();
                break;
            case 1:
                textView=(TextView) view;
                textViewRunnable.run();
                break;
            case 2:
                toolbar=(Toolbar) view;
                toolbarRunnable.run();
                break;
        }
    }

    //Views with ViewGroup as the parent
    Runnable runnable = new Runnable() {
        @Override
        public void run() {
            int[] hslArray = HSL(hue, sat, light);
            layout.setBackgroundColor(Color.parseColor(String.format("#%02x%02x%02x", hslArray[0], hslArray[1], hslArray[2])));
            ++hue;
            if (hue == 360) {
                hue = 0;
            }
            handler.postDelayed(runnable, speed);
        }
    };

    //textView
    Runnable textViewRunnable = new Runnable() {
        @Override
        public void run() {
            int[] hslArray = HSL(hue, sat, light);
            switch (bgOrText){
                case 0:
                    textView.setBackgroundColor(Color.parseColor(String.format("#%02x%02x%02x", hslArray[0], hslArray[1], hslArray[2])));
                    if(staticText==0) {
                        if ((hslArray[0] * 0.299 + hslArray[1] * 0.587 + hslArray[2] * 0.114) > 186) {
                            textView.setTextColor(Color.parseColor("#000000"));
                        } else {
                            textView.setTextColor(Color.parseColor("#ffffff"));
                        }
                    }
                    break;
                case 1:
                    textView.setTextColor(Color.parseColor(String.format("#%02x%02x%02x", hslArray[0], hslArray[1], hslArray[2])));
                    break;
            }
            ++hue;
            if (hue == 360) {
                hue = 0;
            }
            handler.postDelayed(textViewRunnable, speed);
        }
    };

    //toolbar
    Runnable toolbarRunnable = new Runnable() {
        @Override
        public void run() {
            int[] hslArray = HSL(hue, sat, light);

            final PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.parseColor(String.format("#%02x%02x%02x", hslArray[0], hslArray[1], hslArray[2])), PorterDuff.Mode.SRC_ATOP);
            switch (toolbarIconRange){
                case 0:  //overflow only
                    for (int i = 0; i < toolbar.getChildCount(); i++) {
                        final View v = toolbar.getChildAt(i);
                        if (v instanceof ImageButton) {
                            ((ImageButton) v).setColorFilter(colorFilter);
                        }
                    }
                    break;
                case 1:  //single icon only
                    for(int i = 0; i < toolbar.getChildCount(); i++) {
                        final View v = toolbar.getChildAt(i);
                        if (v instanceof ActionMenuView) {

                            final View innerView = ((ActionMenuView) v).getChildAt(iconPos);

                            if (innerView instanceof ActionMenuItemView) {
                                int drawablesCount = ((ActionMenuItemView) innerView).getCompoundDrawables().length;
                                for (int k = 0; k < drawablesCount; k++) {
                                    if (((ActionMenuItemView) innerView).getCompoundDrawables()[k] != null) {
                                        final int finalK = k;
                                        innerView.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                ((ActionMenuItemView) innerView).getCompoundDrawables()[finalK].setColorFilter(colorFilter);
                                            }
                                        });
                                    }
                                }
                            }

                        }
                    }
                    break;
                case 2:  //all icons
                    for(int i = 0; i < toolbar.getChildCount(); i++) {
                        final View v = toolbar.getChildAt(i);
                        if (v instanceof ImageButton) {
                            ((ImageButton) v).setColorFilter(colorFilter);
                        }

                        if (v instanceof ActionMenuView) {
                            for(int j = 0; j < ((ActionMenuView)v).getChildCount(); j++) {
                                final View innerView = ((ActionMenuView) v).getChildAt(j);

                                if (innerView instanceof ActionMenuItemView) {
                                    int drawablesCount = ((ActionMenuItemView) innerView).getCompoundDrawables().length;
                                    for (int k = 0; k < drawablesCount; k++) {
                                        if (((ActionMenuItemView) innerView).getCompoundDrawables()[k] != null) {
                                            final int finalK = k;
                                            innerView.post(new Runnable() {
                                                @Override
                                                public void run() {
                                                    ((ActionMenuItemView) innerView).getCompoundDrawables()[finalK].setColorFilter(colorFilter);
                                                }
                                            });
                                        }
                                    }
                                }
                            }
                        }
                    }
                    break;
            }

            ++hue;
            if (hue == 360) {
                hue = 0;
            }
            handler.postDelayed(toolbarRunnable, speed);
        }
    };


    public void stopRepeating(){
        handler.removeCallbacks(toolbarRunnable);
        handler.removeCallbacks(runnable);
        handler.removeCallbacks(textViewRunnable);
    }

    public void stopColor(String color){

        switch (viewType){
            case 0:
                layout.setBackgroundColor(Color.parseColor(color));
                break;
            case 1:
                switch (bgOrText){
                    case 0:
                        int red= Integer.valueOf(color.substring(1,3),16);
                        int green= Integer.valueOf(color.substring(3,5),16);
                        int blue= Integer.valueOf(color.substring(5,7),16);

                        textView.setBackgroundColor(Color.parseColor(color));
                        if(staticText==0) {
                            if ((red * 0.299 + green * 0.587 + blue * 0.114) > 186) {
                                textView.setTextColor(Color.parseColor("#000000"));
                            } else {
                                textView.setTextColor(Color.parseColor("#ffffff"));
                            }
                        }
                        break;
                    case 1:
                        textView.setTextColor(Color.parseColor(color));
                        break;
                }
                break;
        }
    }

    public void stopToolbarColor(String hexColor){
        final String color=hexColor;
        toolbar.post(new Runnable() {
            @Override
            public void run() {
                final PorterDuffColorFilter colorFilter = new PorterDuffColorFilter(Color.parseColor(color), PorterDuff.Mode.SRC_ATOP);
                for (int i = 0; i < toolbar.getChildCount(); i++) {
                    final View v = toolbar.getChildAt(i);
                    if (v instanceof ImageButton) {
                        ((ImageButton) v).setColorFilter(colorFilter);
                    }

                    if (v instanceof ActionMenuView) {
                        for (int j = 0; j < ((ActionMenuView) v).getChildCount(); j++) {
                            final View innerView = ((ActionMenuView) v).getChildAt(j);

                            if (innerView instanceof ActionMenuItemView) {
                                int drawablesCount = ((ActionMenuItemView) innerView).getCompoundDrawables().length;
                                for (int k = 0; k < drawablesCount; k++) {
                                    if (((ActionMenuItemView) innerView).getCompoundDrawables()[k] != null) {
                                        final int finalK = k;
                                        innerView.post(new Runnable() {
                                            @Override
                                            public void run() {
                                                ((ActionMenuItemView) innerView).getCompoundDrawables()[finalK].setColorFilter(colorFilter);
                                            }
                                        });
                                    }
                                }
                            }
                        }
                    }
                }
            }
        });


    }



    public static int[] HSL(int Hue, double Saturation, double Lightness) {
        double c = (1 - Math.abs(2 * Lightness - 1)) * Saturation;
        double x = c * (1 - Math.abs(((double) Hue / 60) % 2 - 1));
        double m = Lightness - c / 2;

        double R,G,B;

        if(Hue < 60){
            R=c;
            G=x;
            B=0;
        }else if(Hue < 120){
            R=x;
            G=c;
            B=0;
        }else if(Hue < 180){
            R=0;
            G=c;
            B=x;
        }else if(Hue < 240){
            R=0;
            G=x;
            B=c;
        }else if(Hue < 300){
            R=x;
            G=0;
            B=c;
        }else {
            R=c;
            G=0;
            B=x;
        }

        int[] RGB = {(int) Math.round(((R + m) * 255)) , (int) Math.round(((G + m) * 255)) , (int) Math.round(((B + m) * 255))};
        return RGB;
    }

}

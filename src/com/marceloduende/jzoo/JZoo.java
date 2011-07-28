package com.marceloduende.jzoo;




import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

import com.marceloduende.jzoo.graphics.ShapeFactory;
import com.marceloduende.jzoo.graphics.ShapeFactoryParameters;


public class JZoo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        
        View linearLayout =  findViewById(R.id.info);
        float[] f = new float[]{20,20,20,20,20,20,20,20};
        /*
        ShapeFactoryParameters b = new ShapeFactoryParameters()
        	.x(50).y(50).w(300).h(100).color(0xffffffff).kind("OVAL_STROKE").stroke(20);*/
        
        ShapeFactoryParameters c = new ShapeFactoryParameters()
    	.x(0).y(0).w(200).h(300).color(0xffffffff).kind("ROUND").corner(f).gradientKind("CLAMP").gradientColor1(Color.WHITE).gradientColor2(0xffff0000).gradientAngle(45);
        
        //ShapeFactory sf = new ShapeFactory(this, b);
        ShapeFactory sf1 = new ShapeFactory(this, c);
        
        //((LinearLayout) linearLayout).addView(sf);
        ((LinearLayout) linearLayout).addView(sf1);
        
    }
}
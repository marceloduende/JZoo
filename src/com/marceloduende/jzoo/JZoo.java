package com.marceloduende.jzoo;




import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.LinearLayout;

import com.marceloduende.jzoo.graphics.ShapeFactory;
import com.marceloduende.jzoo.window.WindowBoundaries;


public class JZoo extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
    }
}
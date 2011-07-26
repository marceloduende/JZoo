package com.marceloduende.jzoo;

import android.app.Activity;
import android.os.Bundle;

import com.marceloduende.jzoo.utils.DialogUtils;

public class JZoo extends Activity {
	DialogUtils progressDialog = new DialogUtils();
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
       
        //progressDialog.l(this);
        
        
        
       // progressDialog.disposeProgressBarDialog();
     
        
    }
    
}
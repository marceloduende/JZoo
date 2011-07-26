/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * KeyboardUtils km = new KeyboardUtils();
 * km.hide(editText);
 * 
 * @utility
 * It does hide the soft keyboard when an Activity is called with text fields. Soft keyboard only appears when requested.
 * 
 * 
 * 
 * LICENSE AGREEMENT:
 * It is free, I won't charge any money for this code, you can take it, change, publish or do whatever you want to do.
 * 
 * DEVELOPER'S CONTACT
 * marceloduende.com
 * marceloduende.com/blog
 * marcelo.duende@gmail.com 
 * 
 */


package com.marceloduende.jzoo.utils;

import android.text.InputType;
import android.view.MotionEvent;
import android.view.View;
import android.widget.EditText;

public class KeyboardUtils {

	/**
	 * 
	 * @param _text
	 * Hide the keyboard in a specific EditText
	 * 
	 * @return EditText
	 */
	public EditText hide(final EditText _text){
		_text.setInputType(InputType.TYPE_NULL);
		_text.setOnTouchListener(new View.OnTouchListener() {
	        public boolean onTouch(View v, MotionEvent event) {
	        	_text.setInputType(InputType.TYPE_CLASS_TEXT);
	        	_text.onTouchEvent(event);
	        	return true;
	        }
	    });
		
		return _text;
	}
		
	
	/**
	 * 
	 * @param _text
	 * Show the keyboard in a specific EditText
	 * 
	 * @return EditText
	 */
	public EditText show(final EditText _text){
		_text.setInputType(InputType.TYPE_CLASS_TEXT);
		return _text;
	}

}

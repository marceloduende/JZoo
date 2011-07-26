/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * ToastDebugger td = new ToastDebugger();
 * td.makeToast(your_activity, "text"); 
 * or
 * td.makeToast(your_activity, "text", 1); 
 * 0 = SHORT //default
 * 1 = LONG
 * 
 * @utility
 * It print on the screen the text you desire. It's good for debug purposes and/or user warnings along the app.
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

package com.marceloduende.jzoo.debugger;

import android.app.Activity;
import android.widget.Toast;

public class ToastDebugger {
	
	public static int LONG  = Toast.LENGTH_LONG;
	public static int SHORT = Toast.LENGTH_SHORT;
	
	public void makeToast(Activity _activity, String _text) {
		makeToast(_activity, _text, 0);
	}
	
	public void makeToast(Activity _activity, String _text, int _duration) {
		_duration = _duration > 0 ? LONG : SHORT;  
		Toast.makeText(_activity, _text, _duration).show();
	}
}

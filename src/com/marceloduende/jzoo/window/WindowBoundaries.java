/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * int width = WindowBoundaries.getWidth(_activity);// return the width of your screen
 * int height = WindowBoundaries.getHeight(_activity);// return the height of your screen
 * int orientation = WindowBoundaries.getOrientation(_activity); // 0 = vertical and 1 = horizontal
 * 
 * @utility
 * It does figure out the orientation, with or height of your screen, pretty useful.
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

package com.marceloduende.jzoo.window;

import android.app.Activity;
import android.content.Context;
import android.view.Display;
import android.view.WindowManager;

public class WindowBoundaries {
	
	public static int getWidth(Activity _activity){
		 Display display = ((WindowManager) _activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
	        int width = display.getWidth(); 
		return width;
	}
	
	public static int getHeight(Activity _activity){
		 Display display = ((WindowManager) _activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
	        int height = display.getHeight(); 
		return height;
	}
	
	public static int getOrientation(Activity _activity){
		 Display display = ((WindowManager) _activity.getSystemService(Context.WINDOW_SERVICE)).getDefaultDisplay(); 
	        int orientation = display.getOrientation(); 
		return orientation;
	}
}

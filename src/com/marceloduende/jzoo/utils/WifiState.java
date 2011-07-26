/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * WifiState ws = new WifiState();
 * ws.checkWifi(this); 
 * 
 * @utility
 * It does check if the wifi is turned on, otherwise it triggers a warning on the screen.
 * It is good for location usage.
 * 
 * @requirements
 * <uses-permission android:name="android.permission.ACCESS_NETWORK_STATE" />
 * <uses-permission android:name="android.permission.ACCESS_WIFI_STATE" />
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

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.net.wifi.WifiManager;

public class WifiState {
	
	public void checkWifi(Activity _activity){
		WifiManager wm = (WifiManager) _activity.getSystemService(Context.WIFI_SERVICE);
		if (wm.isWifiEnabled()) {
			// wifi enabled	
		} else {
			// it is disabled, handle it if you need
			AlertDialog.Builder alertbox = new AlertDialog.Builder(_activity);
			// set the message to display
			alertbox.setMessage("Wi-fi turned off, turn it on to get a better location result!");
			// add a neutral button to the alert box and assign a click listener
			alertbox.setNeutralButton("Ok", new DialogInterface.OnClickListener() {
						// click listener on the alert box
						public void onClick(DialogInterface arg0, int arg1) {
							// the button was clicked, continue your current activity
						}
					});
			// show dialog
			alertbox.show();
		}
	}
}

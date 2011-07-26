/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * GPSLocation l = new GPSLocation();
 * l.location(this);
 * 
 * @utility
 * It does find your location
 * 
 * @methods
 * location();
 * it start searching the location
 * 
 * disposeLocation();
 * it stop the satelite and network that is searching the location
 * 
 * @requirements
 * <uses-permission android:name="android.permission.ACCESS_FINE_LOCATION"></uses-permission>
 * <uses-permission android:name="android.permission.ACCESS_COARSE_LOCATION"></uses-permission>
 * <uses-permission android:name="android.permission.INTERNET"></uses-permission>
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

package com.marceloduende.jzoo.gps;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;

public class GPSLocation {
	
	
	private boolean 			gps_enabled 	= false;
	private boolean 			network_enabled = false;
	private LocationManager 	lm				= null;
	public  Location 			myLocation 		= null;
	public  Activity 			act;
	
	public void location(Activity _activity){
		act = _activity;
		
		if (lm == null)
			lm = (LocationManager) _activity.getSystemService(Context.LOCATION_SERVICE);
		
		try {
			gps_enabled = lm.isProviderEnabled(LocationManager.GPS_PROVIDER);
			} catch (Exception ex) {
		}
			
		try {
			network_enabled = lm.isProviderEnabled(LocationManager.NETWORK_PROVIDER);
			} catch (Exception ex) {
		}
		
		if (gps_enabled)
			lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 0, 0, locationListenerGps);
		if (network_enabled)
			lm.requestLocationUpdates(LocationManager.NETWORK_PROVIDER, 0, 0, locationListenerNetwork);
		
	}
	
	
	private LocationListener locationListenerGps = new LocationListener() {
		public void onLocationChanged(Location _location) {
			myLocation = _location;
			
			// stop searching for the location
	        // disposeLocation();
		}

		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	};

	private LocationListener locationListenerNetwork = new LocationListener() {
		public void onLocationChanged(Location _location) {
			myLocation = _location;
			
			// stop searching for the location
	        // disposeLocation();
		}

		public void onProviderDisabled(String provider) {}
		public void onProviderEnabled(String provider) {}
		public void onStatusChanged(String provider, int status, Bundle extras) {}
	};
	
	public void disposeLocation() {
		if (lm != null) {
			lm.removeUpdates(locationListenerNetwork);
			lm.removeUpdates(locationListenerGps);
		}
	}
}

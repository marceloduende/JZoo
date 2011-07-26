/**
 * 
 * @author Marcelo Duende
 * 
 * @usage
 * 
 * 1 - Download the Google Analytics JAR - http://code.google.com/mobile/analytics/download.html
 * 
 * 2 - Change the AndroidManifest.xml, add this:
 * <!-- Used for install referrer tracking -->
 * <receiver android:name="com.google.android.apps.analytics.AnalyticsReceiver"
 *		android:exported="true">
 *		<intent-filter>
 *	    	<action android:name="com.android.vending.INSTALL_REFERRER" />
 *	    </intent-filter>
 * </receiver>
 * 
 * PS: put the code above into this node:
 * <application android:icon="@drawable/icon" android:label="@string/app_name">
 * *************HERE**************
 * </application>
 * 
 * 3 - Allow the internet connection in your AndroidManifest.xml
 * <uses-permission android:name="android.permission.INTERNET"></uses-permission>
 * 
 * 4 - Call this class passing some string to save in your google analytics records
 * GA ga = new GA();
 * ga.init(your_activity);
 * ga.trackPageView("/MyPage"); //MyPage will be the tag that will appear in the google analytics report.
 * 
 * 5 - DON'T FORGET TO CREATE YOUR GOOGLE ANALYTICS ACCOUNT AND CHANGE THE STRING CALLED "GOOGLE_ANALYTICS_ID" down there
 * 
 * 6 - Have fun :)
 * 
 * @utility
 * Full report of the navigation inside of your app
 * 
 * @requirements
 * <uses-permission android:name="android.permission.INTERNET"></uses-permission>
 * 
 * // between <application>...</application>
 * <!-- Used for install referrer tracking -->
 * <receiver android:name="com.google.android.apps.analytics.AnalyticsReceiver" android:exported="true">
 * <intent-filter>
 *    <action android:name="com.android.vending.INSTALL_REFERRER" />
 * </intent-filter>
 * </receiver>
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

import com.google.android.apps.analytics.GoogleAnalyticsTracker;

public class GoogleAnalytics {

	/**
	 * Set tracker object
	 */
	public GoogleAnalyticsTracker tracker;

	/**
	 * Set Google Analytics ID
	 */
	public final String GOOGLE_ANALYTICS_ID = "UA-xxxxxx-x"; // it changes accordingly the project/client/purpose

	/**
	 * Initiates the Google Analytics
	 * 
	 * @param activity
	 */
	public void init(Activity activity) {
		tracker = GoogleAnalyticsTracker.getInstance();
		tracker.start(GOOGLE_ANALYTICS_ID, activity);
		tracker.setCustomVar(1, "Medium", "Mobile App");
		tracker.dispatch();
	}

	/**
	 * 
	 * Tracking Events
	 * 
	 * @param arg0
	 * @param arg1
	 * @param arg2
	 * @param arg3
	 */
	public void trackEvent(String arg0, String arg1, String arg2, int arg3) {
		tracker.trackEvent(arg0, arg1, arg2, arg3);
	}

	/**
	 * 
	 * Tracking Page Views
	 * 
	 * @param arg0
	 */
	public void trackPageView(String arg0) {
		tracker.trackPageView("Android/" + arg0);
	}

	/**
	 * 
	 * Stopping tracker
	 * 
	 */
	public void trackerStop() {
		tracker.stop();
	}
}

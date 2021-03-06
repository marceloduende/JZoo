/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * It is over each function below.
 * 
 * @utility
 * Display native dialogs on the screen
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
import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.ProgressDialog;
import android.content.DialogInterface;
import android.content.Intent;

import com.marceloduende.jzoo.debugger.ToastDebugger;

public class DialogUtils {
	
	public ProgressDialog progressDialog;
	public ProgressDialog progressBarDialog;
	public AlertDialog.Builder alertbox;
	
	/**
	 * ALERT DIALOG
	 * 
	 * @param _activity
	 * @param _text
	 * @param _button
	 * 
	 * @usage
	 * DialogUtils l = new DialogUtils();
	 * l.alertDialog(your_activity, "message"); // default button "OK"
	 * l.alertDialog(your_activity, "message", "neutralButtonText"); // neutral button
	 * l.alertDialog(your_activity, "message", "PositiveButtonText", "NegativeButtonText"); // neutral button
	 * 
	 */
	public void alertDialog(Activity _activity, String _text){
		alertDialog(_activity, _text, "");
	}
	public void alertDialog(Activity _activity, String _text, String _button1){
		alertDialog(_activity, _text, _button1, "");
	}
	public void alertDialog(Activity _activity, String _text, String _button1, String _button2){
		alertbox = new AlertDialog.Builder(_activity);
		alertbox.setMessage(_text);
		
		
		if(_button1 == ""){
			ToastDebugger td = new ToastDebugger();
			td.makeToast(_activity, "ERROR! You should at least set up one button", 1);
			return;
		}
		
		if(_button2 != ""){
			alertbox.setPositiveButton(_button1, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					// some action if you need
				}
			});
			alertbox.setNegativeButton(_button2, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					// some action if you need
				}
			});
			alertbox.show();
		} else if(_button1 != ""){
			alertbox.setNeutralButton(_button1, new DialogInterface.OnClickListener() {
				public void onClick(DialogInterface arg0, int arg1) {
					// some action if you need
				}
			});
			alertbox.show();
		}
		
		
	}
	
	
	
	
	
	/**
	 * 
	 * PROGRESS DIALOG
	 * 
	 * @param _activity
	 * @param _title
	 * @param _message
	 * 
	 * 
	 * @usage 
	 * DialogUtils l = new DialogUtils();
	 * l.progressDialog(your_activity, "title", "message");
	 * 
	 * To remove the box just call this method.
	 * l.disposeProgressDialog();
	 * 
	 */
	public void progressDialog(Activity _activity, String _title){
		progressDialog = ProgressDialog.show(_activity, _title, "", true);
	}
	
	public void progressDialog(Activity _activity, String _title, String _message){
		progressDialog = ProgressDialog.show(_activity, _title, _message, true);
	}
	
	public void disposeProgressDialog(){
		progressDialog.dismiss();
	}
	
	
	
	/**
	 * 
	 * PROGRESS BAR DIALOG
	 * 
	 * @param _activity
	 * @param _title
	 * 
	 * @usage 
	 * DialogUtils l = new DialogUtils();
	 * progressBarDialog(your_activity, "title");
	 * 
	 * to set the progress, take the data from your Handle and call...
	 * progressDialog.onProgress(_currentByte, _totalByte);
	 * 
	 * to remove it
	 * progressDialog.disposeProgressBarDialog();
	 * 
	 */
	public void progressBarDialog(Activity _activity){
		progressBarDialog(_activity, "");
	}
	public void progressBarDialog(Activity _activity, String _title){
		progressBarDialog = new ProgressDialog(_activity);
		progressBarDialog.setProgressStyle(ProgressDialog.STYLE_HORIZONTAL);
		progressBarDialog.setMessage(_title);
		progressBarDialog.setCancelable(false);
		progressBarDialog.show();
	}
	public void onProgress(int _currentBytes, int _totalBytes){
		progressBarDialog.setProgress(_currentBytes);
		if(_currentBytes >= _totalBytes)
			disposeProgressBarDialog();
	}
	public void disposeProgressBarDialog(){
		progressBarDialog.dismiss();
	}
	
	
	/**
	 * 
	 * @param _activity
	 * @param _tickerText
	 * @param _title
	 * @param _content
	 * 
	 * @usage 
	 * DialogUtils l = new DialogUtils();
	 * l.notificationDialog(this, R.drawable.icon, "hello", "title", "contentt");
	 * 
	 * notificationDialogActivity(Activity, int, String, String, String);
	 * 
	 */
	public void notificationDialog(Activity _activity, int _icon, String _tickerText, String _title, String _content){
		
		String ns = Activity.NOTIFICATION_SERVICE;
		NotificationManager nm = (NotificationManager) _activity.getSystemService(ns);
		
		long when = System.currentTimeMillis();
		
		Notification notification = new Notification(_icon, _tickerText, when);
		
		Intent notificationIntent = new Intent(_activity, DialogUtils.class);
		PendingIntent contentIntent = PendingIntent.getActivity(_activity, 0, notificationIntent, 0);
		notification.setLatestEventInfo(_activity, _title, _content, contentIntent);
		
		nm.notify(1, notification);
		
	}
	
	
	
	
}

/**
 * 
 * @author Marcelo Duende
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
package com.marceloduende.jzoo.core;

import java.util.ArrayList;
import java.util.List;

import android.graphics.Paint;


public interface ILineControl {
	public List<Float> mx1 		= new ArrayList<Float>();
	public List<Float> my1 		= new ArrayList<Float>();
	public List<Float> mx2 		= new ArrayList<Float>();
	public List<Float> my2 		= new ArrayList<Float>();
	public List<Paint> mpaint 	= new ArrayList<Paint>();
}

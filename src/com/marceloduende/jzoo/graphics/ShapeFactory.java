/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "OVAL");
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * @utility
 * Good to create multiple and single shapes
 * 
 * @parameters
 * String _kind; // it could be "OVAL", "RECT". Coming up new features.
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

package com.marceloduende.jzoo.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.view.View;

import com.marceloduende.jzoo.core.IShapeControl;

public class ShapeFactory extends View implements IShapeControl{

	public ShapeDrawable mDrawable;
	
	/**
	 * 
	 * @param context
	 * @param _x
	 * @param _y
	 * @param _w
	 * @param _h
	 * @param _color
	 * @param _kind
	 */
    public ShapeFactory(
    		Context context, 
    		int 	_x, 
    		int 	_y, 
    		int 	_w, 
    		int 	_h, 
    		int 	_color, 
    		String 	_kind
    		) {
    	
    	
        super(context);
        
        
        
        // managing the shape kind
        switch (kind.valueOf(_kind)){
        
	        case OVAL:
	        	mDrawable = new ShapeDrawable(new OvalShape());
	        	break;
	        	
	        case RECT:
	        	mDrawable = new ShapeDrawable(new RectShape());
	        	break;
	        
        }
        
        
        mDrawable.getPaint().setColor(_color);
        mDrawable.setBounds(_x, _y, _x + _w, _y + _h);
        mShape.add(mDrawable);
        
    }
    
    
    public enum kind
    {
        OVAL, RECT; 
    }
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < mShape.size(); i++){
        	mShape.get(i).draw(canvas);
        }
    }
    
  
	
	
	
}

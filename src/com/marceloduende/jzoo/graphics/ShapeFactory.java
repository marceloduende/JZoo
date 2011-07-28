/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * 
 * Using RECT or OVAL shapes
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "OVAL");
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * Using ROUND shapes
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 };// change it for a diferent corner;
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "ROUND", corner);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * Using stroked ROUND shapes
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 };// change it for a diferent corner;
 * int stroke = 5;// change ir for a different stroke size;
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "ROUND", corner, stroke);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * @utility
 * Good to create multiple and single shapes, rounded shapes and stroked shapes
 * 
 * @parameters
 * String _kind; // it could be "OVAL", "RECT", "ROUND". Coming up new features.
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
import android.graphics.RectF;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.Log;
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
	
	 // RECT, OVAL
	public ShapeFactory(Context context, int _x, int _y, int _w, int _h, int _color, String _kind) {
		super(context);
		float[] _fake = new float[]{5,5,5,5,5,5,5,5};
		new ShapeFactory(context, _x, _y, _w, _h, _color, _kind, _fake);
	} 

	// ROUND
	public ShapeFactory(Context context, int _x, int _y, int _w, int _h, int _color, String _kind, float[] _corner) {
		super(context);
		new ShapeFactory(context, _x, _y, _w, _h, _color, _kind, _corner, 0);
	} 
	
	// ROUND STROKE
	public ShapeFactory(Context context, int _x, int _y, int _w, int _h, int _color, String _kind, float[] _corner, int _stoke) {
        super(context);
        
        // managing the shape kind
        switch (kind.valueOf(_kind)){
        
	        case OVAL:
	        	mDrawable = new ShapeDrawable(new OvalShape());
	        	break;
	        	
	        case RECT:
	        	mDrawable = new ShapeDrawable(new RectShape());
	        	break;
	        	
	        case ROUND:
	        	float[] _innerCorner = new float[]{0,0,0,0,0,0,0,0};
	        	for (int a = 0; a<_corner.length; a++){
	        		_innerCorner[a] = Math.round(_corner[a]);
	        	}
	        	if(Integer.valueOf(_stoke) != 0){
		        	RectF f = new RectF();
		        	f.left = f.right = f.top = f.bottom = _stoke;
		        	mDrawable = new ShapeDrawable(new RoundRectShape(_corner, f, _innerCorner));
	        	} else { 
	        		Log.v("int else", "" + _stoke);
	        		mDrawable = new ShapeDrawable(new RoundRectShape(_corner, null, _innerCorner));
	        	}
	        	break;
        }
        mDrawable.getPaint().setColor(_color);
        mDrawable.setBounds(_x, _y, _x + _w, _y + _h);
        mShape.add(mDrawable);
    }
    
    public enum kind
    {
        OVAL, RECT, ROUND; 
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < mShape.size(); i++){
        	Log.v("s", "p");
        	mShape.get(i).draw(canvas);
        }
    }
}
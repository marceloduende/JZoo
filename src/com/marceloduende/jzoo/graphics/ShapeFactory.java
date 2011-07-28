/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * 
 * ***********************   Using RECT shapes   ***********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "RECT");
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * ***********************   Using RECT_STROKE shapes   ***************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "RECT_STROKE", 5);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * ***********************   Using OVAL shapes   ***********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "OVAL");
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * ***********************   Using OVAL_STROKE shapes   ***************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "OVAL_STROKE", 5);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * ***********************   Using ROUND shapes   **********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 }; // change it for a diferent corner;
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "ROUND", 0, corner);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * ***********************   Using ROUND_STROKE shapes   **************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 }; // change it for a diferent corner;
 * int stroke = 5;// change ir for a different stroke size;
 * ShapeFactory sf = new ShapeFactory(this, 20, 30, 200, 200, 0xffffffff, "ROUND_STROKE", corner, stroke);
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
	private float[] corner;
	private int stroke;
	
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
		new ShapeFactory(context, _x, _y, _w, _h, _color, _kind, 0);
	}  

	// ROUND
	public ShapeFactory(Context context, int _x, int _y, int _w, int _h, int _color, String _kind, int _stroke) {
		super(context);
		float[] _fake = new float[]{5,5,5,5,5,5,5,5};
		new ShapeFactory(context, _x, _y, _w, _h, _color, _kind, _stroke, _fake);
	} 
	
	// ROUND STROKE
	public ShapeFactory(Context context, int _x, int _y, int _w, int _h, int _color, String _kind, int _stroke, float[] _corner) {
        super(context);
        
        
        corner = _corner;
        stroke = _stroke;
        // managing the shape kind
        switch (kind.valueOf(_kind)){
	        case OVAL:
	        	mDrawable = new ShapeDrawable(new OvalShape());
	        	break;
	        	
	        case RECT:
	        	mDrawable = new ShapeDrawable(new RectShape());
	        	break;
	        	
	        case ROUND:
	        	stroke = 0;
	        	roundedShapes();
	        	break;
	        	
	        case RECT_STROKE:
	        	corner = new float[]{0,0,0,0,0,0,0,0};
	        	roundedShapes();
	        	break;
	        
	        case OVAL_STROKE:
	        	int c = 0;
	        	for(int b = 0; b<8; b++){
	        		if(c == 0){
	        			corner[b] = Math.abs(_x + _w);
	        		} else {
	        			corner[b] = Math.abs(_y + _h);
	        			c = -1;
	        		}
	        		c++;
	        	}
	        	
	        	roundedShapes();
	        	break;
	        	
	        case ROUND_STROKE:
	        	roundedShapes();
	        	break;
        }
        mDrawable.getPaint().setColor(_color);
        mDrawable.setBounds(_x, _y, _x + _w, _y + _h);
        mShape.add(mDrawable);
    }
    
    public enum kind
    {
        OVAL, RECT, ROUND, RECT_STROKE, ROUND_STROKE, OVAL_STROKE;
    }
    
    
    private void roundedShapes(){
    	float[] _innerCorner = new float[]{0,0,0,0,0,0,0,0};
    	for (int a = 0; a<corner.length; a++){
    		_innerCorner[a] = Math.round(corner[a]);
    	}
    	if(Integer.valueOf(stroke) != 0){
        	RectF f = new RectF();
        	f.left = f.right = f.top = f.bottom = stroke;
        	mDrawable = new ShapeDrawable(new RoundRectShape(corner, f, _innerCorner));
    	} else { 
    		Log.v("int else", "" + stroke);
    		mDrawable = new ShapeDrawable(new RoundRectShape(corner, null, _innerCorner));
    	}
    }
    
    
    
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < mShape.size(); i++){
        	Log.v("s", "p");
        	mShape.get(i).draw(canvas);
        }
    }
}
/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * 
 * ***********************   Using RECT shapes   ***********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("RECT");
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * 
 * ***********************   Using RECT_STROKE shapes   ***************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("RECT_STROKE").stroke(5);
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * 
 * ***********************   Using OVAL shapes   ***********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("OVAL");
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * 
 * ***********************   Using OVAL_STROKE shapes   ***************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("OVAL_STROKE").stroke(20);
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * 
 * ***********************   Using ROUND shapes   **********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 }; // change it for a diferent corner;
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("ROUND").corner(f);
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * 
 * ***********************   Using ROUND_STROKE shapes   **************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * float[] corner = new float[] {5, 5, 5, 5, 5, 5, 5, 5 }; // change it for a diferent corner;
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50).y(50).w(300).h(100).color(0xffffffff).kind("ROUND_STROKE").corner(20).stroke(5);
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * ***********************   Using GRADIENT shapes   ***********************************
 * View linearLayout =  findViewById(R.id.YOUR_LAYOUT_ID);
 * ShapeFactoryParameters b = new ShapeFactoryParameters()
 * 			.x(50)
 * 			.y(50)
 * 			.w(300)
 * 			.h(100)
 * 			.color(0xffffffff)
 * 			.kind("RECT")
 * 			.gradientKind("CLAMP")
 * 			.gradientColor1(Color.WHITE)
 * 			.gradientColor2(0xffff0000)
 * 			.gradientStartX(50)
 * 			.gradientStartY(50)
 * 			.gradientEndX(200)
 * 			.gradientEndY(100);
 * ShapeFactory sf = new ShapeFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * @utility
 * Good to create multiple and single shapes, rounded shapes and stroked shapes
 * 
 * @parameters
 * // MANDATORY
 * x();
 * y();
 * h();
 * w();
 * color();
 * kind();
 * 
 * // RELATIVE
 * corner();
 * stroke();
 * alpha();
 * gradientKind(); // "CLAMP", "REPEAT" "MIRROR"
 * gradientColor1(); // int
 * gradientColor2(); // int
 * gradientStartX(); // int
 * gradientStartY(); // int
 * gradientEndX(); // int
 * gradientEndY(); // int
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
import android.graphics.LinearGradient;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.view.View;

import com.marceloduende.jzoo.core.IShapeControl;

public class ShapeFactory extends View implements IShapeControl{

	public ShapeDrawable mDrawable;
	private float[] corner;
	private int stroke;
	private ShapeFactoryParameters builder;
	double _x1 = 0;
	double _y1 = 0;
	double _x2 = 0;
	double _y2 = 0;
	
	
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
	
	
	// ROUND STROKE
	public ShapeFactory(Context context, ShapeFactoryParameters _builder) {
        super(context);
        builder = _builder;
        corner = builder.corner();
        stroke = builder.stroke();
        // managing the shape kind
        switch (kind.valueOf(builder.kind())){
        	
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
	        			corner[b] = Math.abs(builder.x() + builder.w());
	        		} else {
	        			corner[b] = Math.abs(builder.y() + builder.h());
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
        if(builder.gradientKind() != ""){
        	LinearGradient lg = new LinearGradient(builder.gradientStartX(), builder.gradientStartY(), builder.gradientEndX(), builder.gradientEndY(), builder.gradientColor1(), builder.gradientColor2(), Shader.TileMode.valueOf(builder.gradientKind()));
        	mDrawable.getPaint().setShader(lg);
        } else {
        	mDrawable.getPaint().setColor(builder.color());
            mDrawable.getPaint().setAlpha(builder.alpha());
        }
        
        mDrawable.setBounds(builder.x(), builder.y(), builder.x() + builder.w(), builder.y() + builder.h());
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
    		mDrawable = new ShapeDrawable(new RoundRectShape(corner, null, _innerCorner));
    	}
    }
    
    @Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < mShape.size(); i++){
        	mShape.get(i).draw(canvas);
        }
    }
}
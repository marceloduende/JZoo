/**
 * 
 * @author Marcelo Duende
 * 
 * 
 * @usage 
 * 
 * View linearLayout =  findViewById(R.id.YOUR_ID);
 * LineFactoryParameters b = new LineFactoryParameters()
 * .x1(50)
 * .y1(50)
 * .x2(400)
 * .y2(200)
 * .alpha(200)
 * .color(Color.MAGENTA);
 * LineFactory sf = new LineFactory(YOUR_ACTIVITY, b);
 * ((LinearLayout) linearLayout).addView(sf);
 * 
 * 
 * LICENSE AGREEMENT:
 * It is free, I won't charge any money for this code, you can take it, change, publish or do whatever you want to do.
 * 
 * DEVELOPER'S CONTACT
 * marceloduende.com
 * marceloduende.com/blog
 * marcelo.duende@gmail.com 
 */

package com.marceloduende.jzoo.graphics;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.View;

import com.marceloduende.jzoo.core.ILineControl;

public class LineFactory extends View implements ILineControl{

	public LineFactoryParameters builder;
	private Paint paint = new Paint();
	public LineFactory(Context context, LineFactoryParameters _builder) {
		super(context);
		
		builder = _builder;
		paint.setColor(builder.color());
		paint.setAlpha(builder.alpha());
		mpaint.add(paint);
		mx1.add((float)builder.x1());
		my1.add((float)builder.y1());
		mx2.add((float)builder.x2());
		my2.add((float)builder.y2());
	}
	
	@Override
    protected void onDraw(Canvas canvas) {
        for(int i = 0; i < mx1.size(); i++){
        	canvas.drawLine(mx1.get(i), my1.get(i), mx2.get(i), my2.get(i), mpaint.get(i));
        }
    }
	
}

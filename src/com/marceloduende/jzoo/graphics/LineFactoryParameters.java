package com.marceloduende.jzoo.graphics;

public class LineFactoryParameters {
	private int _x1;
	private int _y1;
	private int _x2;
	private int _y2;
	private int _color;
	private int _alpha = 255;
	
	public LineFactoryParameters x1(int x1){
		_x1 = x1;
		return this;
	}
	public int x1(){
		return _x1;
	}
	
	
	public LineFactoryParameters y1(int y1){
		_y1 = y1;
		return this;
	}
	public int y1(){
		return _y1;
	}
	
	
	public LineFactoryParameters x2(int x2){
		_x2 = x2;
		return this;
	}
	public int x2(){
		return _x2;
	}
	
	
	public LineFactoryParameters y2(int y2){
		_y2 = y2;
		return this;
	}
	public int y2(){
		return _y2;
	}
	
	
	public LineFactoryParameters color(int color){
		_color = color;
		return this;
	}
	public int color(){
		return _color;
	}
	
	public LineFactoryParameters alpha(int alpha){
		_alpha = alpha;
		return this;
	}
	public int alpha(){
		return _alpha;
	}
	
	
}

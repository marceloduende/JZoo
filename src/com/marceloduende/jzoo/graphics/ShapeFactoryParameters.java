package com.marceloduende.jzoo.graphics;

public class ShapeFactoryParameters {
	
	private int _x;
	private int _y; 
	private int _w; 
	private int _h; 
	private int _color; 
	private String _kind; 
	private String _gradientKind = "";
	private int _stroke = 4; 
	private int _alpha = 255;
	private int _gradientColor1;
	private int _gradientColor2;
	private int _gradientAngle;
	private float[] _corner = new float[]{0,0,0,0,0,0,0,0};
	
	public ShapeFactoryParameters x(int x) {
		_x = x;
		return this;
	}
	public int x() {
		return _x;
	}
	
	public ShapeFactoryParameters y(int y) {
		_y = y;
		return this;
	}
	public int y() {
		return _y;
	}
	
	public ShapeFactoryParameters w(int w) {
		_w = w;
		return this;
	}
	public int w(){
		return _w;
	}
	
	public ShapeFactoryParameters h(int h) {
		_h = h;
		return this;
	}
	public int h(){
		return _h;
	}
	
	public ShapeFactoryParameters color(int c) {
		_color = c;
		return this;
	}
	public int color(){
		return _color;
	}
	
	public ShapeFactoryParameters kind(String k) {
		_kind = k;
		return this;
	}
	public String kind() {
		return _kind;
	}

	public ShapeFactoryParameters stroke(int s) {
		_stroke = s;
		return this;
	}
	public int stroke(){
		return _stroke;
	}

	public ShapeFactoryParameters corner(float[] c) {
		_corner = c;
		return this;
	}
	public float[] corner(){
		return _corner;
	}
	
	public ShapeFactoryParameters alpha(int a){
		_alpha = a;
		return this;
	}
	public int alpha(){
		return _alpha;
	}
	
	
	public ShapeFactoryParameters gradientKind(String g){
		_gradientKind = g;
		return this;
	}
	public String gradientKind(){
		return _gradientKind;
	}
	
	
	public ShapeFactoryParameters gradientColor1(int gc1){
		_gradientColor1 = gc1;
		return this;
	}
	public int gradientColor1(){
		return _gradientColor1;
	}
	
	
	public ShapeFactoryParameters gradientColor2(int gc2){
		_gradientColor2 = gc2;
		return this;
	}
	public int gradientColor2(){
		return _gradientColor2;
	}
	
	
	public ShapeFactoryParameters gradientAngle(int ga){
		_gradientAngle = ga;
		return this;
	}
	public int gradientAngle(){
		return _gradientAngle;
	}
	
	
	
}

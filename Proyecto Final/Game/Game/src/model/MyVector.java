package model;

public class MyVector {

	public double x;
	public double y;
	
	public MyVector(MyVector v){
		x = v.x;
		y = v.y;
	}
	
	public MyVector(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public MyVector add(MyVector v){
		MyVector vv = new MyVector(0, 0);
		vv.x = x + v.x;
	    vv.y = y + v.y;
	    return vv;
	}
	
	public MyVector substract(MyVector v){
		MyVector vv = new MyVector(0, 0);
		vv.x = x - v.x;
	    vv.y = y - v.y;
	    return vv;
	}
	
	
	public MyVector scale(double s){
		MyVector vv = new MyVector(0, 0);
		vv.x =  (x * s);
		vv.y =  (y * s);
		return vv;
	}
}

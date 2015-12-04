package model;

import java.util.ArrayList;

public class Rectangle extends Shape {

	public int w;
	public int h;
	public int right;
	public int left;
	public int top;
	public int bottom;
	public MyVector point1;
	public MyVector point2;
	public MyVector point3;
	public MyVector point4;
	public ArrayList<MyVector> points;
	
	public Rectangle(int x, int y, int w, int h) {
		super(x, y);
		points = new ArrayList<MyVector>();
		this.w = w;
		this.h = h;
		this.right = x + w;
		this.left = x;
		this.top = y;
		this.bottom = y + h;
		point1 = new MyVector(x, y);
		point2 = new MyVector(x + w, y);
		point3 = new MyVector(x + w, y + h);
		point4 = new MyVector(x, y + h);
		points.add(point1);
		points.add(point2);
		points.add(point3);
		points.add(point4);
	}

	@Override
	public boolean intersects(Object shape) {
		if(shape.getClass().getSimpleName().equals(Rectangle.class.getSimpleName())){
			Rectangle r = (Rectangle)shape;
			if(right > r.left && left < r.right &&
			   top < r.bottom && bottom > r.top)
				return true;
			else
				return false;
				
		}
		if(shape.getClass().getSimpleName().equals(Circle.class.getSimpleName())){
			Circle c = (Circle)shape;
			return intersects(this, c);
		}
		
		return false;
	}
	
	
}

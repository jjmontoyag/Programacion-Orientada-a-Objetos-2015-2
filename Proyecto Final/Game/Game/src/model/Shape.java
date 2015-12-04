package model;

public abstract class Shape {

	protected int x;
	protected int y;
	
	protected Shape(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	protected abstract boolean intersects(Object object);
	
	protected boolean intersects(Rectangle r, Circle c){
		//Circle-Rectangle collision. 
		//This is sufficient since the circle is always much bigger than the rectangle
		for(MyVector p : r.points){
		  double d = Math.sqrt((p.x - c.x) * (p.x - c.x) + (p.y - c.y) * (p.y - c.y));
		  if(d <= c.r)
			  return true;
		}
		
		return false;
	}
}

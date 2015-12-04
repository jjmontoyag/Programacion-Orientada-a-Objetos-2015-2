package model;

public class Circle extends Shape{

	int r;
	
	public Circle(int x, int y, int r) {
		super(x, y);
		this.r = r;
	}

	@Override
	public boolean intersects(Object shape) {
		if(shape.getClass().getSimpleName().equals((Rectangle.class.getSimpleName()))){
			Rectangle r = (Rectangle)shape;
			return intersects(r, this);
		}
		if(shape.getClass().getSimpleName().equals(Circle.class.getSimpleName())){
			Circle c = (Circle)shape;
			double d = Math.sqrt((x - c.x)*(x - c.x) + (y - c.y)*(y - c.y));
			if(d <= (r + c.r) - 10)
			return true;
			else
			return false;
		}
		return false;
	}

}

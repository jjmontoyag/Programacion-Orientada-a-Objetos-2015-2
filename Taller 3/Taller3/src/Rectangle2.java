
public class Rectangle2 extends Quadrilateral {

	public Rectangle2(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		
	}
	
	public double getArea(){
		return width * height;
	}

}

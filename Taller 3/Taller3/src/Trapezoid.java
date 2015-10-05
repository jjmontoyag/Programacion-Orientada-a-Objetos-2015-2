
public class Trapezoid extends Quadrilateral {

	private double base1;
	private double base2;
	
	public Trapezoid(Point p1, Point p2, Point p3, Point p4) {
		super(p1, p2, p3, p4);
		base1 = Math.abs(point3.x - point4.x);
		base2 = Math.abs(point1.x - point2.x);
	}
    
	public double getArea(){
		return (base1 + base2) * height / 2;
	}
	
}

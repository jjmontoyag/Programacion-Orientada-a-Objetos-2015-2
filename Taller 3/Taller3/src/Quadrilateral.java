
public class Quadrilateral {

	protected double width;
	protected double height;
	protected Point point1;
	protected Point point2;
	protected Point point3;
	protected Point point4;
	
	public Quadrilateral(Point p1, Point p2, Point p3, Point p4){
		point1 = p1;
		point2 = p2;
		point3 = p3;
		point4 = p4;
		width = Math.abs(point2.x - point1.x);
		height = Math.abs(point4.y - point2.y);
		
	}
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
}

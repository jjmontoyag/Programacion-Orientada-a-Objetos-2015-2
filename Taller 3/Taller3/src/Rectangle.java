
public class Rectangle extends Shape {

	

	@Override
	public double getPerimeter() {
		return 2 * width + 2 * height;
	}
	@Override
	public double getArea() {
		return width * height;
	}
	
}

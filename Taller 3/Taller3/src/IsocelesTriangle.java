
public class IsocelesTriangle extends Shape {

	@Override
	public double getPerimeter() {
		double side = Math.sqrt((base / 2) * (base / 2) + 
				height * height);
		return base + 2 * side;
	}

	@Override
	public double getArea() {
		return base * height / 2;
	}

}

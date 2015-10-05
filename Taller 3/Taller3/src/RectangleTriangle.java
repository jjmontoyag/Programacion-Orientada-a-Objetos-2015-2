
public class RectangleTriangle extends Shape {

	@Override
	public double getPerimeter(){
		double hypotenuse = Math.sqrt((base * base + height
				* height));
		return base  + height + hypotenuse;
	}

	@Override
	public double getArea() {
		return base * height / 2;
	}

	
}

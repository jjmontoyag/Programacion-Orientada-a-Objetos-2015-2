/*Abstract class to create all the shapes from, since all
 shapes have common attributes and methods.*/
public abstract class Shape {

	protected double width;
	protected double height;
	protected double base;
	protected double paraSide;
	
	public Shape(){
		width = 1;
		height = 1;
		base = 1;
	}
	public abstract double getPerimeter();
	public abstract double getArea();
	public double getWidth(){
		return width;
	}
	public double getHeight(){
		return height;
	}
	public double getBase(){
		return base;
	}
	public void setWidth(double width){
		this.width = width;
	}
	public void setHeight(double height){
		this.height = height;
	}
	public void setBase(double base){
		this.base = base;
	}
}

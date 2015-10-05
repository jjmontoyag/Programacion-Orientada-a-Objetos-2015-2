
public class Prallelogram extends Shape{

	
	private double parallelogramSide;
	
	public Prallelogram(){
		super();
		parallelogramSide = 1;
	}
	@Override
	public double getPerimeter() {
		return 2 * parallelogramSide + 2 * width;
	}

	@Override
	public double getArea() {
		return width * height;
	}
	public double getParallelogramSide(){
		return parallelogramSide;
	}
	public void setParallelogramSide(double parallelogramSide){
		this.parallelogramSide = parallelogramSide;
	}

	
}

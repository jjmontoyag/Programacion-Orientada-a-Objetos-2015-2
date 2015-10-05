
public class TestShapes {

	public static void main(String[] args) {

		//Punto 2
      Rectangle r = new Rectangle();
      System.out.print("Rectangle" + "\n" +
      "Area: " + r.getArea() + "\n" +
      "Perimeter: " + r.getPerimeter() + "\n" + 
      "Width: " + r.getWidth() + "\n" + 
      "Height: " + r.getHeight() + "\n");
      
      RectangleTriangle rt = new RectangleTriangle();
      System.out.print("Rectangle Triangle" + "\n" +
      "Area: " + rt.getArea() + "\n" +
      "Perimeter: " + rt.getPerimeter() + "\n" + 
      "Width: " + rt.getWidth() + "\n" + 
      "Height: " + rt.getHeight() + "\n");
      
      IsocelesTriangle it = new IsocelesTriangle();
      System.out.print("Isoceles Triangle" + "\n" +
      "Area: " + it.getArea() + "\n" +
      "Perimeter: " + it.getPerimeter() + "\n" + 
      "Width: " + it.getWidth() + "\n" + 
      "Height: " + it.getHeight() + "\n");
      
      Prallelogram p = new Prallelogram();
      System.out.print("Prallelogram" + "\n" +
      "Area: " + p.getArea() + "\n" +
      "Perimeter: " + p.getPerimeter() + "\n" + 
      "Width: " + p.getWidth() + "\n" + 
      "Height: " + p.getHeight() + "\n" + "\n");
      
      //Punto 3
      Point p1 = new Point(0, 0);
      Point p2 = new Point(10, 0);
      Point p3 = new Point(8, 5);
      Point p4 = new Point(3.3, 5);
      Trapezoid t = new Trapezoid(p1, p2, p3, p4);
      System.out.println("Area of the Trapezoid: " + t.getArea() + " height: " + t.getHeight());
      p1 = new Point(5, 5);
      p2 = new Point(11, 5);
      p3 = new Point(12, 20);
      p4 = new Point(6, 20);
      Parallelogram pl = new Parallelogram(p1, p2, p3, p4);
      System.out.println("Area of the Parallelogram: " + pl.getArea() + " height: " + pl.getHeight()
      + " width: " + pl.getWidth());
      p1 = new Point(17, 14);
      p2 = new Point(30, 14);
      p3 = new Point(30, 28);
      p4 = new Point(17, 28);
      Rectangle2 r2 = new Rectangle2(p1, p2, p3, p4);
      System.out.println("Area of the Rectangle2: " + r2.getArea() + " height: " + r2.getHeight()
      + " width: " + r2.getWidth());
      p1 = new Point(4, 0);
      p2 = new Point(8, 0);
      p3 = new Point(8, 4);
      p4 = new Point(4, 4);
      Square s = new Square(p1, p2, p3, p4);
      System.out.println("Area of the Square: " + s.getArea() + " side: " + s.getHeight());

	}

}

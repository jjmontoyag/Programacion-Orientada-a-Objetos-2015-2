package figura;

/**
 *
 * @author Juan David Balcazar Bedoya
 * Programacion Orientada a Objetos 2015-2
 *  Taller 2 ejercicio 2
 *
 */
public class Rectangulo {

    private double largo;
    private double ancho;

    //Constructor por defecto
    public Rectangulo() {
        largo = 1;
        ancho = 1;
    }

    // constructor
    public Rectangulo(double largo, double ancho) {
        this.largo = largo;
        this.ancho = ancho;
    }

    // calcula perimetro
    public double calcularPerimetro(double height, double width) {
        double perimetro;

        if ((height <= 0.0) || (height > 20.0)          //revisa que el alto y ancho este entre 0 y 20
                || (width <= 0.0) || (width > 20.0)) {
            System.out.println("No se puede calcular perimetro");
            return 0;
        } else {
            perimetro = (2 * height) + (2 * width);
            return perimetro;
        }

    }

    public double calcularArea(double height, double width) {
        double area;

        if ((height <= 0.0) || (height > 20.0)            //revisa que el alto y ancho este entre 0 y 20
                || (width <= 0.0) || (width > 20.0)) {
            System.out.println("No se puede calcular area");
            return 0;
        } else {
            area = height * width;
            return area;
        }
    }

    public double getLargo() {
        return largo;
    }

    public void setLargo(double largo) {
        if ((largo <= 0.0) || (largo > 20.0)) {
           // System.out.println("Numero no permitido");
        } else {
            this.largo = largo;
        }

    }

    public double getAncho() {
        return ancho;
    }

    public void setAncho(double ancho) {
        if ((ancho <= 0.0) || (ancho > 20.0)) {
            //System.out.println("Numero no permitido");
        } else {
            this.ancho = ancho;
        }
    }

}

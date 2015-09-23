package figura;

import java.util.Random;

/**
 *
 * @author Juan David Balcazar Bedoya
 * Programacion Orientada a Objetos 2015-2
 *  Taller 2 ejercicio 2
 *
 */
public class Main {

    public static void main(String[] args) {
        
        Rectangulo rect = new Rectangulo();
        double height = rect.getLargo();
        double width = rect.getAncho();
        System.out.println("Rectangulo 1 (por defecto)");
        System.out.println("Area: " + rect.calcularArea(height, width));
        System.out.println("Perimetro: " + rect.calcularArea(height, width) + "\n");

        Random r = new Random();
        for (int i = 1; i <= 9; i++) {
            // min y max para el rango
            float min = -1.0f;
            float max = 25.0f;
            
            // random de largo y ancho entre 0 y 100
            float largo = r.nextFloat() * (max - min) + min; 
            float ancho = r.nextFloat() * (max - min) + min;
            
            Rectangulo rect2 = new Rectangulo(largo, ancho);
            rect2.setAncho(ancho);
            rect2.setLargo(largo);
            
            //muestra datos de ancho, alto y calcula area y perimetro
            System.out.println("Rectangulo " + (i + 1));
            System.out.println("largo: " + rect2.getLargo());
            System.out.println("ancho: " + rect2.getAncho());
            System.out.println("Area: " + rect2.calcularArea(rect2.getLargo(), rect2.getAncho()));
            System.out.println("Perimetro: " + rect2.calcularPerimetro(rect2.getLargo(), rect2.getAncho()) + "\n");
        }
    }
}

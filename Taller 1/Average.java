package average;

import java.util.Scanner;

/**
 *
 * @author Juan David Balcázar Bedoya
 *  Programación Orientada a Objetos 2015-2
 *  Taller 1
 *  4.C Average
 */
public class Average {

    private void promedio(Scanner sc) {

        int numero;
        int suma = 0;
        int contador = 0;

        for (;;) {
            numero = sc.nextInt();
            if (numero != 9999) {
                suma = suma + numero;
                contador++;
            } else {
                System.out.println("The Average is:  " + suma / contador);
                return;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Average average = new Average();

        System.out.println("Digite los numeros para el promedio: ");
        System.out.println("9999 para salir");
        average.promedio(sc);

    }

}

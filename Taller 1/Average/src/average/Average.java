package average;

import java.util.Scanner;

/**
 *
 * @author Juan David Balcázar Bedoya Programación Orientada a Objetos 2015-2
 * Taller 1 4.C Average
 */

/*Escriba un programa que pregunte por números enteros (9999 para salir),
 calcule e imprima el promedio de los números ingresados. 
 Un ejemplo de entrada es las secuencias [999 1 15 5 9999] indicando el promedio
 de todos los valores que preceden a 9999 debe ser calculado, este debe imprimir:
 [The average is: 255] 
 */
public class Average {

    private void promedio(Scanner sc) { //Recibe un scanner para poder leer infinitos numeros
        //Declaracion variables
        int numero;
        int suma = 0;
        int contador = 0;

        for (;;) { // for infinito
            numero = sc.nextInt(); //Lectura de un numero
            if (numero != 9999) { // verifica que el numero ingresado no sea 9999
                suma = suma + numero;
                contador++;
            } else {
                System.out.println("The Average is:  " + suma / contador); //Calcula e imprime el promedio
                return;
            }
        }

    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);  // nuevo Scanner sc
        Average average = new Average();  //Nuevo Average

        System.out.println("Digite los numeros para el promedio: ");
        System.out.println("9999 para salir");
        average.promedio(sc); //llama al metodo promedio y le da como parametro sc

    }

}

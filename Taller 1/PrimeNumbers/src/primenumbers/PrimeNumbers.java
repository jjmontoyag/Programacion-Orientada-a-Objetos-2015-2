package primenumbers;

import java.util.Scanner;

/**
 *
 * @author Juan David Balcázar Bedoya Programación Orientada a Objetos 2015-2
 * Taller 1 4.E Prime Numbers
 *
 */
/*Un número primo es un numero natural que solo tiene 2 divisores, 1 y sí mismo.
 Dado un número entero (máximo 109) imprima una lista ordenada de los números primos
 menores o iguales al número ingresado.
 */
public class PrimeNumbers {

    // Metodo para calular los primos menores al digitado
    public void numeroPrimo(long numero) {
        int contador = 0;
        for (int a = 1; a <= numero; a++) { // Ciclo for para buscar los primos desde 1 hasta el numero
            for (int i = 1; i <= a; i++) { //Ciclo for para comprobar que sea primo el numero a
                if (a % i == 0) { //m
                    contador = contador + 1;
                }
            }
            if (contador == 2) {
                System.out.print(a + " ");
                contador = 0; // hace contador 0 para poder hacer el mismo proceso con el siguiente numero
            } else {
                contador = 0;
            }
        }
    }

    public static void main(String[] args) {

        long numero;
        PrimeNumbers primos = new PrimeNumbers();
        Scanner sc = new Scanner(System.in);

        System.out.println("Digite un numero: ");

        numero = sc.nextInt();
        if (numero < Math.pow(10, 9)) // verificar que el numero ingresado no sea mayor a 10^9
        {
            primos.numeroPrimo(numero);
        } else {
            System.out.println("es mayor de 10^9");
        }

    }
}

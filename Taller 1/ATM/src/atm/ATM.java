package atm;

import java.util.Scanner;

/**
 * @author Juan David Balcázar Bedoya Programación Orientada a Objetos 2015-2
 * Taller 1 4.D ATM
 * 
*/
/*
 Los clientes de un banco quieres realizar retiros de un cajero,
 Los clientes escriben el monto que quieren retirar, Luego el cajero les devuelve
 la cantidad solicitada con el menor número de monedas y billetes.
 Su tarea es simular el proceso que realiza el banco, dado un monto múltiplo de 50 pesos,
 usted debe imprimir la cantidad de billetes y monedas que daría de cada denominación. 
 Para esta tarea se usaran los siguientes tipos de billetes y monedas:
 Billetes: 1000, 2000, 5000, 10000, 20000, 50000
 Monedas: 50, 100, 200, 500
 */
public class ATM {

    private void calcularDinero(int monto) {

        //Declaracion variables, billetes y monedas
        int b50000 = 0;
        int b20000 = 0;
        int b10000 = 0;
        int b5000 = 0;
        int b2000 = 0;
        int b1000 = 0;
        int m500 = 0;
        int m200 = 0;
        int m100 = 0;
        int m50 = 0;
        int multiplo = monto % 50; //modulo del monto ingresado

        if (multiplo == 0) { // Si es multiplo de 50 hace lo siguiente 
            System.out.println("El total de billetes :");

            if (monto >= 50000) { //compreba que monto es mayor a 50000
                b50000 = monto / 50000; //obtiene la cantidad de billetes
                monto = monto % 50000; //modulo de monto, dice la cantidad faltante por calcular
                System.out.println("    " + b50000 + " billetes de $50.000"); //imprime la cantidad de billetes
            }
            if (monto >= 20000) {
                b20000 = monto / 20000;
                monto = monto % 20000;
                System.out.println("    " + b20000 + " billetes de $20.000");
            }
            if (monto >= 10000) {
                b10000 = monto / 10000;
                monto = monto % 10000;
                System.out.println("    " + b10000 + " billetes de $10.000");
            }
            if (monto >= 5000) {
                b5000 = monto / 5000;
                monto = monto % 5000;
                System.out.println("    " + b5000 + " billetes de $5.000");
            }
            if (monto >= 2000) {
                b2000 = monto / 2000;
                monto = monto % 2000;
                System.out.println("    " + b2000 + " billetes de $2.000");
            }
            if (monto >= 1000) {
                b1000 = monto / 1000;
                monto = monto % 1000;
                System.out.println("    " + b1000 + " billetes de $1.000" + "\n");
            }
            if (monto != 0) { //comprueba que se necesita entregar monedas
                System.out.println("El total de monedas :");
            }
            if (monto >= 500) {
                m500 = monto / 500;
                monto = monto % 500;
                System.out.println("    " + m500 + " monedas de $500");
            }
            if (monto >= 200) {
                m200 = monto / 200;
                monto = monto % 200;
                System.out.println("    " + m200 + " monedas de $200");
            }
            if (monto >= 100) {
                m100 = monto / 100;
                monto = monto % 100;
                System.out.println("    " + m100 + " monedas de $100");

            }
            if (monto >= 50) {
                m50 = monto / 50;
                monto = monto % 50;
                System.out.println("    " + m50 + " monedas de $50");
            }
        } else {
            System.out.println("El monto que solicita no es multiplo de 50");
        }

    }

    public static void main(String[] args) {

        ATM cajero = new ATM();
        int monto;
        Scanner sc = new Scanner(System.in); //nuevo Scanner sc
        System.out.println("________Bienvenido al ATM__________ ");
        System.out.println("Digite el monto a retirar: ");
        monto = sc.nextInt(); //lectura del dato monto

        cajero.calcularDinero(monto); //Se llama al metodo calcularDinero y le pasamos como parameto monto
    }

}

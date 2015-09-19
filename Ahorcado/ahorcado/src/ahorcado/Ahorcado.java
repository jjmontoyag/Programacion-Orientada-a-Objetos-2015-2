package ahorcado;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.Scanner;

/**
 *
 * @author Juan David Balcázar Bedoya PROGRAMACION ORIENTADA A OBJETOS 2015-2
 * JUEGO DE AHORCADO
 *
 */
public class Ahorcado {

    public int contador = 1;
    boolean gano = false; // bool para comprobar si ya gano

    // Metodo para leer el archivo txt 
    public void leerFichero() {

        String palabra = " ";
        char[] palabraChar = null; // separa el string letra por letra
        char[] lineas = null;

        File archivo = null;
        FileReader fr = null;
        BufferedReader br = null;

        int cual;
        Scanner sc = new Scanner(System.in);

        System.out.println(
                "\n Digite un numero: ");
        cual = sc.nextInt();

        try {
            archivo = new File("C:\\Users\\juandavid\\Desktop\\ahorcado\\ahorcado\\archivo.txt");
            fr = new FileReader(archivo);
            br = new BufferedReader(fr);

            // String linea;
            for (int d = 0; d < cual; d++) {
                palabra = br.readLine();
                palabraChar = palabra.toCharArray(); // separa el string letra por letra
                lineas = palabra.toCharArray();

            }

            System.out.println(palabra);
            juego(palabra, palabraChar, lineas); // llama el metodo juego y pasa los parametros necesarios
            fr.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Metodo donde se verifica el estado del juego y se van pidiendo las letras
    public void juego(String palabra, char[] palabraChar, char[] lineas) {

        char letra = 'a';
        Scanner sc = new Scanner(System.in);

        System.out.println(" Ahorcado");
        System.out.println("la palabra tiene " + palabraChar.length + " letras");

        lineas(palabraChar.length, lineas); // dibuja las lineas
        System.out.println("");

        while (estado()) {
            System.out.println("\n Digite la letra que puede estar: ");
            letra = sc.next().charAt(0);
            validar(letra, palabra, palabraChar, lineas);
            gano(lineas);
        }
    }

    // Metodo que imprime las lineas iniciales
    public void lineas(int total, char[] lineas) {

        for (int i = 0; i < total; i++) {
            lineas[i] = '_';
            System.out.print(lineas[i] + " ");
        }
    }

    public void printActual(char[] lineas) {

        for (int i = 0; i < lineas.length; i++) {
            System.out.print(lineas[i] + " ");
        }
        System.out.println("");
    }

    // Metodo en el que se va imprimiendo el muñeco ahorcado
    public void error(int a) {

        switch (a) {
            case 1:
                System.out.println("q");
                break;
            case 2:
                System.out.println("q(");
                break;
            case 3:
                System.out.println("q(X");
                break;
            case 4:
                System.out.println("q(X_");
                break;
            case 5:
                System.out.println("q(X_X");
                break;
            case 6:
                System.out.println("q(X_X)");
                break;
            case 7:
                System.out.println("q(X_X)p");
                System.out.println("Perdio!!");
                break;
        }
    }

    public void validar(char letra, String palabra, char[] palabraChar, char[] lineas) {
        int cont = 0;
        for (int a = 0; a < palabraChar.length; a++) {
            if (palabraChar[a] == letra) {
                lineas[a] = letra;
                cont++;
            }

        }
        printActual(lineas);
        if (cont == 0) {
            error(contador);
            contador++;
        }
    }

    public boolean estado() {
        if (contador > 7 || gano) {

            return false;
        }
        return true;
    }

    public void gano(char[] lineas) {
        boolean b;
        for (int a = 0; a < lineas.length; a++) {
            if (lineas[a] == '_') {
                b = false;
                return;
            }
        }

        System.out.println(" \n Gano!!");
        gano = true;

    }

    public static void main(String[] args) {

        Ahorcado ahorcado = new Ahorcado();

        ahorcado.leerFichero();

    }

}

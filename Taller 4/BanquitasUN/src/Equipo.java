import java.util.ArrayList;
import java.util.Scanner;


public class Equipo {

	public ArrayList<Jugador> jugadores;
	public String nombre;
	public String nombreSinEspacios;
	public int PJ = 0;
	public int PG = 0;
	public int PE = 0;
	public int GF = 0;
	public int GC = 0;
	public int PTS = 0;
	Scanner sc;
	
	public Equipo(String nombre){
		
		nombreSinEspacios = nombre;
		StringBuffer sb = new StringBuffer(nombre);
		sb.setLength(10);//longitud maxima para el nombre del equipo
		this.nombre = sb.toString();
		jugadores = new ArrayList<Jugador>();
		sc = new Scanner(System.in);
	}
	//Pedir info sobre cada jugador
	public void formarEquipo(){
		
		for(int i = 0; i < 11; i++){
			//Crear nuevo jugador
			Jugador j = crearJugador(i);
			jugadores.add(j);
		}
	}
	public Jugador crearJugador(int i){
		
		String n = "";//nombre
		String p = "";//posicion
		String h = "";//habilidad
		
		System.out.println("Jugador-" + (i + 1));
		System.out.println("Nombre(Sin espacios):");
		n = sc.next();
		System.out.println("Posicion:");
		p = sc.next();
		System.out.println("Habilidad:");
		h = sc.next();
		Jugador j = new Jugador(n,p, h, i + 1);
		return j;
	}
	
	public void agregarJugador(int i){
		
		 System.out.println("Entre datos del nuevo jugador");
		 Jugador j = crearJugador(i);
		 jugadores.add(j);
		 System.err.println("El jugador fue agregado");
	}
	public void remplazarJugador(int i){
		
		 System.out.println("Entre datos del nuevo jugador");
		 Jugador j = crearJugador(i);
		 jugadores.set(i, j);
		 System.err.println("El jugador fue remplazado");
	}
	public void despedirJugador(int i){
		
		jugadores.remove(i);
		System.err.println("El jugador fue despedido");
	}
	public void hacerGoleador(int i){
		
		jugadores.get(i).setGoleador(true);
	}
}

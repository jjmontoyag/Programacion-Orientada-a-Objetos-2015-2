import java.util.ArrayList;
import java.util.Scanner;




public class Torneo {

	public ArrayList<Equipo> equipos;
	private Scanner sc;
	
	public Torneo(){
		
		equipos = new ArrayList<>();
		sc = new Scanner(System.in);
		
	}
	
	public void menu(){
		
		System.out.println("1.Formar equipo");
		System.out.println("2.Imprimir tabla de posiciones");
		System.out.println("3.Ingresar resultados");
		System.out.println("4.Consultar numero de equipos");
		System.out.println("5.Consultar goleadores");
		System.out.println("6.Administrar jugadores");
		System.out.println("7.Administrar equipos");
		
		String r = sc.next();
		clearScreen();
		switch(r){
		
		case "1":
			formarEquipo();
			break;
		case "2":
			mostrarTablaPosicion();
			break;
		case "3":
			ingresarResultadosOpcion();
		    break;
		case "4":
			saberNumeroDeEquipos();
		    break;
		case "5":
			mostrarGoleadores();
			break;
		case "6":
			administrarJugadores();
			break;
		case "7":
			administrarEquipos();
			break;
		}
	}
	
	private Equipo seleccionarEquipo(){
		
		System.out.println("Seleccione un equipo");
		for(int i = 0; i < equipos.size(); i++){
			
			System.out.println(i + 1 + "." + equipos.get(i).nombre);
		}
		
		if(equipos.size() == 0)
	System.err.println("No hay equipos. Use opcion 1.Formar equipo");
		
		int i = Integer.parseInt(sc.next()) - 1;
		if(equipos.size() > 0)
		return equipos.get(i);
		else 
		return null;

		
	}
	
	public void ingresarResultadosOpcion(){
		
		String in = "";
		Equipo e = seleccionarEquipo();
		while(!in.equals("9") && e != null){
			
		System.out.println("INGRESAR RESULTADOS");	
		System.out.println("1.Partidos Jugados");
		System.out.println("2.Partidos Ganados");
		System.out.println("3.Partidos empatados");
		System.out.println("4.Goles a favor");
		System.out.println("5.Goles en contra");
		System.out.println("6.Puntos");
		System.out.println("7.Goleador");
		System.out.println("8.<--Seleccionar otro equipo");
		System.out.println("9.Salir");
		in = sc.next();
		Torneo.clearScreen();
		switch(in){
		
		case "1":
			e.PJ = getValue();
			break;
		case "2":
			e.PG = getValue();
			break;
		case "3":
			e.PE = getValue();
			break;
		case "4":
			e.GF = getValue();
			break;
		case "5":
			e.GC = getValue();
			break;
		case "6":
			e.PTS = getValue();
			break;
		case "7":
			int g = getValue();
			e.hacerGoleador(g - 1);
			break;
		case "8":
			e = seleccionarEquipo();
			break;
		default:
			
			break;
		}
	  }
	}
	
	private int getValue(){
		
		System.out.println("Ingrese valor:");
		int v = Integer.parseInt(sc.next());
		return v;
	}
	
	public void mostrarTablaPosicion(){
		
		System.out.println("****************************************");
		System.out.println("TABLA DE POSICIONES");
		System.out.printf("%1s%8s%3s%3s%3s%3s%3s\n","Equipo          ", "PJ", "PG", "PE", "GF", "GC", "PT");
		for(Equipo e : equipos){
			
		System.out.printf("%1s%4s%3s%3s%3s%3s%3s\n",e.nombre + "          ", e.PJ, e.PG, e.PE, e.GF, e.GC, e.PTS );
	  }
		
		System.out.println("****************************************");
	}
	
	public void saberNumeroDeEquipos(){
		
		for(Equipo e : equipos)
			System.out.println(e.nombre);
		System.out.println("Numero de equipos: " + equipos.size());
	}
	
	public void mostrarGoleadores(){
		
		System.out.println("Los goleadores son:");
		for(Equipo e : equipos){
			
			for(Jugador j : e.jugadores){
				
				if(j.isGoleador())
					System.out.println(j.getNombre());
			}
		}
	}
	
	public void formarEquipo(){
		
		Equipo e = crearEquipo();
		equipos.add(e);
		
	}
	private Equipo crearEquipo(){
		
		System.out.println("Ingrese nombre del nuevo equipo");
		String n = sc.next();
		Equipo e = new Equipo(n);
		e.formarEquipo();
		System.err.println("El nuevo equipo fue formado");
		return e;
	}
	
	public void administrarJugadores(){
		
		System.out.println("1.Agregar jugador");
		System.out.println("2.Remplazar jugador");
		System.out.println("3.Despedir jugador");
		String o = sc.next();
		
		switch(o){
		
		case "1":
			 agregarJugador();
			break;
		case "2":
			remplazarJugador();
			break;
		case "3":
			despedirJugador();
			break;
		}
	}
	
	public void administrarEquipos(){
		
		System.out.println("1.Agregar equipo");
		System.out.println("2.Remplazar equipo");
		System.out.println("3.Despedir equipo");
		String o = sc.next();
		
		switch(o){
		
		case "1":
			 agregarEquipo();
			break;
		case "2":
			remplazarEquipo();
			break;
		case "3":
			despedirEquipo();
			break;
		}
		
	}
	
	public void agregarJugador(){
		
		Equipo e = seleccionarEquipo();
		if(e != null) {
		
		System.out.println("Ingrese numero del jugador a agregar");
		int n = Integer.parseInt(sc.next()) - 1;
		e.agregarJugador(n);
		} 
	}
	
	public void remplazarJugador(){
		
		Equipo e = seleccionarEquipo();
		if(e != null) {
		
		System.out.println("Ingrese numero del jugador a remplazar");
		int n = Integer.parseInt(sc.next()) - 1;
		e.remplazarJugador(n);
		}
	}
	
	public void despedirJugador(){
		
		Equipo e = seleccionarEquipo();
		if(e != null) {
		
		System.out.println("Ingrese numero del jugador a despedir");
		int n = Integer.parseInt(sc.next()) - 1;
		e.despedirJugador(n);
		}
	}
	
	public void agregarEquipo(){
		
		formarEquipo();
	}
	
	public void remplazarEquipo(){
		
		System.out.println("Ingrese el nombre del equipo a remplazar");
		String n = sc.next();
		boolean exito = false;
		for(int i = 0; i < equipos.size(); i++){
			
			if(equipos.get(i).nombreSinEspacios.equals(n)){
				
				Equipo e = crearEquipo();
				equipos.set(i, e);
				System.err.println("El equipo fue remplazado");
				exito = true;
				break;
			}
		}
		if(!exito)
		System.err.println("Verifique el nombre del equipo");
	}
	
	public void despedirEquipo(){
		
		System.out.println("Ingrese el nombre del equipo a despedir");
		String n = sc.next();
		boolean exito = false;
        for(int i = 0; i < equipos.size(); i++){
			
			if(equipos.get(i).nombreSinEspacios.equals(n)){
				
				equipos.remove(i);
				System.err.println("El equipo fue despedido");
				exito = true;
				break;
			}
		}
        if(!exito)
    		System.err.println("Verifique el nombre del equipo");
	}
	public static void clearScreen(){
		
		for(int i = 0; i < 500; i++){
			
			System.out.println("");
		}
	}
}

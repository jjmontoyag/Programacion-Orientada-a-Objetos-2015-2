
public class Jugador {

	private String nombre;
	private String posicion;
	private String habilidad;
	private int numero;
	private boolean goleador = false;
	
	public Jugador(String nombre, String posicion, String habilidad,
			int numero){
		
		this.nombre = nombre;
		this.habilidad = habilidad;
		this.posicion = posicion;
		this.numero = numero;
	}
	
	public String getNombre(){
		
		return nombre;
	}
	
	public String getInfo(){
		
		return "Nombre: " + nombre + "\n" + 
		       "Posicion: " + posicion + "\n" +
			   "Habilidad: " + habilidad + "\n" +
		       "Numero: " + numero + "\n";
		
	}
	public void setGoleador(boolean goleador){
		
		this.goleador = goleador;
	}
	public boolean isGoleador(){
		
		return goleador;
	}
}

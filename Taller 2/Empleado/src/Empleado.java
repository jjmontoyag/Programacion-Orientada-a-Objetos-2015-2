
public class Empleado {
	
	private String nombre = null;
    private String apellido = null;
    private double salarioMensual;
    
    public Empleado(String nombre, String appellido, double salarioMensual){
    	
    	this.nombre = nombre;
    	this.apellido = appellido;
    	
    	if(salarioMensual < 0)
    		this.salarioMensual = 0;
    	else
    	    this.salarioMensual = salarioMensual;
    }
    
    public void incrementar(double porcentaje){
    	
    	salarioMensual += salarioMensual * 0.01 * porcentaje;
    }
    
    public String getNombre(){
    	
    	return nombre;
    }
    public String getApellido(){
    	
    	return apellido;
    }
    public double getSalarioMensual(){
    	
    	return salarioMensual;
    }
}

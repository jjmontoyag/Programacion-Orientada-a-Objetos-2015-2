import java.util.Calendar;



public abstract class Servicio {

	public enum Tipo {CUENTA, PRESTAMO};
	protected Tipo tipo;
	protected Cliente.Rol rol;

	protected boolean activo;
	protected String id;
	protected Calendar fechaApertura;
	protected Calendar fechaActual;
	
	public Servicio(){
		
		rol = Cliente.Rol.PLATEADO;
	}
	public abstract String getInfo();
	
	public abstract void actualizar();
	
	public void setClienteRol(Cliente.Rol rol){
		this.rol = rol;
		
	}
	public void setActivo(boolean activo){
		this.activo = activo;
	}
	public boolean isActivo(){
		return activo;
	}
	
}

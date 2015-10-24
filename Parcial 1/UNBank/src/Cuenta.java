import java.util.Calendar;



public abstract class Cuenta extends Servicio {

	protected double saldo;
	protected double transaccionValor;
	protected double retiroLimite;
	
	public Cuenta(double saldo, String id, Calendar fechaApertura){
		
		this.saldo = saldo;
		this.id = id;
		this.fechaApertura = fechaApertura;
		activo = true;
		if(rol.equals(Cliente.Rol.PLATEADO))
			retiroLimite = 1200000;
		if(rol.equals(Cliente.Rol.DORADO))
			retiroLimite = 5000000;
		if(rol.equals(Cliente.Rol.PLATINO))
			retiroLimite = 10000000;
	}
	public double getSaldo(){
		return saldo;
	}
	public void depositar(double cantidad){
		saldo += cantidad;
	}
	
		
	public abstract String retirar(double cantidad);
	
	public void cancelarCuenta(){
		activo = false;
		saldo = 0;
	}
	public boolean isActivo(){
		return activo;
	}
	
	@Override
	public String getInfo() {
		
		String estado;
		if(activo)
			estado = "Activo";
		else
			estado = "Innactivo";
		
		return "Tipo: Cuenta Bancaria \n" +
				"id: " + id + "\n" +
				"Estado: " +  estado + "\n" +
				"Fecha de apertura: " + fechaApertura.getTime().toString();
	}
}

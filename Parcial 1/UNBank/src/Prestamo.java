import java.util.Calendar;


public class Prestamo extends Servicio {

	protected int pagosPendientes;
	protected int diasTranscurridos;
	protected int pagosEnMora;
	protected double deuda;
	protected double cargosMora;
	protected double interes;
	protected double montoAPrestarMaximo;
	protected double mensualidad;
	public enum PagoModo{A_6, A_12, A_24, A_36};
	protected PagoModo pagoModo;
	protected boolean pago;
	protected boolean pagoMensualEfectuado;
	protected Calendar fechaFin;
	
	public Prestamo(double prestamo, String id, Calendar fechaApertura, PagoModo pagoModo){
		
	//Intereses diferentes para cada rol
		if(rol.equals(Cliente.Rol.PLATEADO))
			interes = 0.04;
		if(rol.equals(Cliente.Rol.DORADO))
			interes = 0.02;
		if(rol.equals(Cliente.Rol.PLATEADO))
			interes = 0.01;
		
		this.deuda = calDeuda(prestamo);
		this.fechaApertura = fechaApertura;
		this.id = id;
		this.pagoModo = pagoModo;
		pagosPendientes = 0;
		diasTranscurridos = 0;
		pagosEnMora = 0;
		cargosMora = 0;
		pagoMensualEfectuado = false;
		activo = true;
		//Calcula valor de la pensualidad y pagos
		if(this.pagoModo.equals(Prestamo.PagoModo.A_12)){
			mensualidad = deuda / 12;
			pagosPendientes = 12;
		}
		
		if(this.pagoModo.equals(Prestamo.PagoModo.A_24)){
			mensualidad = deuda / 24;
			pagosPendientes = 24;
		}
		
		if(this.pagoModo.equals(Prestamo.PagoModo.A_36)){
			mensualidad = deuda / 36;
			pagosPendientes = 36;
		}
			
		
	}
	
	protected double calDeuda(double prestamo){
	    return prestamo * (1 + interes);
	}

	public double getDeuda(){
		return deuda;
	}
	
	public void actualizar() {
		//Si no paga la mensualidad se multa
		//Actualiza si la cuenta esta activa
		if(activo){
		if(diasTranscurridos > 30){
			if(!pagoMensualEfectuado){
				multar(10000);
				pagosEnMora ++;
			}
			
			diasTranscurridos = 0;
		}
			
		diasTranscurridos ++;
	 }
	}

	
	public  void pagarCuota(double cantidad){
		deuda -= cantidad;
		if(pagosEnMora > 0)
		pagosEnMora--;
		pagosPendientes --;
	}
	public void cobrarTotalidadDeuda(){
		deuda = 0;
		pagosEnMora = 0;
		pagosPendientes = 0;
		cargosMora = 0;
		activo = false;
	}
	
	public  void multar(double cantidad){
		deuda += cantidad;
		cargosMora += cantidad;
	}
	
	public double getMensualidad(){
		return mensualidad;
	}
	public boolean isPago(){
		if(deuda <= 0)
		return true;
		else
		return false;
	}
	public double getMontoMaximoAPrestar(){
		return montoAPrestarMaximo;
	}
	
	@Override
	public String getInfo() {
		String estado;
		if(activo)
			estado = "Activo";
		else
			estado = "Inactivo";
		return "Tipo: Prestamo" + "\n" + 
	            "id: " + id + "\n" +
				"Forma de pago: "  + pagoModo.toString().toLowerCase() + " meses." + "\n" + 
	            "Mensualidad: " + Math.round(mensualidad * 100)/100d + "\n" + 
				"Pagos pendientes: " + pagosPendientes +  "\n" +
	            "Pagos en mora: " + pagosEnMora + "\n" +
				"Cargos por mora: " + cargosMora + "\n" +
				"Estado: " + estado + "\n" +
	            "Fecha de apertura: " + fechaApertura.getTime().toString();
	}
	
}

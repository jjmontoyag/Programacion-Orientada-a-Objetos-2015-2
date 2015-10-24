import java.util.Calendar;


public class MiniPrestamo extends Prestamo {

	public MiniPrestamo(double prestamo, String id, Calendar fechaApertura,
			PagoModo pagoModo) {
		super(prestamo, id, fechaApertura, pagoModo);
		montoAPrestarMaximo = 5000000;
	}
	
	@Override
	public String getInfo() {
		return super.getInfo() + "\n" +
	           "Nombre del servicio: " + "Mini prestamo" + "\n";
	}

}

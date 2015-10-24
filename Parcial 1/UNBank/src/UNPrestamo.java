import java.util.Calendar;


public class UNPrestamo extends Prestamo{

	
	public UNPrestamo(double deuda, String id, Calendar fechaApertura, Prestamo.PagoModo pagoModo) {
		super(deuda, id, fechaApertura, pagoModo);
		montoAPrestarMaximo = 20000000;
	}

	
	@Override
	public String getInfo() {
		return super.getInfo() + "\n"
				+ "Nombre del servicio: UNPrestamo." + "\n";
	}

}

import java.util.Calendar;


public class Hipotecario extends Prestamo{

	public Hipotecario(double prestamo, String id, Calendar fechaApertura,
			PagoModo pagoModo) {
		super(prestamo, id, fechaApertura, pagoModo);
		montoAPrestarMaximo = 70000000;
	}

	@Override
	public String getInfo() {
		return super.getInfo() + "\n" +
				"Nombre del servicio: " + "Prestamo hipotecario." + "\n";
	}

}

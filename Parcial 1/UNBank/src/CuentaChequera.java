import java.util.Calendar;


public class CuentaChequera extends Cuenta {

	public CuentaChequera(double saldo, String id, Calendar fechaApertura) {
		super(saldo, id, fechaApertura);
		
	}

	@Override
	public String retirar(double cantidad) {
         String mensaje = "";
		if(cantidad < 700000)
			transaccionValor = 900;
		if(cantidad > 700000)
			transaccionValor = 1500;
		if(cantidad > 1200000)
			transaccionValor = 2600;
		if(cantidad <= retiroLimite){
			if(cantidad + transaccionValor <= saldo)
		  saldo -= (cantidad + transaccionValor);
			else
			mensaje = "Saldo insuficiente";
	    }else
	    	mensaje = "Cantidad de retiro no permitida, limite: " + retiroLimite;
		return mensaje;
	}
	@Override
	public String getInfo() {
		return super.getInfo() + "\n" +
	            "Nombre del servicio: Cuenta de chequera." + "\n";
	}

	@Override
	public void actualizar() {
		
	}

}

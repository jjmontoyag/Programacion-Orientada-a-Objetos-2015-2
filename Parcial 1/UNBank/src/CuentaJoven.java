import java.util.Calendar;


public class CuentaJoven extends Cuenta {

	public CuentaJoven(double saldo, String id, Calendar fechaApertura) {
		super(saldo, id, fechaApertura);
		
	}


	@Override
	public String retirar(double cantidad) {
		 String mensaje= "";
		if(cantidad < 700000)
			transaccionValor = 0;
		if(cantidad > 700000)
			transaccionValor = 1200;
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
				"Nombre del servicio: Cuenta Joven." + "\n";
	}


	@Override
	public void actualizar() {
		
		
	}

}

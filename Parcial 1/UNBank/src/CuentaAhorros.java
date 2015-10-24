import java.util.Calendar;

import javax.swing.plaf.basic.BasicInternalFrameTitlePane.MaximizeAction;


public class CuentaAhorros extends Cuenta {

	public CuentaAhorros(double saldo, String id, Calendar fechaApertura) {
		super(saldo, id, fechaApertura);
		
	}

	@Override
	public String retirar(double cantidad) {
		String mensaje = "";
		if(cantidad < 700000)
			transaccionValor = 850;
		if(cantidad > 700000)
			transaccionValor = 1200;
		if(cantidad > 1200000)
			transaccionValor = 2500;
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
				"Nombre del servicio: Cuenta corriente.";
	}

	@Override
	public void actualizar() {
		
		
	}

}

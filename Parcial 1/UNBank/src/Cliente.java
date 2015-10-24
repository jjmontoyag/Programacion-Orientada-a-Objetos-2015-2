import java.util.ArrayList;
import java.util.Scanner;

public class Cliente extends Persona{

	public enum Rol{PLATEADO, DORADO, PLATINO};
	Rol rol;
	public ArrayList<Cuenta> cuentaServicios;
	public ArrayList<Prestamo> prestamoServicios;
	
	public Cliente(String nombre, String documento, String contacto, Rol rol) {
		super(nombre, documento, contacto);
		this.rol = rol;
		cuentaServicios = new ArrayList<Cuenta>();
		prestamoServicios = new ArrayList<Prestamo>();
	}

	public Rol getRol(){
		return rol;
	}
	public void getServiciosInfo(){
		
		if(cuentaServicios.size() > 0 || prestamoServicios.size() > 0){
			System.out.println("NOMBRE: " + getNombre());
			for(int i = 0; i < cuentaServicios.size(); i++){
				System.out.println(cuentaServicios.get(i).getInfo());
			}
			for(int i = 0; i < prestamoServicios.size(); i++){
				System.out.println(prestamoServicios.get(i).getInfo());
			}
		} else {
			System.out.print("Este cliente no tiene servicios" + "\n");
		}
	}
	
	public int getNumeroDeServicios(){
		return prestamoServicios.size() + cuentaServicios.size();
	}
	
	public void instalarCuentaServicio(Cuenta cuenta){
		cuentaServicios.add(cuenta);
	}
	public void instalarPrestamoServicio(Prestamo prestamo){
		prestamoServicios.add(prestamo);
	}
	private void effectuarTrans(double cantidad, App.Trans trans){
		int size = 0;
		Scanner sc = new Scanner(System.in);
		System.out.println("Servicios ofrecidos a " + getNombre().toUpperCase() + "\n" +
		"Por favor eliga uno de sus servicios"
	      );
		//Listar servicios segun transaccion
		if(trans.equals(App.Trans.CONSIGNACION) || trans.equals(App.Trans.CONSULTA_SALDO) ||
		  trans.equals(App.Trans.RETIRO) || trans.equals(App.Trans.CANCELAR_CUENTA)){
			size = cuentaServicios.size();
			if(size == 0)
				System.err.println("Usted aun no tiene servicios de Cuenta");
		for(int i = 0; i < cuentaServicios.size(); i++){
		   System.out.println(i + 1 + "." + cuentaServicios.get(i).getClass().getName());
		}
	   } else {
		   size = prestamoServicios.size();
		   if(size == 0)
				System.err.println("Usted aun no tiene servicios de Prestamo");
		   for(int j = 0; j < prestamoServicios.size(); j++){
			   System.out.println(j + 1 + "." + prestamoServicios.get(j).getClass().getName());
			 
			}
	   }
		int option = Integer.parseInt(sc.next()) - 1;
		if(option < 0 || option > (size - 1))
		 	System.err.print("Opcion no valida");
		else {
		String r;
				
			switch(trans){
			
			case PAGO:
				System.err.print("Gracias por pagar su cuota");
				prestamoServicios.get(option).pagarCuota(prestamoServicios.get(option).getMensualidad());
				break;
			case CONSULTA_DEUDA:
				System.out.println(prestamoServicios.get(option).getInfo());
				break;
			case PAGO_DEUDA:
				System.err.println("El valor total de la deuda es: " + prestamoServicios.get(option).getDeuda() + "\n" + 
			    "Desea pagar ahora? s/n");
				 r = sc.next();
				if(r.equals("s")){
				 prestamoServicios.get(option).cobrarTotalidadDeuda();
				 System.out.print("Gracias por finalizar el pago de su deuda" + "\n");
				}
				break;
			case BANCO_COBRO:
				System.err.println("La deuda del cliente " + getNombre() + " es: " + prestamoServicios.get(option).getDeuda() + "\n" + 
			    "El cliente realizara el pago? s/n, presione 'c' para cancelar");
				r = sc.next();
				if(r.equals("s")){
					prestamoServicios.get(option).cobrarTotalidadDeuda();
					System.err.println("Transaccion existosa");
				}else if(r.equals("n")){
					prestamoServicios.get(option).multar(10000);
					System.err.println("La cuenta a sido multada con $ 10.000"  + "\n");
				}
				break;	
			default:
				 
				break;
			}
			
			switch(trans){
			
			case CONSIGNACION:
				if(cuentaServicios.get(option).isActivo()){
				cuentaServicios.get(option).depositar(cantidad);
				System.err.println("Transaccion exitosa");
				} else 
				System.err.println("Esta cuenta esta inactiva");
				break;
			case RETIRO:
				if(cuentaServicios.get(option).isActivo()){
				String mensaje = cuentaServicios.get(option).retirar(cantidad);
				if(mensaje.equals(""))
				System.err.println("Por favor tome su dinero");
				else {
				System.err.println("Transaccion declinada" + "\n" + 
				"Motivo:" + mensaje);
				}
				}else
				System.err.println("Esta cuenta esta inactiva");
				break;
			case CONSULTA_SALDO:
				System.out.println("Su saldo es " + cuentaServicios.get(option).getSaldo());
				break;
			case CANCELAR_CUENTA:
				System.out.println("Retirar todo el dinero y hacer cuenta inactiva? s/n");
				r = sc.next();
				if(r.equals("s")){
					cuentaServicios.get(option).cancelarCuenta();
					System.err.print("Operación exitosa");
				}
				break;
			default:
				 
				break;
			}
		 }	 
		}
	
	public void effectuarTransaccion(double cantidad, App.Trans trans){
		if(getNumeroDeServicios() > 0)
		effectuarTrans(cantidad, trans);
		else
		System.err.println("Lo sentimos, usted aun no tiene servicios con nosotros");
		
	}
}

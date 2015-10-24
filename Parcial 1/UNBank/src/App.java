import java.util.ArrayList;
import java.util.Calendar;
import java.util.Scanner;


public class App {
	
	
	private ArrayList<Cliente> clientes;
	private Scanner scanner = new Scanner(System.in);
	private Calendar calendar;
	public enum Trans{PAGO, CONSULTA_SALDO, CONSIGNACION, RETIRO, BANCO_COBRO, PAGO_DEUDA,
		CONSULTA_DEUDA, CANCELAR_CUENTA};
	
	public void init(){
		
		clientes = new ArrayList<Cliente>();
		
	}
	public Cliente.Rol seleccionarRol(String r){
	    if(r.equals("1"))
			return Cliente.Rol.PLATEADO;
		if(r.equals("2"))
			return Cliente.Rol.DORADO;
		if(r.equals("3"))
			return Cliente.Rol.PLATINO;
		return null;
	}
   public Prestamo.PagoModo seleccioneModoPago(String r){
		if(r.equals("1"))
			return Prestamo.PagoModo.A_12;
		if(r.equals("2"))
			return Prestamo.PagoModo.A_24;
		if(r.equals("3"))
			return Prestamo.PagoModo.A_36;
		return null;
	}
	public void menu(){
		System.out.print("OPCIONES BANCO" + "\n" +
	                    "1.Crear usuario" + "\n" +
				        "2.Crear servicio para usuario" + "\n" +
	                    "3.informacion de servicos por usuario" + "\n" +
				        "4.Consultar todos los productos bancarios" + "\n" + 
				        "5.Cobrar prestamo a clientes" + "\n" + 
				        "6.Cancelar cuenta de ahorros" + "\n" + 
	                    "CAJERO" + "\n" +
	                    "7.Pagar" + "\n" +
				        "8.Consignar" + "\n" +
	                    "9.Retirar" + "\n" +
	                    "10.Consutar saldo");
		String op = scanner.next();
		String d;
		double cantidad;
		Cliente c = null;
		
		switch(op){
		
		case "1":
			crearCuenta();
			break;
		case "2":
		App.clearScreen();
		System.out.print("Digite el documento del cliente");
	    d = scanner.next();
	    c = getCliente(d);
	    if(c == null)
	    	System.err.print("El cliente no existe." + "\n");
	    else
		    crearServicio(getCliente(d));
		    break;
		case "3":
			System.out.print("Ingrese documento de cliente");
		    d = scanner.next();
			getServiciosPorUsuario(d);
			break;
		case "4":
			mostrarTodosServicios();
			break;
		case "5":
			System.out.println("1.Cobrar prestamo por cliente" + "\n" +
		                       "2.Cobrar prestamo a todos los clientes");
			d = scanner.next();
			if(d.equals("1")){
				System.out.println("Dijite documento del cliente");
				d = scanner.next();
				c = getCliente(d);
				if(c != null){
				cobrarClientePrestamo(c);
				} else
				System.err.println("Documento incorrecto");
			}else if(d.equals("2")){
				cobrarClientesPrestamo();
			}else
			System.err.println("Opcion invalida");
		    break;
		case "6":
			System.out.println("Dijite documento del cliente");
			d = scanner.next();
			c = getCliente(d);
			if(c != null){
			cancelarCuenta(c);
			} else
			System.err.println("Documento incorrecto");
			break;
		case "7":
			System.out.println("Dijite su documento");
			d = scanner.next();
			c = getCliente(d);
			if(c != null){
		    System.out.println("1.Pagar cuota" + "\n" + 
	        "2.Pagar totalidad de la deuda");
		    d = scanner.next();
		    if(d.equals("1"))
			pagarCuota(c);
		    else if(d.equals("2"))
		    pagarDeuda(c);
		    else
		    System.err.println("Opcion invalida");
		    
			} else
			System.err.println("Documento incorrecto");	
			break;
		case "8":
			System.out.println("Dijite su documento");
			d = scanner.next();
			c = getCliente(d);
			if(c != null){
			System.out.println("Ingrese la cantidad a consignar");
			cantidad = Double.parseDouble(scanner.next());
			consignar(c, cantidad);
			} else
			System.err.println("Documento incorrecto");
			break;
		case "9":
			System.out.println("Dijite su documento");
			d = scanner.next();
			c = getCliente(d);
			if(c != null){
			System.out.println("Ingrese la cantidad a retirar");
			cantidad = Double.parseDouble(scanner.next());
			retirar(c, cantidad);
			} else
			System.err.println("Documento incorrecto");
			break;
		case "10":
			System.out.println("Dijite su documento");
			d = scanner.next();
			c = getCliente(d);
			if(c != null){
			consultarSaldo(c);
			} else
			System.err.println("Documento incorrecto");
			break;
		}
		
		
	}
	public void crearCuenta(){
		App.clearScreen();
		System.out.println("Ingrese nombre(Sin espacios)");
		String nombre = scanner.next();
		System.out.println("Ingrese documento");
		String documento = scanner.next();
		System.out.println("Ingrese numero de contacto");
		String contacto = scanner.next();
		System.out.println("Seleccine rol: 1.Plateado, 2.Dorado, 3.Platino");
		Cliente.Rol r = seleccionarRol(scanner.next());
		Cliente cliente = new Cliente(nombre, documento, contacto, r);
		clientes.add(cliente);
		System.out.println("El usuario " + cliente.getNombre() + " fue creado." + "\n");
		
		
	}
	public void crearServicio(Cliente cliente){
		
		System.out.println("CREAR SERVICIO" + "\n" +
	                       "*****Cuenta*****" + "\n" +
				           "1.Cuenta joven" + "\n" +
	                       "2.Cuenta corriente" + "\n" +
				           "3.Cuenta chequera" + "\n" +
	                        "****Prestamo*****" + "\n" +
				           "4.Mini prestamo" + "\n" +
	                        "5.UNPrestamo" + "\n" +
				            "6.Prestamo hipotecario" + "\n");
		   String option = scanner.next();
		   Cuenta cuenta = null;
		   Prestamo prestamo = null;
		   Prestamo.PagoModo modo;
		   calendar = Calendar.getInstance();
		   double saldo;
		   switch(option){
		   
		   case "1":
			   System.out.print("ingrese deposito inicial");
			   saldo = Double.parseDouble(scanner.next());
			   cuenta = new CuentaJoven(saldo, cliente.getDocumento(), calendar);
			   break;
		   case "2":
			   System.out.print("ingrese deposito inicial");
			   saldo = Double.parseDouble(scanner.next());
			   cuenta = new CuentaAhorros(saldo, cliente.getDocumento(), calendar);
			   break;
		   case "3":
			   System.out.print("ingrese deposito inicial");
			   saldo = Double.parseDouble(scanner.next());
			   cuenta = new CuentaChequera(saldo, cliente.getDocumento(), calendar);
			   break;
		   case "4":
			   System.out.print("ingrese valor del prestamo");
			   saldo = Double.parseDouble(scanner.next());
			   System.out.println("Modo de pago: 1.A 12 , 2.A 24 , 3.A 36 meses");
			   modo = seleccioneModoPago(scanner.next());
			   prestamo = new MiniPrestamo(saldo, cliente.getDocumento(), calendar, modo );
			  break;
		   case "5":
			   System.out.print("ingrese valor del prestamo");
			   saldo = Double.parseDouble(scanner.next());
			   System.out.println("Modo de pago: 1.A 12 , 2.A 24 , 3.A 36 meses");
			   modo = seleccioneModoPago(scanner.next());
			   prestamo = new UNPrestamo(saldo, cliente.getDocumento(), calendar, modo);
			  break;
		   case "6":
			   System.out.print("ingrese valor del prestamo");
			   saldo = Double.parseDouble(scanner.next());
			   System.out.println("Modo de pago: 1.A 12 , 2.A 24 , 3.A 36 meses");
			   modo = seleccioneModoPago(scanner.next());
			   prestamo = new Hipotecario(saldo, cliente.getDocumento(), calendar, modo);
			  break;
		   }
		   if(cuenta != null)
			   cliente.instalarCuentaServicio(cuenta);
		   else
			   cliente.instalarPrestamoServicio(prestamo);
		   
		   System.out.println("El servicio fue creado para el cliente " + cliente.getNombre());
	}
	public void actualizar(){
		
		for(Cliente c : clientes){
			for(Cuenta cu : c.cuentaServicios){
				cu.actualizar();
			}
			for(Prestamo pre : c.prestamoServicios){
				pre.actualizar();
			}
		}
	}
	public void listarClientes(){
		App.clearScreen();
		for(int i = 0; i < clientes.size(); i++){
			System.out.println("Nombre: " + clientes.get(i).getNombre() + "\n" + 
		     "Documento: " + clientes.get(i).getDocumento());
		}
	}
	public Cliente getCliente(String doc){
        for(int i = 0; i < clientes.size(); i++){
        	
        	if(clientes.get(i).getDocumento().equals(doc))
        		return clientes.get(i);
        }
        return null;
	}
	public void getServiciosPorUsuario(String doc){
		App.clearScreen();
		Cliente c = getCliente(doc);
		if(c == null)
			System.err.println("\n" + "Este cliente no existe." + "\n");
		else{
			System.out.println("Servicios del usuario " + doc);
		    c.getServiciosInfo();
		}
	}
	
	public void mostrarTodosServicios(){
		App.clearScreen();
		int numeroServicios = 0;
		for(int i = 0; i < clientes.size(); i++){
			System.out.println("TITULAR: " + clientes.get(i).getNombre() + " Documento:" 
		    + clientes.get(i).getDocumento() + " Telefono: " + clientes.get(i).getContacto() +
		      " Rol: " + clientes.get(i).getRol().toString());
			clientes.get(i).getServiciosInfo();
			numeroServicios += clientes.get(i).getNumeroDeServicios();
			System.out.println("***********************************");
		}
		System.out.println("Numero total de productos: " + numeroServicios);
		if(clientes.size() == 0)
			System.err.println("No hay servisios que mostrar");
	}
	public Cliente buscarUsuarioPorNombre(String nombre){
		for(Cliente c : clientes){
			if(c.getNombre().equals(nombre))
				return c;
		}
		return null;
	}
	
	public void consignar(Cliente c, double cantidad){
		App.clearScreen();
		c.effectuarTransaccion(cantidad, Trans.CONSIGNACION);
	}
	public void retirar(Cliente c, double cantidad){
		App.clearScreen();
		c.effectuarTransaccion(cantidad, Trans.RETIRO);
	}
	public void consultarSaldo(Cliente c){
		App.clearScreen();
		c.effectuarTransaccion(0, Trans.CONSULTA_SALDO);
	}
	public void consultarDeuda(Cliente c){
		App.clearScreen();
		c.effectuarTransaccion(0, Trans.CONSULTA_DEUDA);
	}
	public void pagarCuota(Cliente c){
		App.clearScreen();
		c.effectuarTransaccion(0, Trans.PAGO);
	}
	public void cobrarClientesPrestamo(){
		App.clearScreen();
		for(Cliente c : clientes){
			c.effectuarTransaccion(0, Trans.BANCO_COBRO);
		}
	}
	public void cobrarClientePrestamo(Cliente c){
		c.effectuarTransaccion(0, Trans.BANCO_COBRO);
	}
	public void pagarDeuda(Cliente c){
		App.clearScreen();
		c.effectuarTransaccion(0, Trans.PAGO_DEUDA);
	}
	public void cancelarCuenta(Cliente c){
		c.effectuarTransaccion(0, Trans.CANCELAR_CUENTA);
	}
	public static void clearScreen(){
		
		for(int i = 0; i < 100; i++){
			System.out.println("");
		}
	}

}

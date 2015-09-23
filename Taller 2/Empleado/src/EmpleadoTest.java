
public class EmpleadoTest extends Thread {

	Empleado empleado1; 
	Empleado empleado2;
	Empleado empleado3;
	Empleado empleado4;
	Empleado empleado5;
	
	public EmpleadoTest(){
		
		 empleado1 = new Empleado("Juan", "Perez", 664350);
		 empleado2 = new Empleado("Mike", "Peralta",780000);
		 empleado3 = new Empleado("Dominick", "Smith", 1200000);
		 empleado4 = new Empleado("Carl", "White", 3500000);
		 empleado5 = new Empleado("Tom", "Holman", 5000000);
	}
	
	public void run(){
		
		mostrarEmpleados();
		incrementar();
	}
	
	private void mostrarEmpleados(){
		
		System.out.println(""
			     + empleado1.getNombre() + " " + empleado1.getApellido()
			     + "- Salario: " + empleado1.getSalarioMensual() + "\n"
			     + empleado2.getNombre() + " " + empleado2.getApellido()
			     + "- Salario: " + empleado2.getSalarioMensual() + "\n"
			     + empleado3.getNombre() + " " + empleado3.getApellido()
			     + "- Salario: " + empleado3.getSalarioMensual() + "\n"
			     + empleado4.getNombre() + " " + empleado4.getApellido()
			     + "- Salario: " + empleado4.getSalarioMensual() + "\n"
			     + empleado5.getNombre() + " " + empleado5.getApellido()
			     + "- Salario: " + empleado5.getSalarioMensual() + "\n");
	}
	
	public void incrementar(){
		
	    System.out.println("Salario inicial" + "\n");
	    mostrarEmpleados();
	    
	    try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	    
	    int years = 0;
	    
	    while(years < 70){
	    	
	    	years += 5;
	    	System.out.println("En " + years + " anos los salarios seran:" + "\n");
	    	empleado1.incrementar(10);
	    	empleado2.incrementar(10);
	    	empleado3.incrementar(10);
	    	empleado4.incrementar(10);
	    	empleado5.incrementar(10);
	    	mostrarEmpleados();
	    	
	    	try {
				Thread.sleep(1500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
	    	
	    }
		
	}
	
}

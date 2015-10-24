
import java.util.ArrayList;
import java.util.Calendar;


public class UNBank {

	
	public static void main(String[] args) {
		
     
		App app = new App();
		app.init();
		
		//Hilo para el menu
		Thread menu = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true)
				app.menu();
				
			}
			
		});
		//Hilo para actualizar
		Thread actualizar = new Thread(new Runnable() {

			@Override
			public void run() {
				while(true){
				app.actualizar();
				try {
					Thread.sleep(2000);//actualiza cada 2 segundos osea "un dia"
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			
			}
		});
		
		
	    actualizar.start();
		menu.start();
		
		
	
	}

}

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class MainMenu {


	BufferedReader br;
	
	public boolean display() throws IOException{
		
		boolean isValid;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("************TIC-TAC-TOE*****************" + "\n"
		+ "1. Jugar contra la computadora."+ "\n"
	    + "2. Jugar con otra persona.");
		
	    String option = br.readLine();
	    do{
	    	if(option.equals("1"))
	    		return false;
	    	if(option.equals("2"))
	    		return true;
	    	System.out.println("Entre una opcion valida.");
	    	option = br.readLine();
	    }while(true);
	}
}

import java.util.ArrayList;

public class Computer extends Player {

	private MyVector v;
	
	public Computer(String name, char playerCharacter) {
		
		super(name, playerCharacter);
		myMoves = new ArrayList<MyVector>();
	}
	
	private void randomMove(){
		
		boolean moveWasMade;
	    v = new MyVector();
		
		do{
			moveWasMade = false;
			v.x = (int)Math.floor(Math.random() * boardSize);
		    v.y = (int)Math.floor(Math.random() * boardSize);
			
		   for(int i = 0; i < movesMade.size(); i++){
			   
			   if(movesMade.get(i).x == v.x && 
				  movesMade.get(i).y == v.y){
				   
				   moveWasMade = true;
				   break;
			   }
		   }
		    
		}while(moveWasMade);
		
		
	    System.err.println("LA COMPUTADORA ESTA JUGANDO...");
	    try {
	    	
			Thread.sleep(1800);
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}
	}
	
	public MyVector requestMove() {
		
		randomMove();
		movesMade.add(v);
		myMoves.add(v);
		System.out.println(v.x + "," + v.y);
		return v;
	}

	
}

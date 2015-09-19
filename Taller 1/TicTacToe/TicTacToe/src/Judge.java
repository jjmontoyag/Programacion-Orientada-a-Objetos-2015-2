import java.io.IOException;


public class Judge {

	
	   private Board board = new Board();
	   
	   
	public void init() throws NumberFormatException, IOException{
		   
		    board.init();
	 }
	
	public void defaultInit(){
		
		   board.defaultInit();
	}
	
	public boolean checkForWinner(char c){
		
		if(isWinner("horizontal", c))
			return true;
		if(isWinner("vertical", c))
			return true;
		if(isWinner("diagonal1", c))
			return true;
		if(isWinner("diagonal2", c))
			return true;
		
		return false;
	}
	
	private boolean isWinner(String mode, char c){
		
		int matchesFound = 0;
		char playerChar = c;
		boolean isAMatch = false;
		
         for(int i = 0; i < board.getSize(); i++){
			
        	 isAMatch = false;
        	 
			for(int j = 0; j < board.getSize(); j++){
				
				MyVector v = null;
				//verifica vertical, horizontal y diagonalmente
				if(mode.equals("horizontal"))
				 v = new MyVector(j, i);
				if(mode.equals("vertical"))
				 v = new MyVector(i, j);
				if(mode.equals("diagonal1"))
			     v = new MyVector(j, j);
				if(mode.equals("diagonal2"))
				 v = new MyVector(j, board.getSize() - j - 1);
				
				if(playerChar == board.getPosition(v)){
					
					matchesFound++;
					if(matchesFound >= 3){
						
					  isAMatch = true;
					  break;
					}
				}else
					
				matchesFound = 0;
			}
			
			if(isAMatch)
				break;
		}
         
         return isAMatch;
	}
	
	public void clearBoard(){
		
		board.clearBoard();
	}
	
	public void makeMove(MyVector v, char player){
		
		board.makeMove(v, player); 
	}
	
	public char getPosition(MyVector v){
		
		return board.getPosition(v);
	}
	
	public int getBoardSize(){
		
		return board.getSize();
	}
	
	public void displayBoard(){
		
		board.displayBoard();
	}
	
	public boolean isBoardFull(){
		
		return board.isBoardFull();
	}
	   
}

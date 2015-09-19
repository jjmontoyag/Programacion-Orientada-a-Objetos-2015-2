import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Board {
	
	
	private int size = 3;
	private char [][] board = new char[size][size];
	private BufferedReader br;
	
	
	public void init() throws NumberFormatException, IOException{
		
		int n;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Entre dimensiones del tablero de juego:" + "\n"
		+ "1) 3x3" + "\n"
		+ "2) 4x4" + "\n"
		+ "3) 5x5"  + "\n"
		+ "4) 6x6");
		do{
			 n = Integer.parseInt(br.readLine());
			
			 System.out.println("Enter a valid option.");
			}while(n < 1 || n > 4);
	    
		if(n == 1)
			size = 3;
		if(n == 2)
			size = 4;
		if(n == 3)
			size = 5;
		if(n == 4)
			size = 6;
	    Game.clearScreen();
	    board = new char[size][size];
		clearBoard();
	}
	
	public void defaultInit(){
		
		Game.clearScreen();
		clearBoard();
	}
	
	public void clearBoard(){
		
           for(int i = 0; i < size; i++){
			
			for(int j = 0; j < size; j++){
				
				board[i][j] = '*';
			}
		}
	}
	
	public void makeMove(MyVector v, char player){
		
		board[v.y][v.x] = player;
		
	}
	
	public char getPosition(MyVector v){
		   
		   return board[v.y][v.x];
	   }
	
	public int getSize(){
		
		return size;
	}
	
	public boolean isBoardFull(){
		
		for(int i = 0; i < size; i++){
 			
			for(int j = 0; j < size; j++){
				
				if(board[i][j] == '*')
					return false;
			}
			
		}
        return true;
	}
	
	public void displayBoard(){
		 
		System.out.print("    ");
          for(int i = 0; i < size; i++){
 			
			System.out.print(i + "  ");
		}
		System.out.println("\n");
		
        for(int i = 0; i < size; i++){
        	
 			  System.out.print(i + "   ");
			for(int j = 0; j < size; j++){
				
				System.out.print(board[i][j] + "  ");
			}
			
			System.out.println("");
		}
	}

}

    

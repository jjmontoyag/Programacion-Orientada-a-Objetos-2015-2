import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class Player {
	
	protected String name;
	protected int roundsWon = 0;
	protected char playerCharacter;
	protected BufferedReader br;
	protected int boardSize;
    protected static ArrayList<MyVector> movesMade;
    protected ArrayList<MyVector> myMoves;
	
	public Player(String name, char playerCharacter){
		
		
		this.name = name;
		this.playerCharacter = playerCharacter;
		clearMoves();
	}
	
	public void win(){
		
		roundsWon++;
	}
	
	public int getRoundsWon(){
		
		return roundsWon;
	}
	
	public String getName(){
		
		return name;
	}
	
	public static void clearMoves(){
		
		MyVector dummyVector = new MyVector(99, 99);
		movesMade = new ArrayList<MyVector>();
		movesMade.add(dummyVector);
	}
	
	public char getPlayerCharacter(){
		
		return playerCharacter;
	}
	
	public void setBoardSize(int boardSize){
		
		this.boardSize = boardSize;
	}
	
	public MyVector requestMove() throws NumberFormatException, IOException{
		
		boolean isAValidMove;
		MyVector move =  new MyVector();
		
		do{
		
		isAValidMove = true;
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print(name.toUpperCase() + " ingrese coordenadas:" + "\n"
		+ "X: ");
		move.x = Integer.parseInt(br.readLine());
		System.out.print("Y: ");
		move.y = Integer.parseInt(br.readLine());
		
		for(int i = 0; i < movesMade.size(); i++){
			
			if((movesMade.get(i).x == move.x &&
			    movesMade.get(i).y == move.y) || move.x >= boardSize ||
			   move.y >= boardSize){
				
				isAValidMove = false;
				break;
			}
		}
		
		  if(!isAValidMove)
		 System.err.println("Las coordenadas no son validas, intente otra vez.");
		
		 }while(!isAValidMove);
		
		movesMade.add(move);
		return move;
		
	}
	
	public void clearMyMoves(){
		
	   myMoves = new ArrayList<MyVector>();
	}
	
}

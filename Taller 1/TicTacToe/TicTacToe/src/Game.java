
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;


public class Game {
	
	private Judge judge = new Judge();
	private Player player1;
	private Player player2;
	private BufferedReader br;
	private boolean IS_WINNER = false;
	private boolean NEW_GAME = false;
	private boolean NO_WINNER = false;
	private boolean TWO_PLAYERS = false;
	private String noWinnerMsg;
	StringBuffer winnerInfo;
	   
	public void init(boolean TWO_PLAYERS ) throws NumberFormatException, IOException{
		
		this.TWO_PLAYERS = TWO_PLAYERS;
		br = new BufferedReader(new InputStreamReader(System.in));
		clearScreen();
		System.out.println("Jugador 1, ingrese su nombre: ");
		String name = br.readLine();
		clearScreen();
		System.out.println(name.toUpperCase() + ", escoja X, O u otro caracter: ");
		char character = br.readLine().charAt(0);
		player1 = new Player(name, character);
		noWinnerMsg = "No hay ganador!! lol";
		clearScreen();
		
		if(TWO_PLAYERS){
			
			System.out.println("Jugador 2, ingrese su nombre: ");
		    name = br.readLine();
			System.out.println(name.toUpperCase() + ", escoja X, O u otro caracter: ");
		    character = br.readLine().charAt(0);
		    clearScreen();
			player2 = new Player(name, character);
		}else{
			
			player2 = new Computer("El computador", 'C');
		}
		
		judge.defaultInit();
		player1.setBoardSize(judge.getBoardSize());
		player2.setBoardSize(judge.getBoardSize());
		winnerInfo = new StringBuffer(noWinnerMsg);
		
	}
	
	public void displayBoard(){
		
	    
		judge.displayBoard();
		
	}
	
	public void initBoard(){
		
		
	}
	
	public void play() throws NumberFormatException, IOException, InterruptedException{
		
		
	if(!judge.isBoardFull()){
		
        if(playPlayer(player1)){
			
			IS_WINNER = true;
			showWinner(player1);
		}else{
			
			clearScreen();
			judge.displayBoard();
			if(playPlayer(player2)){
				
				IS_WINNER = true;
				showWinner(player2);
			}
		}
		
	}
		
	}
	
	private boolean playPlayer(Player player) throws NumberFormatException, IOException, InterruptedException{
		
		judge.makeMove(player.requestMove(), player.getPlayerCharacter());
		
		if(!judge.checkForWinner(player.getPlayerCharacter()) &&
			judge.isBoardFull()){
			 NO_WINNER = true;
			 Player.clearMoves();
			 System.out.println("\n");
			 menu();
		    return false;
		}
		
		if(judge.checkForWinner(player.getPlayerCharacter()))
			return true;
		else
			return false;
	}
	
	public void showWinner(Player player){
		
	if(IS_WINNER){
		
	  player.win();
	  winnerInfo = new StringBuffer("El ganador es " + "**" + player.getName().toUpperCase() + "!!" + "**"
			  + " y el numero de juegos ganados es: " + player.getRoundsWon() +"\n");
	 }
	
	}
	
	public boolean isWinner(){
		
		return IS_WINNER;
	}
	
	public boolean isNewGame(){
		
		return NEW_GAME;
	}
	
	public boolean isNoWinner(){
		
		return NO_WINNER;
	}
	
	private void clearGame(){
		
		judge.clearBoard();
		IS_WINNER = false;
		NO_WINNER = false;
		clearScreen();
		displayBoard();
		Player.clearMoves();
		winnerInfo = new StringBuffer(noWinnerMsg);
	}
	
	public void menu() throws NumberFormatException, IOException{
		
		System.out.println(winnerInfo.toString());
		br = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("OPCIONES" + "\n"
		+ "1.Continuar Juego." + "\n"
		+ "2.Cambiar dimensiones del tablero." + "\n"
		+ "3.Nueva partida." + "\n"
		+ "4.Salir.");
		
		int option = Integer.parseInt(br.readLine());
		if(option == 1){
			
			clearGame();
			player2.clearMyMoves();
		}
		if(option == 2){
			
			clearGame();
			judge.init();
			player1.setBoardSize(judge.getBoardSize());
			player2.setBoardSize(judge.getBoardSize());
			player2.clearMyMoves();
			displayBoard();
		}
		
		if(option == 3){
			
			NEW_GAME = true;
			clearScreen();
		}
		if(option == 4){
			
			clearScreen();
			System.out.println("GRACIAS POR JUGAR!!");
			System.exit(0);
		}
	}
	
	static void clearScreen(){
		
		for(int i = 0; i < 99; i++){
			
			System.out.println("");
		}
	}

}

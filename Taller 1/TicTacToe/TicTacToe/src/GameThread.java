import java.io.IOException;

public class GameThread extends Thread{

	MainMenu mainMenu = new MainMenu();

	public void run() {
		
		try{
		
		Game game = new Game();
		game.init(mainMenu.display());
		game.displayBoard();
		
		while(true){
			
			game.play();
			if(game.isWinner() || game.isNoWinner()){
				
				Game.clearScreen();
				game.displayBoard();
				game.menu();
				
				if(game.isNewGame()){
					
					game = new Game();
					game.init(mainMenu.display());
					game.displayBoard();
				}
			}else{ 
				
				Game.clearScreen();
				game.displayBoard();
			}
		}
	} catch(IOException | NumberFormatException | InterruptedException e){
		
		System.out.println(e.toString());
	}
	}
}

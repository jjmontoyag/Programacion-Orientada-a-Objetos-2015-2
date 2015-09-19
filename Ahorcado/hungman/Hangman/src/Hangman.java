
import java.io.IOException;

public class Hangman {

	public static void main(String[] args) throws IOException {
		
		MyFileReader mfr = new MyFileReader();
		mfr.initialize();
		
		Game game = new Game();
		game.setSecretWord(mfr.getRandomWord());
		game.init();
		game.clearScreen();
		
		while(!game.QUIT){
			
			game.display();
			game.getUserImput();
			game.clearScreen();
			game.checkForLastMove();
			
			if(game.CONTINUE){
				
				game.setSecretWord(mfr.getRandomWord());
				game.init();
				game.clearScreen();
				game.CONTINUE = false;
			}
			
		}
		
		System.out.print("Thanks for playing!");
	}

}

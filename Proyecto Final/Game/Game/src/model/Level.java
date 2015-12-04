package model;
import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

public class Level {
	
	protected ArrayList<Tile> tiles;
	protected ArrayList<Tile> tilesToRemove;
	protected char[][] level;
	protected String arenaName;
	protected Character player;
	protected Character2 player2;
	protected int levelWidth;
	protected int levelHeight;
	protected int gridUnit = 10;
	protected boolean matchOver;
	public enum Winner{NONE, ONE, TWO}
	private Winner winner;
	private AudioClip loop = null;
	
	public Level(){
		tiles = new ArrayList<Tile>();
		winner = Winner.NONE;
		matchOver = false;
		levelWidth = 1000/gridUnit;
		levelHeight = 700/gridUnit;
		level = new char[levelHeight + 8][levelWidth + 8];
	}
	public boolean isMatchOver(){
		return matchOver;
	}
	public void resetMatch(){
		matchOver = false;
	}
	public Winner getWinner(){
		return winner;
	}
	public void init(){
		
		
	}
	//Creates a new tile at (i, row) in the map with the specified color
	public void createCustomTile(int j, int row, Color c){
		 Rectangle r = new Rectangle(j * gridUnit, row * gridUnit, gridUnit, gridUnit);
	     tiles.add(new Tile(r, c));
	}
	public void createCustomTile(int j, int row, Color c, boolean solid, boolean indestructible){
		 Rectangle r = new Rectangle(j * gridUnit, row * gridUnit, gridUnit, gridUnit);
	     tiles.add(new Tile(r, c, solid, indestructible));
	}
	public void setNewArenaName(String arenaName){
		this.arenaName = arenaName;
	}
	public String getArenaName(){
		return arenaName;
	}
	//Loads graphics in the level
	public void stopAudio(){
		loop.stop();
	}
	public void load(){
        //Loads audio
		//if(loop != null)
		//	loop.stop();
		//URL url = getClass().getClassLoader().getResource("assets/" + arenaName  + ".wav");
		//loop = Applet.newAudioClip(url);
		//loop.loop();
		ClassLoader classLoader = getClass().getClassLoader();
		File file = new File(classLoader.getResource("assets/" + arenaName  + ".txt").getFile());
		String line;
		char mapChar;
		int row = 0;
		try {
			//Reads file and creates objects
			BufferedReader br = new BufferedReader(new FileReader(file));
			
			while((line = br.readLine()) != null){
				for(int j = 0; j < line.length(); j++){
					mapChar = line.charAt(j);
					//buffer[row][j] = 'b';
					level[row][j] = mapChar;//Stores map for editing and removal
					if(mapChar == '1'){
					   createCustomTile(j, row, new Color(64, 64, 64));
					}
					if(mapChar == '2'){
					   createCustomTile(j, row, new Color(102, 102, 102));
					}
					if(mapChar == '3'){
						   createCustomTile(j, row, new Color(191, 191, 191));
						}
					if(mapChar == '4'){
						   createCustomTile(j, row, new Color(153, 76, 0));
						}
					if(mapChar == '5'){
						   createCustomTile(j, row, new Color(230, 114, 0));
						}
					if(mapChar == '6'){
						   createCustomTile(j, row, new Color(255, 178, 102));
						}
					if(mapChar == '7'){
						   createCustomTile(j, row, new Color(0, 153, 204), false, false);//blue
						}
					if(mapChar == '8'){
						   createCustomTile(j, row, new Color(26, 198, 255), false, false);
						}
					if(mapChar == '9'){
						   createCustomTile(j, row, new Color(179, 236, 255), false, false);
						}
					if(mapChar == 'c'){
						   createCustomTile(j, row, new Color(0, 102, 0), false, false);
						}
					if(mapChar == 'd'){
						   createCustomTile(j, row, new Color(0, 179, 0), false, false);
						}
					if(mapChar == 'e'){
						   createCustomTile(j, row, new Color(128, 255, 128), false, false);
						}
					if(mapChar == 'f'){
						   createCustomTile(j, row, new Color(153, 38, 0));
						}
					if(mapChar == 'g'){
						   createCustomTile(j, row, new Color(204, 51, 0));
						}
					if(mapChar == 'h'){
						   createCustomTile(j, row, new Color(255, 198, 179));
						}
					if(mapChar == 'i'){
						   createCustomTile(j, row, new Color(255, 255, 255), false, false);
						}
					if(mapChar == 'l'){
						   createCustomTile(j, row, new Color(100, 100, 100),true, true);
						}
					
					if(mapChar == 'a'){
						player = new Character(j * gridUnit, row * gridUnit, 40);
						player.init();
						}
					if(mapChar == 'b'){
						player2 = new Character2(j * gridUnit, row * gridUnit, 40);
						player2.init();
						}
				}
				row++;
			}
			
			br.close();
		} catch (IOException e) {
			e.printStackTrace();
			System.out.println("THE FILE 'levelx.txt' IS NOT IN THE RIGHT FOLDER OR IS MISSING!!!!!!!!!!");
			System.exit(0);
		}
		
		
	}
	
	private boolean isCanInfect(int i, int j){
		if(level[i][j] != '0' && level[i][j] != 'l')
			return true;
		    return false;
	}
	
	private boolean isBroken(int i, int j){
		if(level[i - 1][j] == 'l' || level[i - 1][j + 1] == 'l' ||
		   level[i][j + 1] == 'l' || level[i + 1][j + 1] == 'l' ||
		   level[i + 1][j] == 'l' || level[i - 1][j - 1] == 'l' ||
		   level[i][j - 1] == 'l' || level[i - 1][j - 1] == 'l')
		   return true;
		   return false;
	}
	
	public void update(){
		//collision
		tilesToRemove = new ArrayList<Tile>();
		//checks bullet-tile collision
		if(player != null && player2 != null){//Makes sure the player is not null.
		checkCollision(player);
		checkCollision(player2);
		
		//REmove tiles in the explotion
		for(Tile t : tilesToRemove){
			tiles.remove(t);
			//Remove tile from the map too
			level[t.rectangle.y/gridUnit][t.rectangle.x/gridUnit] = '0';
		}

		//bullet-bullet collision
		if(player.bullet.circle.intersects(player2.bullet.circle)){
			player.bullet.destroyBullet = true;
			player2.bullet.destroyBullet = true;
		}
		//bullet-player collision
		if(player.circle.intersects(player2.bullet.circle)){
			player.setPlayerDead(true);
			player2.bullet.destroyBullet = true;
			winner = Winner.TWO;
			matchOver = true;
		}
		if(player2.circle.intersects(player.bullet.circle)){
			player2.setPlayerDead(true);
			player.bullet.destroyBullet = true;
			winner = Winner.ONE;
			matchOver = true;
		}
			
		//circle to normal size
		player.bullet.circle.r = 20;
		player2.bullet.circle.r = 20;
		player.update();//Update player
		player2.update();//Update player2
	}
		
	}
	
	private void checkCollision(Player playera){
		for(Tile t : tiles){
			if(t.rectangle.y > 700)
				tilesToRemove.add(t);//removes tiles if they are not on the screen anymore
			if(playera.bullet.circle.intersects(t.rectangle)){//Checks tile-bullet collision
			if(t.solid)//Leaves do not make the bullet explode
			playera.bullet.destroyBullet = true;//Solid tiles make bullets explode
			playera.bullet.circle.r = 50;//Explosion radius
			if(playera.bullet.circle.intersects(t.rectangle)){//Checks collision with r=50
			if(!t.indestructible && t.solid)
			tilesToRemove.add(t);//Stores tiles to be removed
			else if(!t.solid)//If it is a leaf, it will fall and be removed after leaving the screen
				t.wasHit = true;
			}
		}
			t.update();//Updates all tiles
	}
	}
	//Updates the player's display
	public void updateDisplay(KeyEvent ke){
		//When pressing a key, make sure player is not null.(when changing state)
		if(player != null && player2 != null){
		player.display.update(ke);
		player2.display.update(ke);
	  }
	}
	
	//Listens for key released
	public void listenForKeyReleased(KeyEvent ke){
		//When pressing a key, make sure player is not null.(when changing state)
		if(player != null && player2 != null){
		player.display.listenForKeyReleased(ke);
		player2.display.listenForKeyReleased(ke);
		}
		
	}
	
	
	//removes tile at the location (i, j) in the map
    public void removeTileAt(int i, int j){
		
		for(Tile t : tiles){
			if(t.rectangle.x/gridUnit == j && t.rectangle.y/gridUnit == i){
				tiles.remove(t);
				break;
			}
		}
	}
 public void animateTileAt(int i, int j){
		
		for(Tile t : tiles){
			if(t.rectangle.x/gridUnit == j && t.rectangle.y/gridUnit == i){
				t.wasHit = true;;
				break;
			}
		}
	}
    
	public void draw(Graphics graphics){
		for(Tile t : tiles)
			t.draw(graphics);
		player.draw(graphics);
		player2.draw(graphics);
		
	}

}

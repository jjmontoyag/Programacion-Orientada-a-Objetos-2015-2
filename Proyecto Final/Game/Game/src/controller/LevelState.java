package controller;

import java.awt.Graphics;
import java.awt.event.KeyEvent;

import model.Level;
import model.Level.Winner;

public class LevelState extends State {
	
	private Level level;
	
	public LevelState() {
		super();
		level = new Level();
		winner = Winner.NONE;
	}
	@Override
	public void stopAudio() {
		level.stopAudio();
	}
	public Winner getWinner(){
		return winner;
	}
	
	@Override
	public void init() {
		level.init();
		level.setNewArenaName(arenaName);
	}

	@Override
	public void load() {
		level.load();
	}

	@Override
	public void update() {
		if(level.isMatchOver()){
			winner = level.getWinner();
			isMatchOver = true;
			level.resetMatch();
		}
		level.update();
		
	}
	

	@Override
	public void updatePlayerDisplay(KeyEvent ke) {
		level.updateDisplay(ke);
	}

	@Override
	public void listenForKeyReleased(KeyEvent ke) {
		level.listenForKeyReleased(ke);
	}

	@Override
	public void draw(Graphics graphics) {
		level.draw(graphics);
	}

	@Override
	public void resetState() {
		// TODO Auto-generated method stub
		
	}
	
	

}

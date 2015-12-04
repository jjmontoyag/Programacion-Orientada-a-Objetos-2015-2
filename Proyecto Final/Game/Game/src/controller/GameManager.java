package controller;



import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import model.*;
import model.Level.Winner;


public class GameManager {
	
	private ArrayList<State> states;
	private String currentLevelName;
	public enum GameStates{INTRO(0), CHOOSE(1), LEVEL(2);
		private int value;
		private GameStates(int value){
			this.value = value;
		}
	}
	GameStates currentState;
	private Winner winner;
	
	public GameManager(){
		winner = Winner.NONE;
		currentState = GameStates.INTRO;
		states = new ArrayList<State>();
		//Initialize all states
		states.add(new IntroState());
		states.add(new ChooseState());
		states.add(new LevelState());
	}
	
	public void newInstance(GameStates cs){
		//creats a new instance of the current state
		if(cs.equals(GameStates.LEVEL))
		    states.set(currentState.value, new LevelState());
		if(cs.equals(GameStates.CHOOSE))
			states.set(currentState.value, new ChooseState());
		if(cs.equals(GameStates.INTRO))
			states.set(currentState.value, new IntroState());
		//initializes and loads the new current state
		states.get(currentState.value).setNewArenaName(currentLevelName);
		init();
		load();
	}
	
	public void changeStateTo(GameStates ns){
	   currentState = ns;
	}
	
	public void init(){
		states.get(currentState.value).init();
	}
	
	public void load(){
		states.get(currentState.value).load();
	}
	public Winner getWinner(){
		return winner;
	}
	public void resetWinner(){
		winner = Winner.NONE;
	}
	public void update(){
		State state = states.get(currentState.value);
		//check winner
		if(state.isMatchOver){
			winner = state.getWinner();
			state.isMatchOver = false;
			state.resetWinner();
		}
		state.update();
		if(state.isStateChange()){
			//Save prevoiusState to send msg(new level name) to new state
			GameStates previousState;
			previousState = currentState;
			currentState = state.nextState;
			//pass level name to CHOOSE state
			if(previousState.equals(GameStates.CHOOSE))
			states.get(currentState.value).setNewArenaName(states.get(previousState.value).getNewArenaName());
			currentLevelName = states.get(currentState.value).getNewArenaName();
			states.get(currentState.value).init();
			states.get(currentState.value).load();
			
			states.get(previousState.value).stopAudio();
			if(!previousState.equals(GameStates.INTRO))
			newInstance(previousState);//Reset previous state
		}
	}
	
	public void updatePlayerDisplay(KeyEvent ke){
		states.get(currentState.value).updatePlayerDisplay(ke);
	}
	
	public void listenForKeyReleased(KeyEvent ke){
		states.get(currentState.value).listenForKeyReleased(ke);
	}
	public void draw(Graphics graphics){
		states.get(currentState.value).draw(graphics);
	}

}

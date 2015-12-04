package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;


public class Character extends Player{
	
	
	 public Character(int x, int y, int r){
		 super(x, y, r);
		 dir = 1;
		 display = new Display(x - 10, y, "one");
	 }
	 
	 public void listenForKeyReleased(KeyEvent ke){
		super.listenForKeyReleased(ke);
	 }
	
	 public void init(){
		super.init();
	}
	 
	 protected void restartBullet(){
		super.restartBullet();
	}
	 
	 public void update(){
		 super.update();
	 }
	 public void updateDisplay(KeyEvent ke){
		super.updateDisplay(ke);
	 }
	 
	 public void draw(Graphics graphics){
		 if(!playerIsDead){
		 Graphics2D g = (Graphics2D)graphics;
		 g.setStroke(new BasicStroke(1));
		 graphics.setColor(Color.BLACK);
		 bullet.draw(graphics);
		 graphics.setColor(Color.BLACK);
		 graphics.fillOval((int)position.x, (int)position.y, 50, 50);
		 display.draw(graphics);
		 ps.draw(graphics);
		 graphics.setColor(Color.RED);
		 g.setStroke(new BasicStroke(25));
		 g.drawLine((int)position.x + c, (int)position.y + c, (int) (position.x + c + 25 * Math.cos(display.rad)), (int) (position.y + c - 25 * Math.sin(display.rad)));
		}
	 }

}

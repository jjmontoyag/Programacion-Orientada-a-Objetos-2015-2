package model;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;

public class Display {

	public int angle;
	public double rad;
	public int hp;
	public boolean shootNow = false;
	private MyVector position;
	public boolean bulletInAir = false;
	private boolean pressRight = false;
	private boolean pressLeft = false;
	private String mode = "one";
	
	public Display(int x, int y, String mode){
		this.mode = mode;
		angle = 45;
		hp = 50;
		position = new MyVector(x, y);
		
	}
	
	public void init(){
		
	}
	public void listenForKeyReleased(KeyEvent ke){
		if(mode.equals("one"))
		if(ke.getID() == KeyEvent.KEY_RELEASED && ke.getKeyCode() == KeyEvent.VK_W)
		shootNow = true;
		if(mode.equals("two"))
		if(ke.getID() == KeyEvent.KEY_RELEASED && ke.getKeyCode() == KeyEvent.VK_NUMPAD8)
		shootNow = true;

		pressLeft = false;
		pressRight = false;
	}
	
	public void update(){
		if(pressLeft)
			angle+=3;
		if(pressRight)
			angle-=3;
		if(angle > 90)
			angle = 90;
		if(angle < 0)
			angle = 0;
		 rad = Math.PI * angle / 180;
	}
	
	public void update(KeyEvent ke){
		//Changes the angle 
		if(mode.equals("one")){
		if(ke.getKeyCode() == KeyEvent.VK_A)
			pressLeft = true;
		
		if(ke.getKeyCode() == KeyEvent.VK_D)
			pressRight = true;
	    //Bullet power
		if(ke.getKeyCode() == KeyEvent.VK_S){
			hp+=4;
			if(hp >= 70)
				hp = 30;
			}
		}
		
		if(mode.equals("two")){
			if(ke.getKeyCode() == KeyEvent.VK_NUMPAD6)
				pressLeft = true;
			
			if(ke.getKeyCode() == KeyEvent.VK_NUMPAD4)
				pressRight = true;
		    //Bullet power
			if(ke.getKeyCode() == KeyEvent.VK_NUMPAD5){
				hp+=4;
				if(hp >= 70)
					hp = 30;
				}
		}
	   
	}
	
	
	public void draw(Graphics graphics){
		//Angle
		graphics.setColor(Color.BLACK);
		graphics.setFont(new Font("TimesRoman", Font.BOLD, 30));
		graphics.drawString(Integer.toString(angle) + "�", (int)position.x, (int)position.y);
		//Power
		graphics.drawRect((int)position.x + 20, (int)position.y - 50, 70, 10);
		int r = (int) (2.5 * hp * 1.4);
		graphics.setColor(new Color( r, 0, 200));
		graphics.fillRect((int)position.x + 20, (int)position.y - 50, ((hp) - 30) * 2, 10);
		
	}
}

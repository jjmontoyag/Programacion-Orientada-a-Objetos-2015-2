package model;

import java.awt.Color;
import java.awt.Graphics;

public class Particle{
	
	public MyVector position;
	private MyVector velocity;
	private MyVector gravity;
	private MyVector direction;
	public int width;
	public int height;
	private Color c;
	public enum Mode{RADIAL, EXPLOSION};
	private double maxVelocityY;
	private double delta;
	private int force;
	

	public Particle(int x, int y, int width, int height, MyVector direction, 
			int force, Color c, Mode mode) {
		this.force = force;
		position = new MyVector(x, y);
		velocity = new MyVector(direction.scale(force));
		this.direction = direction;
		this.width = width;
		this.height = height;
		this.c = c;
		gravity = new MyVector(0, 3);
		if(mode.equals(Mode.RADIAL))
		gravity = new MyVector(0, 0);
		delta = 0.35d;//0.35
		maxVelocityY = 40;
	}
	
	public void update(){
		position = position.add(velocity.scale(delta));//position = position + delta * velocity
    	velocity = velocity.add(gravity.scale(delta));//velocity = velocity + delta * gravity
    	
    	//Limit for max velocity in the y axis
    	if(velocity.y > maxVelocityY)
    	     velocity.y = maxVelocityY;
    	
    	
	}
		
	public void restart(int x, int y){
	        	position = new MyVector(x, y);
	        	velocity = new MyVector(direction.scale(force));
	
	}
		
		
	public void draw(Graphics graphics){
		graphics.setColor(c);
		graphics.fillRect((int)position.x, (int)position.y, width, height);
		
	}
	
}

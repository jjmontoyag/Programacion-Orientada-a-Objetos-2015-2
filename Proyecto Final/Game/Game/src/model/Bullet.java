package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import model.Particle.Mode;

public class Bullet {
	
	public boolean shoot; 
	public boolean destroyBullet;
	public Circle circle;
	public MyVector position;
	private MyVector velocity;
	private MyVector direction;
	private MyVector gravity;
	private double maxVelocityY;
	private double delta;
	private ParticleSystem ps;
	public boolean hideParticles;
	
	
	public Bullet(int x, int y){
		ps = new ParticleSystem(x, y, 5, 5, new Color(255, 255, 204), Mode.RADIAL);
		circle = new Circle(x, y, 20);
		position = new MyVector(x, y);
		gravity = new MyVector(0, 3);
		delta = 0.35d;
		maxVelocityY = 45;
		shoot = true;
		destroyBullet = false;
		direction = new MyVector(0, 0);
		velocity = new MyVector(new MyVector(0, 0));
		hideParticles = false;
		
	}
	
	public void init(){
		
	}
	
    public void update(){
    	if(!destroyBullet){
    	position = position.add(velocity.scale(delta));//position = position + delta * velocity
    	velocity = velocity.add(gravity.scale(delta));//velocity = velocity + delta * gravity
    	
    	//Limit for max velocity in the y axis
    	if(velocity.y > maxVelocityY)
    	     velocity.y = maxVelocityY;
    	//no negative values for y
    	//if(position.y > 700)
   	        // velocity.y = 0;
    	
        circle.x = (int)position.x;
        circle.y = (int)position.y;
    	}
    	ps.update();
    	ps.x = position.x + 10;
    	ps.y = position.y + 10;
    }
    
    public void fire(double theta, double force, int dir){
    	if(shoot){
    		double rad = theta * (Math.PI/180);
    		direction = new MyVector(dir * Math.cos(rad), -Math.sin(rad));
    		velocity = new MyVector(direction.scale(force));
    		shoot = false;
    	}
	}
    
    public void repositionParticles(double x, double y){
    	ps.x = x + 10;
    	ps.y = y + 10;
    }
    public void draw(Graphics graphics){
    	Graphics2D g = (Graphics2D)graphics;
    	g.setStroke(new BasicStroke(1));
    	graphics.setColor(Color.BLACK);
    	graphics.fillOval((int)position.x, (int)position.y, circle.r, circle.r);
    	graphics.setColor(Color.WHITE);
    	graphics.fillOval((int)position.x + 5, (int)position.y - 1, 10, 10);
    	graphics.setColor(Color.RED);
    	graphics.drawOval((int)circle.x, (int)circle.y , 20, 20);
    	if(!hideParticles)
        ps.draw(graphics);
    }
}

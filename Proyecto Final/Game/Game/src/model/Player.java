package model;

import java.applet.Applet;
import java.applet.AudioClip;
import java.awt.Color;
import java.awt.Graphics;

import java.awt.event.KeyEvent;
import java.io.File;
import java.net.URL;

import model.Particle.Mode;

public abstract class Player {
	 
	 public Circle circle;
	 public Bullet bullet;
	 protected ParticleSystem ps;
	 public boolean bulletInAir;
	 public MyVector position;
	 public Display display;
	 public int c;
	 protected int dir;
	 protected boolean playerIsDead;
	 protected AudioClip hitSound;
	 protected AudioClip shootSound;
	 protected File shootPath;
	 
	 public Player(int x, int y, int r){
		 ps = new ParticleSystem(x, y, 5, 5, Color.BLACK, Mode.EXPLOSION);
		 position = new MyVector(x, y);
		 circle = new Circle((int)position.x, (int)position.y, r);
		 bullet = new Bullet((int)position.x, (int)position.y);
		 bullet.shoot = false;
		 bulletInAir = false;
		 playerIsDead = false;
		 c = 12;
		 //load audio clip
		 URL url = getClass().getClassLoader().getResource("assets/hit.wav");
		 hitSound = Applet.newAudioClip(url);
		 url = getClass().getClassLoader().getResource("assets/shoot.wav");
		 shootSound = Applet.newAudioClip(url);
	 }
	 
	 public void listenForKeyReleased(KeyEvent ke){
		display.listenForKeyReleased(ke);
	 }
	
	 public void init(){
		bullet.init();
		display.init();
	}
	 
	protected void restartBullet(){
		if(bullet.circle.x > 1100 || bullet.circle.x < -100 || bullet.circle.y > 800 ||
				bullet.destroyBullet){
			if(bullet.destroyBullet){//makes particles show when they hit a tile
				ps.restart((int)bullet.position.x, (int)bullet.position.y);
				hitSound.play();//plays when bullet hits something
			}
			
			bullet.position = position;
			bullet.destroyBullet = false;
			bulletInAir = false;
		}
	}
	 
	 public void update(){
		if(!playerIsDead){
		 if(display.shootNow && !bulletInAir){
		   bullet.shoot = true;
	       display.shootNow = false;
	       bulletInAir = true;
	       shootSound.play();
		 }
		 if(bulletInAir){
		 restartBullet();
		 bullet.update();
		 bullet.fire(display.angle, display.hp, dir);
		 bullet.hideParticles = false;
		 }else{
			 bullet.hideParticles = true;
			 bullet.repositionParticles(position.x, position.y);
		 }
		 ps.update();
	  }
		 display.update();
	 }
	 public void setPlayerDead(boolean playerIsDead){
		 this.playerIsDead = playerIsDead;
	 }
	 public void updateDisplay(KeyEvent ke){
		 display.update(ke);
	 }
	 public abstract void draw(Graphics graphics);


}

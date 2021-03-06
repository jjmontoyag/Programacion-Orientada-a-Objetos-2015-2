package controller;

import java.applet.Applet;
import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;
import java.awt.image.ImageObserver;
import java.net.URL;
import java.util.Date;
import java.awt.Toolkit;

import controller.GameManager.GameStates;
import model.GameUtils;
import model.MyVector;

public class IntroState extends State {

	private MyVector position;
	private Date time;
	private double creationTime;
	private int c;
	private Image javaIcon;
	
	public IntroState() {
		super();
		time = new Date();
		creationTime = time.getTime();
		c = 255;
		//load image
		URL url = getClass().getClassLoader().getResource("assets/java.png");
		javaIcon = Toolkit.getDefaultToolkit().getImage(url);
	}
	@Override
	public void init() {
		position = new MyVector(0, 0);
	}

	@Override
	public void load() {
		
		
	}

	@Override
	public void update() {
		if(GameUtils.isTimeUp(creationTime, 10000)){
			System.out.print("Change state!");
			changeState = true;
			nextState = GameStates.CHOOSE;
		}
		c--;
		if(c < 0)//Constraint
			c = 0;
		
	}

	@Override
	public void updatePlayerDisplay(KeyEvent ke) {
		changeState = true;
		nextState = GameStates.CHOOSE;
		
	}

	@Override
	public void listenForKeyReleased(KeyEvent ke) {
		
		
	}

	@Override
	public void draw(Graphics graphics) {
		graphics.setColor(new Color(255 - c,255 - c, 255 - c));
		graphics.fillRoundRect((int)position.x, (int)position.y, 1000, 700, 2, 2);
		graphics.setFont(new Font("TimesRoman",Font.BOLD, 40));
		graphics.setColor(new Color(c, c, c));
		graphics.drawString("By:", 100, 300);
		graphics.drawString("Juan David Balcazar Bedoya", 100, 350);
		graphics.drawString("John Jairo Montoya Gomez", 100, 400);
		graphics.drawImage(javaIcon, 0, 0, 200, 200, null);
		
	}
	@Override
	public void resetState() {
		
		
	}

}

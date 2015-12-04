package model;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

public class Character2 extends Player {
	
	public Character2(int x, int y, int r){
		super(x, y, r);
		c = 10;
		dir = -1;
		display = new Display(x - 10, y, "two");
	}
	@Override
	public void draw(Graphics graphics) {
		if(!playerIsDead){
		 Graphics2D g = (Graphics2D)graphics;
		 g.setStroke(new BasicStroke(1));
		 graphics.setColor(Color.BLACK);
		 bullet.draw(graphics);
		 graphics.setColor(Color.BLACK);
		 graphics.fillOval((int)position.x - 20, (int)position.y, 50, 50);
		 display.draw(graphics);
		 ps.draw(graphics);
		 graphics.setColor(new Color(0, 51, 204));
		 g.setStroke(new BasicStroke(25));
		 g.drawLine((int)position.x + c, (int)position.y + c, (int) (position.x + c - 25 * Math.cos(display.rad)), (int) (position.y + c - 25 * Math.sin(display.rad)));
	}
	}

}

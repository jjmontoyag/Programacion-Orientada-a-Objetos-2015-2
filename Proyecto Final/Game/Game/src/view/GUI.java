package view;
import java.applet.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;

import controller.*;
import controller.GameManager.GameStates;
import model.Level.Winner;
import model.MapEditor;
import model.Rectangle;

public class GUI extends Applet implements ActionListener, KeyListener,
MouseMotionListener,MouseListener, Runnable {
	
	
	GameManager gm;
    MapEditor me;
	Thread game = null;
	boolean gameRunning = true;
	boolean editorMode = false;///turn editor on and off
	boolean waitingForInput = false;
	Image buffer;
	Graphics2D helper;
	long sleepTime = 30;
	///Editor stuff
	Color selectedColor;
	char currentButtonName;
	Label loading;
	Label l;
	Label winnerMsg;
	Panel winnerPanel;
	Button playAgain;
	Button quit;
	Panel panel;
	Button b1;
	Button b2;
	Button b3;
	Button b4;
	Button b5;
	Button b6;
	Button b7;
	Button b8;
	Button b9;
	Button b10;
	Button b11;
	Button b12;
	Button b13;
	Button b14;
	Button b15;
	Button b16;
	Button b17;
	Button b18;
	Button b19;
		
	
	public GUI(){
		loading = new Label("Loading...");
		loading.setBounds(250, 50, 600, 55);
		loading.setFont(new Font("Verdana",Font.BOLD, 50));
		if(!editorMode){
		gm = new GameManager();
		winnerMsg = new Label();
		playAgain = new Button("Play again");
		quit = new Button("Change arena");
		}
		else{
		me = new MapEditor();
	    selectedColor = new Color(0, 0, 0);
	    currentButtonName = '1';
		 l = new Label();
		 panel = new Panel();
		 b1 = new Button();
		 b2 = new Button();
		 b3 = new Button();
		 b4 = new Button();
		 b5 = new Button();
		 b6 = new Button();
		 b7 = new Button();
		 b8 = new Button();
		 b9 = new Button();
		 b10 = new Button();
		 b11 = new Button();
		 b12 = new Button();
		 b13 = new Button();
		 b14 = new Button();
		 b15 = new Button();
		 b16 = new Button();
		 b17 = new Button();
		 b18 = new Button();
		 b19 = new Button();
		}
	}
	
	public void init(){
	    add(loading);
		setSize(1000, 700);
		setLayout(null);
		addKeyListener(this);
		//Initialize map or editor mode
		if(!editorMode){
		gm.init();
		gm.load();
		playAgain.addActionListener(this);
		quit.addActionListener(this);
		}else{
		 me.init();
		 me.load();
		addMouseMotionListener(this);
		addMouseListener(this);
		b1.addActionListener(this);
		b2.addActionListener(this);
		b3.addActionListener(this);
		b4.addActionListener(this);
		b5.addActionListener(this);
		b6.addActionListener(this);
		b7.addActionListener(this);
		b8.addActionListener(this);
		b9.addActionListener(this);
		b10.addActionListener(this);
		b11.addActionListener(this);
		b12.addActionListener(this);
		b13.addActionListener(this);
		b14.addActionListener(this);
		b15.addActionListener(this);
		b16.addActionListener(this);
		b17.addActionListener(this);
		b18.addActionListener(this);
		b19.addActionListener(this);
		
		b1.setBackground(new Color(64, 64, 64));///black
		b2.setBackground(new Color(102, 102, 102));//gray
		b3.setBackground(new Color(191, 191, 191));//light gray
		b4.setBackground(new Color(153, 76, 0));//brown
		b5.setBackground(new Color(230, 114, 0));
		b6.setBackground(new Color(255, 178, 102));
		b7.setBackground(new Color(0, 153, 204));//blue
		b8.setBackground(new Color(26, 198, 255));
		b9.setBackground(new Color(179, 236, 255));
		b10.setBackground(new Color(0, 102, 0));//green
		b11.setBackground(new Color(0, 179, 0));
		b12.setBackground(new Color(128, 255, 128));
		b13.setBackground(new Color(153, 38, 0));//sienna
		b14.setBackground(new Color(204, 51, 0));
		b15.setBackground(new Color(255, 198, 179));
		b16.setBackground(new Color(255, 255, 255));//white
		b17.setBackground(new Color(254, 254, 254));//delete
		b18.setBackground(new Color(254, 254, 254));//save
		b19.setBackground(new Color(100, 100, 100));//indestructible 
		
		b17.setFont(new Font("Verdana", Font.BOLD, 11));
		b17.setLabel("Del");
		b18.setFont(new Font("Verdana", Font.BOLD, 11));
		b18.setLabel("Save");
		
		b1.setName("1");
		b2.setName("2");
		b3.setName("3");
		b4.setName("4");
		b5.setName("5");
		b6.setName("6");
		b7.setName("7");
		b8.setName("8");
		b9.setName("9");
		b10.setName("c");
		b11.setName("d");
		b12.setName("e");
		b13.setName("f");
		b14.setName("g");
		b15.setName("h");
		b16.setName("i");
		b17.setName("0");
		b18.setName("k");
		b19.setName("l");
		
		panel.setBounds(30, 0, 100, 100);
		panel.setLayout(new GridLayout(7, 3, 1, 1));
		panel.add(b1);
		panel.add(b2);
		panel.add(b3);
		panel.add(b4);
		panel.add(b5);
		panel.add(b6);
		panel.add(b7);
		panel.add(b8);
		panel.add(b9);
		panel.add(b10);
		panel.add(b11);
		panel.add(b12);
		panel.add(b13);
		panel.add(b14);
		panel.add(b15);
		panel.add(b16);
		panel.add(b17);
		panel.add(b18);
		panel.add(b19);
		add(panel);
		}
		
	}
	
	public void start(){
		if(game == null){
			game = new Thread(this);
			game.start();
			
		}
		
		
	}
	
	public void stop(){
		gameRunning = false;
	}
	
	public void paint(Graphics graphics){
		
	}
	
	public void update(Graphics graphics){
		if(helper == null){
			buffer = createImage(getWidth(), getHeight());//Double buffer
			helper = (Graphics2D) buffer.getGraphics();
		}
		helper.setColor(new Color(153, 204, 255));
		helper.fillRect(0, 0, getWidth(), getHeight());
		//draw gameManager or draw mapEditor stuff
		if(!editorMode)
		gm.draw(helper);
		else
		me.draw(helper);
		graphics.drawImage(buffer, 0, 0, this);
		remove(loading);//Here java finishes drawing stuff onto the screen
		requestFocus();
		
	}
     private void showWinner(){
		if((gm.getWinner().equals(Winner.ONE) || gm.getWinner().equals(Winner.TWO)) &&
				!waitingForInput){
			quit.setBounds(250, 350, 120, 40);
			playAgain.setBounds(450, 350, 120, 40);
			winnerMsg.setBounds(250, 260, 345, 45);
			winnerMsg.setFont(new Font("TimesRoman", Font.ITALIC, 50));
			if(gm.getWinner().equals(Winner.ONE))
				winnerMsg.setText("Player 1 wins!");
			else
			    winnerMsg.setText("Player 2 wins!");
			
			add(winnerMsg);
			add(quit);
			add(playAgain);
			waitingForInput = true;
		}
	}
	@Override
	public void run() {
		
		while(gameRunning){//update game while the game is running
			//Update gameManager or mapEditor
			if(!editorMode){
			gm.update();
			showWinner();
			}else
			me.update();
			repaint();//calls the applet update function
			
			try {
				Thread.sleep(sleepTime);//30
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		//Editor stuff
		if(editorMode){//Color picker
		Button b = (Button)e.getSource();
		if(b.getName().equals(b18.getName())){//Save edited level
			me.writeFile();
			l.setText("The changes were saved.");
			l.setBounds(11, 11 ,200, 40);
			add(l);
		}
		selectedColor = b.getBackground();
		currentButtonName = b.getName().charAt(0);
		}
		
		if(e.getSource() == playAgain){//Restart level
			gm.newInstance(GameStates.LEVEL);
			resetWinnerScreen();
			requestFocus();
		}
		if(e.getSource() == quit){
			gm.newInstance(GameStates.CHOOSE);
			gm.changeStateTo(GameStates.CHOOSE);
			resetWinnerScreen();
			requestFocus();
		}
			
	}
    private void resetWinnerScreen(){
    	gm.resetWinner();
		remove(winnerMsg);
		remove(playAgain);
		remove(quit);
		waitingForInput = false;
    }
	@Override
	public void keyPressed(KeyEvent e) {
		gm.updatePlayerDisplay(e);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		gm.listenForKeyReleased(e);
	}
        
	@Override
	public void keyTyped(KeyEvent e) {}

	@Override
	public void mouseDragged(MouseEvent e) {
		if(editorMode){
		if(e.MOUSE_CLICKED == MouseEvent.MOUSE_CLICKED){
			Rectangle mr = new Rectangle(e.getX(), e.getY(), 5, 5);
			me.editMap(mr, selectedColor, currentButtonName);
			}
		}
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		
		
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(editorMode){
		if(e.MOUSE_CLICKED == MouseEvent.MOUSE_CLICKED){
			Rectangle mr = new Rectangle(e.getX(), e.getY(), 5, 5);
			me.editMap(mr, selectedColor, currentButtonName);
			}
		}
	}

	@Override
	public void mouseEntered(MouseEvent e) {}

	@Override
	public void mouseExited(MouseEvent e) {}

	@Override
	public void mousePressed(MouseEvent e) {
		if(editorMode){
		panel.setBounds(e.getX() + 10, e.getY() + 100, 100, 100);//Cool tool!
		panel.setBackground(new Color(0, 0, 100));
		}
	}

	@Override
	public void mouseReleased(MouseEvent e) {}


}

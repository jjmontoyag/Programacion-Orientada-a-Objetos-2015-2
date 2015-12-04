package model;

import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class MapEditor extends Level{
     //path where the new file will be saved
	private String path; 
	
	public MapEditor(){
		super();
		path = "C:/Users/jjmontoyag/Documents/OOPTALLERES/game/Game/src/assets/level1.txt";
	}
	
	
	public void update(){
		//super.update();
		
	}
	
	public void editMap(Rectangle mr, Color c, char tn){
		Rectangle tr;
		for(int i = 0; i < 70; i++){
			for(int j = 0; j < 100; j++){
				tr = new Rectangle(j * gridUnit, i * gridUnit, gridUnit, gridUnit);
				if(tr.intersects(mr)){
					level[i][j] = tn;
					if(tn != '0')
					createCustomTile(j, i, c);
					else{
					//Color t = new Color(Color.TRANSLUCENT);
					removeTileAt(i, j);
					}
					break;
				}
			}
		}
		
	}
	
	public void writeFile(){
		
		StringBuilder line = new StringBuilder();
		line.setLength(101);
		PrintWriter pw = null;
		try {
			pw = new PrintWriter(new FileWriter(path));
		} catch (IOException e) {
			e.printStackTrace();
		}
		for(int i = 0; i < 70; i++){
			for(int j = 0; j < 100; j++){
				line.setCharAt(j, level[i][j]);
			}
			pw.println(line.toString());
			
		}
		
		pw.close();
	}
	
	public void draw(Graphics graphics){
		tilesToRemove = new ArrayList<Tile>();
		super.draw(graphics);
	}
}

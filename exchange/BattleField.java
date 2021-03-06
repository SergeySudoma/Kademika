package lesson_3_Objects_Of_Battlefield;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

public class BattleField implements Drawable{
	
	private int bfWidth = 576;
	private int bfHeight = 576;
	private boolean COLORDED_MODE = false;
	private ArrayList<AbstractObjectOfField> list = new ArrayList<AbstractObjectOfField>();	
	
	private static String[][] battleField = { { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", "E", "B" },
			{ "B", " ", "", " ", "R", " ", "W", " ", "B" },
			{ "B", "B", "", " ", " ", " ", " ", " ", "B" },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ "B", " ", "W", " ", " ", " ", "", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", "", " ", "B" },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B" } };
	
	
	public BattleField(){
		createObjects();
	}
	
	public BattleField(String[][] battlefield){
		this.battleField = battlefield;
		createObjects();
	}
		
	public String[][] getBattleField(){
		return battleField;
	}
	
	public String scanQuadrant(int x, int y){		
		return battleField[x][y];		
	}
	
	public void updateQuadrant(int x, int y, String value){
		battleField[x][y] = value;
	}
	
	public int getDimensionX(){
		return battleField.length;		
	}
	
	public int getDimensionY(){
		return battleField.length;		
	}
	
	public int getBfWidth(){
		return bfWidth;
	}
	
	public int getBfHeight(){
		return bfHeight;
	}
	
	
	public void updateObjects(int y, int x) {
		for(AbstractObjectOfField obj : list){
			if(obj.getX() == x * 64 && obj.getY() == y * 64){
				obj.destroy();
			}
		}
	}
		
	public boolean checkInterception(int y, int x){
		boolean result = false;		
		for(AbstractObjectOfField obj : list){
			if(obj.getX() == x * 64 && obj.getY() == y * 64){
				result = true;
			}
		}		
		return result;
	}
	
	
	public void createObjects(){
		for (int j = 0; j < this.getDimensionY(); j++) {
			for (int k = 0; k < this.getDimensionX(); k++) {
				if (this.scanQuadrant(j, k).equals("B")) {
					list.add(new Brick(j * ActionField.PIXELS_IN_CELL, k * ActionField.PIXELS_IN_CELL));		
				}
				if (this.scanQuadrant(j, k).equals("R")) {
					list.add(new Rock(j * ActionField.PIXELS_IN_CELL, k * ActionField.PIXELS_IN_CELL));		
				}
				if (this.scanQuadrant(j, k).equals("E")) {
					list.add(new Eagle(j * ActionField.PIXELS_IN_CELL, k * ActionField.PIXELS_IN_CELL));		
				}
				if (this.scanQuadrant(j, k).equals("W")) {
					list.add(new Water(j * ActionField.PIXELS_IN_CELL, k * ActionField.PIXELS_IN_CELL));		
				}
			}
		}
	}
	
	public void createBackground(Graphics g){
		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}
	}
	

	public void draw(Graphics g){
		createBackground(g);
		for(AbstractObjectOfField item : list){
			item.draw(g);
		}
	}
	
//	private String getQuadrantXY(int coordinateY, int coordinateX) {
//		String result = (coordinateY - ActionField.STEP) * ActionField.PIXELS_IN_CELL + "_"
//				+ (coordinateX - ActionField.STEP) * ActionField.PIXELS_IN_CELL;
//		return result;
//	}
}


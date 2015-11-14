package lesson_3_Drawable_And_Destroyable;

import java.awt.Color;
import java.awt.Graphics;

public class BattleField implements Drawable{
	
	private int bfWidth = 576;
	private int bfHeight = 576;
	private boolean COLORDED_MODE = false;

	
	private static String[][] battleField = { { "B", "B", "B", "B", "B", "B", "B", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", " ", "B", " ", "B", "B", " ", " ", "B" },
			{ "B", "B", "B", " ", " ", " ", " ", " ", "B" },
			{ "B", " ", " ", " ", " ", " ", " ", " ", "B" },
			{ "B", " ", " ", " ", " ", " ", "B", "B", "B" },
			{ "B", " ", " ", " ", "B", " ", "B", " ", "B" },
			{ "B", " ", " ", " ", "B", " ", " ", " ", "B" },
			{ "B", "B", "B", "B", "B", "B", "B", "B", "B" } };
	
	public BattleField(){
		
	}
	
	public String[][] getBattleField(){
		return battleField;
	}
	
	public BattleField(String[][] battlefield){
		this.battleField = battlefield;
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
	
	private String getQuadrantXY(int coordinateY, int coordinateX) {
		String result = (coordinateY - ActionField.STEP) * ActionField.PIXELS_IN_CELL + "_"
				+ (coordinateX - ActionField.STEP) * ActionField.PIXELS_IN_CELL;
		return result;
	}
	
	public void draw(Graphics g){
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

		for (int j = 0; j < this.getDimensionY(); j++) {
			for (int k = 0; k < this.getDimensionX(); k++) {
				if (this.scanQuadrant(j, k).equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}
	}
}

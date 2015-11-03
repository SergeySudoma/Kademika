package Day_4_Tank_Two_New_Tanks;

public class BattleField {
	
	private int bfWidth = 576;
	private int bfHeight = 576;
	
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
	
}

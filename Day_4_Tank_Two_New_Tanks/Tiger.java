package Day_4_Tank_Two_New_Tanks;

public class Tiger extends Tank{
	
	private int armor;

	public Tiger(BattleField bf, ActionField af, int x, int y,
			Direction direction) {
		super(bf, af, x, y, direction);
		
	}
	
	public int getArmor(){
		return armor;
	}
	
}

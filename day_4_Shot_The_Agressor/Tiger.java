package day_4_Shot_The_Agressor;

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

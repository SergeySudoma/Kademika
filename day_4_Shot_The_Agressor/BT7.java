package day_4_Shot_The_Agressor;

public class BT7 extends Tank{

	private int speed = 2 * getSpeed();
	
	public BT7(BattleField bf, ActionField af, int x, int y, Direction direction) {
		super(bf, af, x, y, direction);
		
	}	
	
	public int getSpeed(){
		return speed;
	}
	
}

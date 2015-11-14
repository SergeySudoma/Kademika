package day_4_Abstract_Tank;

public class BT7 extends AbstractTank{

	private int speed = 2 * getSpeed();
	
	public BT7(BattleField bf, ActionField af, int x, int y, Direction direction) {
		super(bf, af, x, y, direction);
		
	}	
	
	public int getSpeed(){
		return speed;
	}
	
}

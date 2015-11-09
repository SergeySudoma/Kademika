package day_4_armor_for_tiger;

public class Tiger extends Tank{
	
	private int armor = 2;

	public Tiger(BattleField bf, ActionField af, int x, int y,
			Direction direction) {
		super(bf, af, x, y, direction);
		
	}
	
	public int getArmor(){
		return armor;
	}
	
	public int delArmor(){
		return armor = armor - 1;
	}
	
	
	public void fly(){
		System.out.println("flyyy");
	}
	
}

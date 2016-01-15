package lesson_7_smart_sor;

import java.awt.Color;

public class FlyingTank extends AbstractTank{
	
	public FlyingTank(int ID, Color color, int health){
		super(ID, color, ID);
	}
	
	public void fly(){
		System.out.println("FLY");
	}

}

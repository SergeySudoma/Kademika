package lesson_7_personal_box;

import java.awt.Color;

public abstract class AbstractTank {

	private int ID;
	private Color color;
	private int health;
	
	public AbstractTank(int ID, Color color, int health){
		this.ID = ID;
		this.color = color;
		this.health = health;
	}
	
	
	public void fire(){
		System.out.println("FIRE");
	}
	
	public void move(){
		System.out.println("MOVE");
	}
}

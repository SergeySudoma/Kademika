package lesson_7_Create_Objects_With_Constructor;

import java.awt.Color;

public class Tank {

	private int ID;
	private Color color;
	private int health;
	
	public Tank(int ID, Color color, int health){
		this.ID = ID;
		this.color = color;
		this.health = health;
	}
	
	public Tank(int ID, Color color){
		this.ID = ID;
		this.color = color;
	}
	
	public Tank(int ID){
		this.ID = ID;
	}
	
	public void fire(){
		System.out.println("FIRE");
	}
	
	public void move(){
		System.out.println("MOVE");
	}
	

	public int getID() {
		return ID;
	}


	public void setID(int iD) {
		ID = iD;
	}


	public Color getColor() {
		return color;
	}


	public void setColor(Color color) {
		this.color = color;
	}


	public int getHealth() {
		return health;
	}


	public void setHealth(int health) {
		this.health = health;
	}
}

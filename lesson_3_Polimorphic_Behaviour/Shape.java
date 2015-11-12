package lesson_3_Polimorphic_Behaviour;

public class Shape {

	public void draw(){
		System.out.println("drawing " + this.getClass().getSimpleName());
	}
	
}

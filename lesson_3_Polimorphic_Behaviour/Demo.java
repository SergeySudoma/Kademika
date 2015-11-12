package lesson_3_Polimorphic_Behaviour;

public class Demo {
	
	public static void main(String[] args){
		
		Shape shape = new Shape();
		Circle circle = new Circle();
		Rectangle rectangle = new Rectangle();
		Triangle triangle = new Triangle();
		
		shape.draw();
		circle.draw();
		rectangle.draw();
		triangle.draw();
		
	}

}

package lesson_3_Add_Square;

public class Demo {
	
	public static void main(String[] args){

		Shape[] shapes = {new Circle(), new Rectangle(), new Triangle(), new Shape(), new Square()}; 
		
		ShapesTemplate st = new ShapesTemplate(shapes);		
	}
}

package lesson_3_Interface_Drawable;

public class Demo {
	
	public static void main(String[] args){

		Shape[] shapes = {new Circle(), new Rectangle(), new Triangle(), new Square()}; 
		
		ShapesTemplate st = new ShapesTemplate(shapes);		
	}
}

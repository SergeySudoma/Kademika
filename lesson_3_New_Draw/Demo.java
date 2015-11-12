package lesson_3_New_Draw;

public class Demo {
	
	public static void main(String[] args){

		Shape[] shapes = {new Circle(), new Rectangle(), new Triangle(), new Shape()}; 
		
		ShapesTemplate st = new ShapesTemplate(shapes);		
	}
}

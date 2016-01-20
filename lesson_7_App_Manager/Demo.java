package lesson_7_App_Manager;

public class Demo {

	public static void main(String[] args) {
		
		ApplicationManager am = new ApplicationManager();
		
		am.serviceCheck(Class_one.class);
		am.serviceCheck(Class_two.class);

	}
}

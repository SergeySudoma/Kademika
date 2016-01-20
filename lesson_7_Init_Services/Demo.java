package lesson_7_Init_Services;

import java.lang.reflect.InvocationTargetException;

public class Demo {

	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {
		
		ApplicationManager am = new ApplicationManager();
		
		am.serviceCheck(Class_one.class);
		am.serviceCheck(Class_two.class);

	}
}

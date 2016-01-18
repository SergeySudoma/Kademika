package lesson_7_Get_Know_About_Class;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Demo {

	public static void main(String[] args) {
		
		printClassInfo(HeavyTank.class);
		System.out.println();
		printClassMethods(Tank.class);
		System.out.println();
		printClassMethods(Tank.class);

	}
	
	public static void printClassInfo(Class c){
		while(true){
			System.out.println(c);
			c = c.getSuperclass();
			if(c == Object.class){
				System.out.println(c);
				break;
			}
		}
	}
	
	public static void printClassMethods(Class c){
		Method[] methods = c.getMethods();
		for(Method m : methods){
			System.out.println(m);
		}
	}
	
	public static void printClassFields(Class c){
		Field[] fields = c.getFields();
		for(Field f : fields){
			System.out.println(f);
		}
	}

}

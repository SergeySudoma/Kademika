package lesson_7_Create_Objects_With_Constructor;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Demo {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchMethodException, SecurityException{
		
		ObjectIniter oi = new ObjectIniter();
		
		List<Object> list = new ArrayList<Object>();
		list.add(5);
		list.add(Color.BLACK);
		
		Tank tank = (Tank) oi.initClass(Tank.class, list);
		System.out.println(tank);
		System.out.println(tank.getHealth());
		System.out.println(tank.getID());
		System.out.println(tank.getColor());
	}

}

package lesson_7_Set_Privates;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException, NoSuchFieldException, SecurityException{
		
		PrivateSetter ps = new PrivateSetter();
		
		Map<String, Object> map = new HashMap<>();
		map.put("ID", 5);
		map.put("color", Color.BLACK);
		map.put("health", 100);
		
		Tank tank = new Tank();
		
		ps.setPrivates(tank, map);
		
		System.out.println(tank.getHealth());
		System.out.println(tank.getID());
		System.out.println(tank.getColor());
	}

}

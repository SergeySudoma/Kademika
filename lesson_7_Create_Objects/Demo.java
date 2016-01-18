package lesson_7_Create_Objects;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;

public class Demo {
	
	public static void main(String[] args) throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		
		ObjectIniter oi = new ObjectIniter();
		
		Map<String, Object> map = new HashMap<>();
		map.put("ID", 5);
		map.put("Color", Color.BLACK);
		map.put("Health", 100);
		
		Tank tank = (Tank) oi.initClass(Tank.class, map);
		
		System.out.println(tank.getHealth());
		System.out.println(tank.getID());
		System.out.println(tank.getColor());
	}

}

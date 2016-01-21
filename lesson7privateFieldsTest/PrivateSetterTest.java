package lesson7privateFieldsTest;

import static org.junit.Assert.*;

import java.awt.Color;
import java.util.HashMap;
import java.util.Map;

import lesson_7_Set_Privates.PrivateSetter;

import org.junit.Before;
import org.junit.Test;

public class PrivateSetterTest {
	
	PrivateSetter ps;	
	Map<String, Object> map;
	Tank tank;

	
	@Before
	public void init(){
		ps = new PrivateSetter();
		map = new HashMap<>();
		map.put("ID", 5);
		map.put("color", Color.BLACK);
		map.put("health", 100);
		tank = new Tank();

	}
	
	@Test
	public void wrongArgsParamsTest() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException{
		map.put("color", Color.BLACK);
		ps.setPrivates(tank, map);
	}

	@Test
	public void testSetPrivates() throws NoSuchFieldException, SecurityException, IllegalArgumentException, IllegalAccessException {
		ps.setPrivates(tank, map);
		assertEquals(5, tank.getID());
		assertEquals(Color.BLACK, tank.getColor());
		assertEquals(100, tank.getHealth());
	}

}

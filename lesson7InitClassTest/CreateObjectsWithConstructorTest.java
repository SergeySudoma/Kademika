package lesson7InitClassTest;

import static org.junit.Assert.*;

import java.awt.Color;
import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;

import org.junit.*;

public class CreateObjectsWithConstructorTest {

	ObjectIniter oi;
	List<Object> list;
	Tank tank;
	
	@Before
	public void init(){
		oi = new ObjectIniter();
	}
	
	@Test(expected = NullPointerException.class)  
	public void zeroListSizeTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException {		
		list = new ArrayList<Object>();
		tank = (Tank) oi.initClass(Tank.class, list);
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void wrongArgumentsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		list = new ArrayList<Object>();
		list.add("hello");
		list.add("hello");
		tank = (Tank) oi.initClass(Tank.class, list);
	}
	
	@Test
	public void twoFieldsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		list = new ArrayList<Object>();
		list.add(5);
		list.add(Color.RED);
		tank = (Tank) oi.initClass(Tank.class, list);
		assertEquals(5, tank.getID());
		assertEquals(Color.RED, tank.getColor());
	}
	
	@Test
	public void threeFieldsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		list = new ArrayList<Object>();
		list.add(5);
		list.add(Color.RED);
		list.add(100);
		tank = (Tank) oi.initClass(Tank.class, list);
		assertEquals(5, tank.getID());
		assertEquals(Color.RED, tank.getColor());
		assertEquals(100, tank.getHealth());
	}
	
	@Test
	public void fourFieldsTest() throws InstantiationException, IllegalAccessException, IllegalArgumentException, InvocationTargetException{
		list = new ArrayList<Object>();
		list.add(5);
		list.add(Color.RED);
		list.add(100);
		list.add(100);
		tank = (Tank) oi.initClass(Tank.class, list);
		assertEquals(5, tank.getID());
		assertEquals(Color.RED, tank.getColor());
		assertEquals(100, tank.getHealth());
	}

}

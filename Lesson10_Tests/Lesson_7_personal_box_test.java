package testCases;

import static org.junit.Assert.*;

import java.awt.Color;

import lesson_7_personal_box.FlyingTank;
import lesson_7_personal_box.SwimmingTank;

import org.junit.Before;
import org.junit.Test;

public class Lesson_7_personal_box_test {
		
	FlyingTank fly;
	SwimmingTank swim;	
	
	@Before
	public void init(){
		fly = new FlyingTank();
		swim = new SwimmingTank();
	}

	@Test
	public void flyingTankIDTest() {
		assertEquals(0, fly.getID());
	}
	
	@Test
	public void flyingTankColorTest() {
		assertEquals(null, fly.getColor());
	}
	
	@Test
	public void flyingTankHealthTest() {
		assertEquals(0, fly.getHealth());
	}
	
	@Test
	public void swimingTankIDTest() {
		assertEquals(0, swim.getID());
	}
	
	@Test
	public void swimingTankColorTest() {
		assertEquals(null, swim.getColor());
	}
	
	@Test
	public void swimingTankHealthTest() {
		assertEquals(0, swim.getHealth());
	}
	
	@Test
	public void swimingTankSetColorTest() {
		swim.setColor(Color.RED);
		assertEquals(Color.RED, swim.getColor());
	}
	
	@Test
	public void flyingTankSetColorTest() {
		fly.setColor(Color.RED);
		assertEquals(Color.RED, fly.getColor());
	}
	
	@Test
	public void flyingTankSetIDTest() {
		int idFly = 5;
		fly.setID(idFly);
		assertEquals(idFly, fly.getID());
	}

	@Test
	public void swimingTankSetIDTest() {
		int idSwim = 2;
		swim.setID(idSwim);
		assertEquals(idSwim, swim.getID());
	}
	
	
	@Test
	public void swimingTankSetHealthTest() {
		int swimHealth = 100;
		swim.setHealth(swimHealth);
		assertEquals(swimHealth, swim.getHealth());
	}

	@Test
	public void flyingTankSetHealthTest() {
		int flyHealth = 100;
		fly.setHealth(flyHealth);
		assertEquals(flyHealth, fly.getHealth());
	}
	
}

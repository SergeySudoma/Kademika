package lesson_7_personal_box;

import java.awt.Color;

public class Demo {
	
	public static void main(String[] args){
	
		int tankCount = 0;
		
		MyContainer<AbstractTank> container1 = new MyContainer<AbstractTank>();
		container1.addItem(new FlyingTank(++tankCount, Color.BLACK, 100));
		container1.addItem(new SwimmingTank(++tankCount, Color.RED, 100));
		
		MyContainer<String> container2 = new MyContainer<String>();
		container2.addItem("Hello");
		container2.addItem("Sam hello");
	}

}

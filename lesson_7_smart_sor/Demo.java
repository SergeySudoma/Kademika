package lesson_7_smart_sor;

import java.awt.Color;

public class Demo {
	
	public static void main(String[] args){
	
		int tankCount = 0;
		
		MyContainer<AbstractTank> container1 = new MyContainer<AbstractTank>();
		container1.addItem(new FlyingTank(20, Color.BLACK, 100));
		container1.addItem(new SwimmingTank(++tankCount, Color.RED, 100));
		container1.addItem(new SwimmingTank(0, Color.RED, 100));
		container1.addItem(new SwimmingTank(55, Color.RED, 100));

		container1.printContent();
		
		container1.sortByID();
		
		container1.printContent();

	}

}

package lesson_5_manage_layout;

import java.io.IOException;
import java.io.ObjectInputStream.GetField;
import java.text.ParseException;

public class Demo {

	public static void main(String[] args) throws ParseException, IOException, InterruptedException {
		
		Shop shop = new Shop();			
		shop.fillCarsDemo();
		shop.fillCustomersDemo();	
		shop.fillDatabaseDemo();
		
		UI ui = new UI(shop);
		
		shop.printCarsPrice();		
		shop.printCarsQuantity();		
		shop.setToday("2015-11-02");
		shop.printLast7DaySales();
		shop.printTodayTransactions();
		

	}

}

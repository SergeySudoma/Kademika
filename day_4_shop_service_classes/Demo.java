package day_4_shop_service_classes;

import java.io.ObjectInputStream.GetField;
import java.text.ParseException;

public class Demo {

	public static void main(String[] args) throws ParseException {
		
		Shop shop = new Shop();			
		shop.fillCarsDemo();
		shop.fillCustomersDemo();	
		shop.fillDatabaseDemo();
		
		shop.printCarsPrice();		
		shop.printCarsQuantity();		
		shop.setToday("2015-11-02");
		shop.printLast7DaySales();
		shop.printTodayTransactions();
		

	}

}

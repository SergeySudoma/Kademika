package lesson_7_discounts_shop;

import java.io.IOException;
import java.text.ParseException;

public class Demo {

	public static void main(String[] args) throws ParseException, IOException  {
					
		Warehouse warehouse = new Warehouse();
		Database database = new Database();
		Shop shop = new Shop(warehouse, database);	
		UI ui = new UI(shop, database);	
		
		shop.printAvailableCarsQuantity();
	}

}

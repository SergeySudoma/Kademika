package lesson_6_splash_screen;

import java.awt.SplashScreen;
import java.io.IOException;
import java.net.URL;
import java.text.ParseException;

public class Demo {

	public static void main(String[] args) throws ParseException, IOException, InterruptedException  {
		
		SplashScreen splashScreen = SplashScreen.getSplashScreen();
		Thread.sleep(500);
					
		Warehouse warehouse = new Warehouse();
		Database database = new Database();
		Shop shop = new Shop(warehouse, database);	
		UI ui = new UI(shop, database);	
		
		shop.printAvailableCarsQuantity();
	}

}

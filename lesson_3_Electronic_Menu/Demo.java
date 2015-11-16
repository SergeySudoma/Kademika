package lesson_3_Electronic_Menu;

public class Demo {

	public static void main(String[] args) {
		
		Electronic_Menu em = new Electronic_Menu();
			
	
		em.printMenu(); //test menu printing

		em.prepare_BlackCoffee(); // test buy black_coffee
		
		em.putAdditionalSugar(Drinks.BLACK_COFFEE);  // test how additional sugar implies the final price of black_coffee		
		em.prepare_BlackCoffee(); 					 // comparing to standard recipe
		
		em.dontPutSugar(Drinks.BLACK_COFFEE);       // test how zero quantity of sugar implies the final price of black_coffee	
		em.prepare_BlackCoffee(); 				    // comparing to standard recipe
		
		em.otherProducts.addProduct("Belyash with cat's-meat", 16); //test adding new product
		em.printMenu();												//

	}
}

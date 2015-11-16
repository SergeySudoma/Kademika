package lesson_3_Electronic_Menu;

public class Electronic_Menu {
	
	Drinks drink;
	OtherProducts otherProducts;
	
	
	public void printMenu(){
		for(int i = 0; i < Drinks.values().length; i++){
			System.out.print(Drinks.values()[i].toString() + "   ");
			calculatePrice(Drinks.values()[i]);
		}
			for(OtherProducts otherProduct : otherProducts.list){
				System.out.println(otherProduct.getName() + " - Price is: " + otherProduct.getPrice());
			}
		}

	
	public void prepare_BlackCoffee(){
		drink = Drinks.BLACK_COFFEE;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
		
	}
	
	public void prepare_CoffeeWithMilk(){
		drink = Drinks.COFFEE_WITH_MILK;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_Americano(){
		drink = Drinks.AMERICANO;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_Kapuchino(){
		drink = Drinks.KAPUCHINO;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_Mokachino(){
		drink = Drinks.MOCACHINO;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_BlackTea(){
		drink = Drinks.BLACK_TEA;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_GreenTea(){
		drink = Drinks.GREEN_TEA;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	public void prepare_TeaWithBergamot(){
		drink = Drinks.TEA_WITH_BERGHAMOT;
		System.out.println("*************************");
		calculatePrice(drink);
		System.out.println(drink);
		System.out.println("*************************");
	}
	
	private void calculatePrice(Drinks drink){
		double price = 0;
		if(drink.name().equals("TEA_WITH_BERGHAMOT")){		
			price = (drink.getWater().getPrice() * drink.getVolume_water()) + 
					(drink.getSugar().getPrice() * drink.getVolume_sugar()) + 
					(drink.getMilk().getPrice() * drink.getVolume_milk()) +
					(drink.getBase().getPrice() * drink.getVolume_base()) +
					(drink.getBerghmot().getPrice() * drink.getVolume_berghamot());
		}
		
		else{
			price = (drink.getWater().getPrice() * drink.getVolume_water()) + 
					(drink.getSugar().getPrice() * drink.getVolume_sugar()) + 
					(drink.getMilk().getPrice() * drink.getVolume_milk()) +
					(drink.getBase().getPrice() * drink.getVolume_base());
		}
		
		price = price * 1000;
		price = Math.round(price);
		price = price / 1000;
		System.out.println("Price is " + price + " UAH");
	}
	
	
	public void putAdditionalSugar(Drinks drink) {
		drink.setVolume_sugar(drink.getVolume_sugar() + drink.getSugarAdditionalPortion());	
	}
	
	public void putAdditionalMilk(Drinks drink) {
		drink.setVolume_milk(drink.getVolume_milk() + drink.getMilkAdditionalPortion());		
	}
	
	
	public void putReductSugar(Drinks drink) {
		drink.setVolume_sugar(drink.getVolume_sugar() - drink.getSugarAdditionalPortion());	
	}
	
	public void putReductMilk(Drinks drink) {
		drink.setVolume_milk(drink.getVolume_milk() - drink.getMilkAdditionalPortion());		
	}
	
	public void dontPutMilk(Drinks drink){
		drink.setVolume_milk(0);
	}
	
	public void dontPutSugar(Drinks drink){
		drink.setVolume_sugar(0);
	}

}

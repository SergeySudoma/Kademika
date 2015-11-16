package lesson_3_Electronic_Menu;

import java.util.ArrayList;

public class OtherProducts {
	
	private String name;
	private int price;
	public static ArrayList<OtherProducts> list = new ArrayList<OtherProducts>();

	public OtherProducts(String name, int price){
		this.name = name;
		this.price = price;
	}
	
	public static void addProduct(String name, int price){
		getList().add(new OtherProducts(name, price));
	}
	
	public static ArrayList<OtherProducts> getList() {
		return list;
	}
	
	public String getName() {
		return name;
	}

	public int getPrice() {
		return price;
	}
	
}

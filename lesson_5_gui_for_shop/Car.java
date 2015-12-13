package lesson_5_gui_for_shop;

public class Car {
	
	private Model model;
	private int price;
	private int quantity;
	
	Car (Model model, int price, int quantity){
		this.model = model;
		this.price = price;
		this.quantity = quantity;
	}
	
	Car (Model model, int price){
		this.model = model;
		this.price = price;
	}
	
	public Model getModel() {
		return model;
	}
	public void setModel(Model model) {
		this.model = model;
	}
	

	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	
	public int getQuantity() {	
		return quantity ;
	}
	
	@Override
	public String toString() {
		return model + " /  " + " / Price in USD :" + price + " / Quantity available: " + quantity;
	}


}

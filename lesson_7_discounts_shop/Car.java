package lesson_7_discounts_shop;

public class Car {

	private Model model;
	private int priceSale;
	private int pricePurchase;

	public Car() {

	}

	public Car(Model model) {
		this.model = model;
	}

	public Model getModel() {
		return model;
	}

	public void setModel(Model model) {
		this.model = model;
	}

	public void setModel(String model) {
		try {
			for (Model mod : Model.values()) {
				if (model.contains(mod.toString())) {
					setModel(mod);
				}
			}
		} catch (Exception e) {
			System.out.println("Car is not selected. Select car.");
		}
	}

	
	public int getPriceSale() {
		return priceSale;
	}

	public void setPriceSale(int priceSale) {
		this.priceSale = priceSale;
	}

	public int getPricePurchase() {
		return pricePurchase;
	}

	public void setPricePurchase(int pricePurchase) {
		this.pricePurchase = pricePurchase;
	}
}

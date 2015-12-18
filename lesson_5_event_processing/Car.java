package lesson_5_event_processing;

public class Car {
	
	private Model model;
	private int priceSale;
	private int pricePurchase;
	
	public Car(){
		
	}
	
	public Car(Model model){
		this.model = model;
	}
	
	public Model getModel() {
		return model;
	}
	
	public void setModel(Model model) {
		this.model = model;
	}
	
	public void setModel(String model) {
		for(Model mod : Model.values()){
			if(model.contains(mod.toString())){
				setModel(mod);
			}
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

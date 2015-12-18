package lesson_5_event_processing;

import java.util.ArrayList;
import java.util.HashMap;

public class Database {

	private ArrayList<Deal> salesList;
	private ArrayList<Deal> purchaseList;
	private HashMap<Model, Integer> purchasePrices;
	private double margin = 25; // in %
	
	public Database(){
		salesList = new ArrayList<Deal>();
		purchaseList = new ArrayList<Deal>();
		purchasePrices = new HashMap<Model, Integer>();
		fillPurchasePrices();
	}
	
	private void fillPurchasePrices() {
		purchasePrices.put(Model.AUDI_A6, (Integer)7000);
		purchasePrices.put(Model.BMW_X5, (Integer)27000);
		purchasePrices.put(Model.DODGE_NEON, (Integer)6000);
		purchasePrices.put(Model.OPEL_KADETT, (Integer)3000);
		purchasePrices.put(Model.SUBARU_FORESTER, (Integer)8000);
	}
	
	public void updatePurchasePrice(Model model, int newPurchasePrice){
		purchasePrices.put(model, (Integer)newPurchasePrice);
	}
	
	public int getPurchasePrice(Model model){
		return purchasePrices.get(model);
	}

	public int getSalePrice(Model model){
		return (int)(purchasePrices.get(model) / ((100 - margin) / 100));  
		
	}
	
	public void addSalesList(Deal deal){
		salesList.add(deal);
	}
	
	public void addPurchaseList(Deal deal){
		purchaseList.add(deal);
	}

	public ArrayList<Deal> getSalesList() {
		return salesList;
	}

	public ArrayList<Deal> getPurchaseList() {
		return purchaseList;
	}

	public double getMargin() {
		return margin;
	}

	public void setMargin(double margin) {
		this.margin = margin;
	}
	
}

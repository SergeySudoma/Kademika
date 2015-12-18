package lesson_5_event_processing;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

public class Shop {

	private Warehouse warehouse;
	private Database database;
	private Date date;
	private Deal deal;
	private int cash = 50000;

	public Shop(Warehouse warehouse, Database database) {
		this.warehouse = warehouse;
		this.database = database;
	}

	public void sellCar(Car car, Customer customer, int quantity) throws ParseException {
		if (warehouse.checkAvailability(car, quantity)) {
			deal = new Deal();
			deal.setCar(car);
			deal.setCustomer(customer);
			deal.setDate(setDate());
			deal.setPrice(database.getSalePrice(car.getModel()));
			deal.setQuantity(quantity);
			database.addSalesList(deal);
			warehouse.removeCar(car, quantity);
			cash = cash + database.getSalePrice(car.getModel());
			System.out.println(quantity + " " + car.getModel() + " is sold to "+ customer.getName() + " " + parseStringDate(date)  + " Bank account: $" + cash);
		}
		if(car.getModel() != null){
			
		}
		else{
			System.out.println("Not enough on stock");
		}
	}


	private Date setDate() {
		Date d = new Date();
		date = d; 
		return d;
	}

	public void purchaseCar(Car car) {
		deal = new Deal();
		deal.setCar(car);
		deal.setDate(new Date());
		deal.setPrice(database.getPurchasePrice(car.getModel()));
		deal.setQuantity(1);
		database.addPurchaseList(deal);
		warehouse.addCar(car);
		cash = cash - database.getPurchasePrice(car.getModel());
		System.out.println("Bought " + car.getModel() + ". Cash left: " + cash);
	}

	public void printAvailableCarsQuantity() {
		int oneCar = 1;
		HashMap<Car, Integer> quantityReport = new HashMap<Car, Integer>();
		for (Car car : warehouse.getcarList()) {
			if (!quantityReport.containsKey(car)) {
				quantityReport.put(car, oneCar);
			} else {
				quantityReport.put(car, quantityReport.get(car) + oneCar);
			}
		}
		System.out.println("**********Cars quantity**********");
		
		for(Map.Entry<Car, Integer> pair : quantityReport.entrySet()){
			System.out.println(pair.getKey().getModel() + " - " + pair.getValue());
		}
		
		System.out.println("**********************************");
	}

	public void printCarsPrice() {
		System.out.println("**********Cars pricelist**********");
		for (Car car : warehouse.getcarList()) {
			System.out.println("Model: " + car.getModel() + " / Price in USD: "
					+ database.getSalePrice(car.getModel()));
		}
		System.out.println("**********************************");
	}

	private String parseStringDate(Date date) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		return format.format(date);
	}

	public void printTodayTransactions() throws ParseException {

		Date today = new Date();
		int count = 0;
		int priceSumm = 0;
		int quantitySumm = 0;

		System.out
				.println("*********************Today transactions**********************");
		System.out
				.println("No.      Client          Car      Price,USD      Quantity,pcs");

		for (Deal deal : database.getSalesList()) {
			if (parseStringDate(deal.getDate()).equals(parseStringDate(today))) {
				count++;
				System.out.println(count + "      "
						+ deal.getCustomer().getName() + "      "
						+ deal.getCar().getModel() + "      "
						+ deal.getCar().getPriceSale() + "                "
						+ deal.getQuantity());

				priceSumm += deal.getCar().getPriceSale();
				quantitySumm += deal.getQuantity();
			}
		}
		System.out
				.println("*************************************************************");
		System.out.println("In total: " + count + " pcs "
				+ "                  " + priceSumm + "                 "
				+ quantitySumm);

	}

	public void printLast7DaySales() throws ParseException {
		int[] soldQuantity = new int[7];
		long todayInMiliSec = new Date().getTime();
		long sevenDaysInMiliSec = 7 * 24 * 60 * 60 * 1000;
		long oneDayInMiliSec = 24 * 60 * 60 * 1000;
		int count = 0;
		ArrayList<Deal> salesList = database.getSalesList();

		for (long i = todayInMiliSec; i >= todayInMiliSec - sevenDaysInMiliSec; i -= oneDayInMiliSec) {
			for (int j = 0; j < salesList.size(); j++) {
				if (salesList.get(j).getDate().getTime() == i) {
					soldQuantity[count] += salesList.get(j).getQuantity();
				}
			}
			count++;
		}

		System.out.print("Sales for last 7 days: ");
		for (int i = 0; i < soldQuantity.length; i++) {
			System.out.print(soldQuantity[i] + " ");
		}
		System.out.println();
	}
	
	public int getSalesPrice(Model model){
		return database.getSalePrice(model);
	}

}

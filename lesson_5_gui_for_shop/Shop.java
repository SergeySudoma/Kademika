package lesson_5_gui_for_shop;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Shop {

	private Car car;
	private Car[] cars;
	private int quantity;
	private Customer customer;
	private Customer[] customers;
	private String date;
	private String today;
	private Shop[] databaseSales;
	private static final long sevenDaysInMiliSec = 7 * 24 * 60 * 60 * 1000;
	private static final long oneDayInMiliSec = 24 * 60 * 60 * 1000;

	public Shop() {

	}

	public Shop(Car car, Customer customer, String date, int quantity) {
		this.car = car;
		this.customer = customer;
		this.date = date;
		this.quantity = quantity;
	}

	public void fillDatabaseDemo() {
		Shop item1 = new Shop(cars[0], customers[4],
				"2015-11-20", 1);
		Shop item2 = new Shop(cars[1], customers[3],
				"2015-11-21", 1);
		Shop item3 = new Shop(cars[2], customers[2],
				"2015-11-22", 1);
		Shop item4 = new Shop(cars[3], customers[1],
				"2015-11-23", 1);
		Shop item5 = new Shop(cars[4], customers[0],
				"2015-11-24", 1);
		Shop item6 = new Shop(cars[1], customers[4],
				"2015-11-25", 11);
		Shop item7 = new Shop(cars[2], customers[3],
				"2015-11-25", 12);
		Shop item8 = new Shop(cars[3], customers[2],
				"2015-11-27", 13);
		Shop item9 = new Shop(cars[4], customers[1],
				"2015-11-28", 14);
		Shop item10 = new Shop(cars[0], customers[0],
				"2015-10-29", 1);
		Shop item11 = new Shop(cars[1], customers[4],
				"2015-10-30", 1);
		Shop item12 = new Shop(cars[2], customers[3],
				"2015-11-02", 1);
		Shop item13 = new Shop(cars[3], customers[2],
				"2015-11-30", 1);
		Shop item14 = new Shop(cars[4], customers[1],
				"2015-11-01", 5);
		Shop item15 = new Shop(cars[0], customers[0],
				"2015-11-02", 5);

		Shop[] databaseDemo = { item1, item2, item3, item4, item5,
				item6, item7, item8, item9, item10, item11, item12, item13,
				item14, item15 };
		
		setDatabaseSales(databaseDemo);
	}
	
	
	public void printTodayTransactions() throws ParseException {
		
		int count = 0;
		int priceSumm = 0;
		int quantitySumm = 0;
		
		System.out.println("*********************Today transactions**********************");
		System.out.println("No.      Client          Car      Price,USD      Quantity,pcs");
		
		for(Shop item : databaseSales){
			if(parseDate(item.getDate()) == parseDate(today)){
				
				count++;
				System.out.println(count + "      " + item.getCustomer().getName() + "      " + item.getCar().getModel() + "      " + item.getCar().getPrice() + "                " + item.getQuantity() );
			
				priceSumm += item.getCar().getPrice();
				quantitySumm += item.getQuantity();			
			}
		}
		System.out.println("*************************************************************");
		System.out.println("In total: " + count + " pcs " + "                  " + priceSumm + "                 " + quantitySumm);
		
	}
	
	
	

	private long parseDate(String date) throws ParseException {

		SimpleDateFormat format = new SimpleDateFormat();
		format.applyPattern("yyyy-MM-dd");
		Date docDate = format.parse(date);

		return docDate.getTime();
	}
	
	
	public void printLast7DaySales()
			throws ParseException {
		
		int[] soldQuantity = new int[7];
		long todayInMiliSec = parseDate(getToday());
		int count = 0;
		
		for(long i = todayInMiliSec; i >= todayInMiliSec - sevenDaysInMiliSec; i -= oneDayInMiliSec){
			for(int j = 0; j < databaseSales.length; j++){
				if(parseDate(databaseSales[j].getDate()) == i){
					soldQuantity[count] += databaseSales[j].getQuantity();		
				}
			}
			count++;
		}
		
		System.out.print("Sales for last 7 days: ");
		for(int i = 0; i < soldQuantity.length; i++){
				System.out.print(soldQuantity[i] + " ");		
		}
		System.out.println();
	}


	public void fillCustomersDemo() {
		Customer cust1 = new Customer("Вася Черный", "067 444 00 11");
		Customer cust2 = new Customer("Вася Белый", "067 444 00 22");
		Customer cust3 = new Customer("Вася Желтый", "067 444 00 33");
		Customer cust4 = new Customer("Вася Синий", "067 444 00 44");
		Customer cust5 = new Customer("Вася Красный", "067 444 00 55");
		Customer cust6 = new Customer("Вася Зеленый", "067 444 00 66");
		Customer cust7 = new Customer("Вася Голубой", "067 444 00 77");
		Customer cust8 = new Customer("Вася Оранжевый", "067 444 00 88");
		Customer cust9 = new Customer("Вася Лиловый", "067 444 00 99");
		Customer cust10 = new Customer("Вася Фиолетовый", "067 444 00 00");

		Customer[] customersDemo = { cust1, cust2, cust3, cust4, cust5, cust6,
				cust7, cust8, cust9, cust10 };

		setCustomers(customersDemo);
	}

	public void fillCarsDemo() {
		Car car1 = new Car(Model.AUDI, 10000, 2);
		Car car2 = new Car(Model.BMW, 15000, 3);
		Car car3 = new Car(Model.DODGE, 4000, 5);
		Car car4 = new Car(Model.OPEL,2000, 10);
		Car car5 = new Car(Model.SUBARU, 7000, 5);

		Car[] carsDemo = { car1, car2, car3, car4, car5 };

		setCars(carsDemo);
	}

	public void printCarsPrice() {
		System.out.println("**********Cars pricelist**********");
		for (Car car : cars) {
			System.out.println("Model: " + car.getModel() + " / Price in USD: "
					+ car.getPrice());
		}
		System.out.println("**********************************");
	}

	public void printCarsQuantity() {
		System.out.println("**********Cars quantity**********");
		for (Car car : cars) {
			System.out.println("Model: " + car.getModel()
					+ " / Quantity in pcs: " + car.getQuantity());
		}
		System.out.println("**********************************");
	}

	private void setCars(Car[] cars) {
		this.cars = cars;

	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Customer getCustomer() {
		return customer;
	}

	public void setCustomer(Customer customer) {
		this.customer = customer;
	}

	public Shop[] getDatabaseSales() {
		return databaseSales;
	}

	public void setDatabaseSales(Shop[] databaseSales) {
		this.databaseSales = databaseSales;
	}

	public Car[] getCars() {
		return cars;
	}

	public Customer[] getCustomers() {
		return customers;
	}

	private void setCustomers(Customer[] customers) {
		this.customers = customers;

	}

	public String getToday() {
		return today;
	}

	public void setToday(String today) {
		this.today = today;
	}

	public long getSevenDaysInMiliSec() {
		return sevenDaysInMiliSec;
	}

	public String getDate() {
		return date;
	}
}

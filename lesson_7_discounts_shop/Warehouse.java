package lesson_7_discounts_shop;

import java.util.ArrayList;

public class Warehouse {
	
	private ArrayList<Car> carList;
	
	public Warehouse(){
		carList = new ArrayList<Car>();
		fillWarehouse();
	}
	
	private void fillWarehouse(){
		carList.add(new Car(Model.AUDI_A6));
		carList.add(new Car(Model.BMW_X5));
		carList.add(new Car(Model.DODGE_NEON));
		carList.add(new Car(Model.OPEL_KADETT));
		carList.add(new Car(Model.SUBARU_FORESTER));
		carList.add(new Car(Model.SUBARU_FORESTER));
	}
	
	public void addCar(Car car){
		carList.add(car);
	}
	
	public void removeCar(Car car, int quantity){
		if(checkAvailability(car, quantity)){
			for(int i = 1; i <= quantity; i++){
				for(Car c : carList){
					if(car.getModel() == (c.getModel())){
						carList.remove(c);
						break;
					}
				}
			}
		}
	}
	
	public boolean checkAvailability(Car car, int quantity){
		int count = 0;
		for(Car c : carList){
			if(car.getModel() == c.getModel()){
				count++;
				if(count >= quantity){
					return true;
				}
			}
		}
		return false;
	}
	
	
	public ArrayList<Car> getcarList(){
		return carList;
	}
	
}

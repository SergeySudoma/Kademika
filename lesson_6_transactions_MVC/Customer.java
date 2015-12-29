package lesson_6_transactions_MVC;

public class Customer {
	
	private String name;
	
	Customer(String name){
		this.name = name;
	}	
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}

	
	@Override
	public String toString() {
		return "Customer name: " + name;
	}
}

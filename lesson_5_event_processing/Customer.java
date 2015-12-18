package lesson_5_event_processing;

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

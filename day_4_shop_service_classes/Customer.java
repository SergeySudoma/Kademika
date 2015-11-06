package day_4_shop_service_classes;

public class Customer {
	
	private String name;
	private String phoneNumber;
	
	Customer(String name, String phoneNumber){
		this.name = name;
		this.phoneNumber = phoneNumber;
	}
	
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Override
	public String toString() {
		return "Name: " + name + "/ Phone no.:" + phoneNumber;
	}
}

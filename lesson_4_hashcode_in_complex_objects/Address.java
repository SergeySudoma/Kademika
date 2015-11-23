package lesson_4_hashcode_in_complex_objects;

public class Address {
	
	String city;
	String street;
	int house;
	
	public Address(String city, String street, int house){
		this.city = city;
		this.street = street;
		this.house = house;
	}
	
	public Address(){
		
	}
	
	@Override
	public int hashCode() {
		int result = 2;
		result = result * 4 + city.hashCode();
		result = result * 5 + street.hashCode();
		result = result * 6 + house;
		return result;
	}
	
	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public int getHouse() {
		return house;
	}

	public void setHouse(int house) {
		this.house = house;
	}
	
}

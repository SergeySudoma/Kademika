package lesson_4_hashcode_in_complex_objects;

public class Person {

	String name;
	int age;
	long salary;
	Address address;
	
	public Person(String name, int age, long salary, Address address){
		this.name = name;
		this.age = age;
		this.salary = salary;
		this.address = address;
	}
	
	public Person(){
		
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person){
			Person temp = (Person)obj;
			if(this.name.equals(temp.name) &&
					(this.age == temp.age) &&
					(this.salary == temp.salary) &&
					(this.address.hashCode() == temp.address.hashCode())){
						return true;
			}
		}
		return false;
	}

	
	
	@Override
	public int hashCode() {
		int result = 30;
		result = result * 2 + name.hashCode();
		result = result * 3 + age;
		result = result * 4 + new Long(salary).hashCode();
		result = result * 5 + address.hashCode();
		
		return result;
	}
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getAge() {
		return age;
	}


	public void setAge(int age) {
		this.age = age;
	}


	public long getSalary() {
		return salary;
	}


	public void setSalary(long salary) {
		this.salary = salary;
	}
}

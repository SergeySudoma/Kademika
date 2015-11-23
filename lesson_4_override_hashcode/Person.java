package lesson_4_override_hashcode;

public class Person {
	
	String name;
	int age;
	long salary;
	
	@Override
	public int hashCode() {
		int result = 30;
		result = result * 2 + name.hashCode();
		result = result * 3 + new Integer(age).hashCode();
		result = result * 4 + new Long(salary).hashCode();
		
		return result;
	}
}

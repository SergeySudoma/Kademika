package lesson_4_hashcode_in_complex_objects;

public class Demo {

	public static void main(String[] args) {
		
		Person person1 = new Person("Vasya", 20, 500, new Address("Kiev", "Java", 1));
		Person person2 = new Person("Petya", 21, 600, new Address("Ternopol", "Lenina", 2));
		Person person3 = new Person("Vasya", 20, 500, new Address("Kiev", "Java", 1));
		
		System.out.println(person1.equals(person1));
		System.out.println(person1.equals(person3));
		System.out.println(person2.equals(person3));

	}

}

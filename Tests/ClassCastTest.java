package Test;

public class ClassCastTest {

	public static void main(String[] args) {
		int a = 5;
		long b = 10;
		int c = (int) b;
		
		Pet a1 = new Pet(); 
		Pet b1 = new Dog();
		//Dog c = (Dog) new Pet();
		

	}
	
	
	public class Pet{
		
	}
	
	public class Dog extends Pet{
		
	}

}

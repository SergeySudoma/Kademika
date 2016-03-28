package Test;

public class Fact {

	public static void main(String[] args) {
//факториал если 0 то 1, если 1, то 1
//найти НОД (у нее 8 шагов)
//фибоначчи через рекурсию
		factorial(4);
		nod(57,18);
	}

	private static void nod(int i, int j) {
		while (true){
			
		}
		
	}

	private static void factorial(int i) {
		int result = 1;
		for(int j = 1; j <= i; j++){
			result *= j;
		}
		System.out.println(result);		
	}
	
	

}

package lesson_3_What_If_Exception;

public class Check {

	public static void main(String[] args) {
		try{
			throw new Exception();
		} catch (Exception e){
			throw new IllegalStateException();		
		}
		finally{
			System.out.println("I want to be printed!");		
		}
	}
}
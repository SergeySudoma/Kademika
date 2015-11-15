package lesson_3_What_If_Return;

public class Check {

	public static void main(String[] args) {

		try{
			return;
		} catch (Exception e){
				e.printStackTrace();		
		}
		finally{
			System.out.println("I want to be executed!");		
		}
	}
}
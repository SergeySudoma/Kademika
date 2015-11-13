package lesson_3_Sudden_Exception;

public class Glyph {
	
	private static Integer count = 0;
	
	public Glyph(){	
		countInc();
		System.out.println(this.getClass().getSimpleName() + " is created. Quantity is " + count);
		countSetNull();
	}

	private void countInc(){
		count++;
	}
	
	
	private void countSetNull() {
		count = null;		
	}
}

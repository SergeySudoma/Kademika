package Test;

public class printInts {

	public static void main(String[] args) {
	
		Thread t1 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 0; i <= 300; i++){			
					System.out.print(i + " / ");
				}
				
			}
		});
		
		System.out.println();
		
		Thread t2 = new Thread(new Runnable() {
			
			@Override
			public void run() {
				for(int i = 300; i >= 0; i--){			
					System.out.print(i + " /");
				}
				
			}
		});
		
		t1.start();
		t2.start();
		


	}

}

package lesson9SkatingRing;

import java.util.Random;

public class GoodWinterDayDemo {

	public static void main(String[] args) {

		System.out.println("Good morning everyone we are opened");

		final SkatingRing skatingRing = new SchoolScatingRing();
		
		final Random random = new Random();
		
		for(int i = 0; i < 10; i++){
			final Skater skater = new Skater("Skater " + i);
			
			new Thread(new Runnable() {
				
				@Override
				public void run() {
					Skates skates = null;
					try {
						skates = skatingRing.getSkates(skater);
						
					while(skates == null){
							synchronized (this) {
								this.wait();
							}
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					sleep(random.nextInt(2000));
					skatingRing.returnSkates(skater, skates);					
				}
				
			}).start();
			
			sleep(random.nextInt(1000));
		}
	}

	private static void sleep(int timeout) {
		try{
			Thread.currentThread().sleep(timeout);
		}
		catch(Exception e){
			
		}
		
	}

}

package lesson9SkatingRingExecutorServise;

import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class GoodWinterDayDemo {

	public static void main(String[] args) {

		System.out.println("Good morning everyone we are opened");

		final SkatingRing skatingRing = new SchoolScatingRing();
		
		final Random random = new Random();
		
		ExecutorService executorService = Executors.newFixedThreadPool(3);
		for(int i = 0 ; i < 10; i++){
			Skater skater = new Skater("Skater" + i);
			executorService.submit(new Runnable() {
			
				@Override
				public void run() {
					Skates skates = null;
					try {
						skates = skatingRing.getSkates(skater);
						Thread.sleep(random.nextInt(1000));
						skatingRing.returnSkates(skater, skates);					
						}
						catch(Exception e){
						}
				}
					
			});
		}		
	}
}

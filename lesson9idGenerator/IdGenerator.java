package lesson9idGenerator;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.atomic.AtomicLong;

public class IdGenerator {
	
	private static AtomicLong id = new AtomicLong(0);

	public static void main(String[] args) {
		
		CountDownLatch countDownLatch = new CountDownLatch(5);
		
		for(int i = 0; i < 5; i++){

			Thread thread1 = new Thread(new Runnable() {
			
				@Override
				public void run() {
				System.out.println(getNextID());
				
			}
			});
			thread1.start();
		}
	}
	
	private static long getNextID(){
		return id.incrementAndGet();
	}

}

package lesson9SkatingRingExecutorServise;

public interface SkatingRing {

	public Skates getSkates(Skater skater) throws InterruptedException;
	public void returnSkates(Skater skater, Skates skates); 
	
}

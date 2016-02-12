package lesson9SkatingRing;

public interface SkatingRing {

	public Skates getSkates(Skater skater) throws InterruptedException;
	public void returnSkates(Skater skater, Skates skates); 
	
}

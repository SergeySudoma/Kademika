package lesson9SkatingRingExecutorServise;

import java.util.LinkedList;

public class SchoolScatingRing implements SkatingRing{
	
	private LinkedList<Skates> skatesList = new LinkedList<Skates>();

	public SchoolScatingRing(){
		initSkatesStock();
	}
	
	private void initSkatesStock(){
		for(int i = 0; i < 2; i++){
			skatesList.addFirst(new Skates());
		}
	}
	
	@Override
	public Skates getSkates(Skater skater) throws InterruptedException {
		System.out.println(skater.getName() + " get skates");
		Skates skates = null;
		try{
			skates = skatesList.getFirst();
			skatesList.removeFirst();
		}
		catch(Exception e){
			return null;
		}			
		return skates;
				
	}

	@Override
	public void returnSkates(Skater skater, Skates skates) {
		System.out.println(skater.getName() + " returned skates");
		skatesList.add(skates);
		
	}

}

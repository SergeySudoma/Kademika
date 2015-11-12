package lesson_3_My_Personal_Exception;

public class Weights {

	public static void main(String[] args){
	
		int maxWeight = 200;
		int currentWeight = getCurrentWeight(); 
		
		try
		{
			
		controlWeight(maxWeight, currentWeight);
		
		}
		
		catch(WeightExceedException e)
		{
			
			e.getMessage();
		
		}
		
	}

	private static void controlWeight(int maxWeight, int currentWeight) throws WeightExceedException {
		
		if (currentWeight > maxWeight){
			throw new WeightExceedException("Maximal weight exceeded!");
		}
		
	}

	private static int getCurrentWeight() {
		return 210;
	}
}
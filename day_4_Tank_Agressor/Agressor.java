package day_4_Tank_Agressor;

public class Agressor extends Tank{
	
	private String coordinates;
	private int separator;
	

	public Agressor(BattleField bf, ActionField af) {
		super(bf, af);
		
		getPredefiendCoordinates();
		this.setX(parseX(coordinates));
		this.setY(parseY(coordinates));
		
	}
	
	private void getPredefiendCoordinates(){		
		String[] coordinatesList = {"", "64_64", "192_192", "448_448"};	
		int randomInt = (int)(System.currentTimeMillis() % 3) + 1;			
		coordinates = coordinatesList[randomInt];
		separator = coordinates.indexOf("_");
	}
	
	private int parseX(String coordinates){		
		return Integer.parseInt(coordinates.substring(0, separator));		
	}
	
	
	private int parseY(String coordinates) {		
		return Integer.parseInt(coordinates.substring(separator + 1,
				coordinates.length()));
	}

	
	
	
		

}

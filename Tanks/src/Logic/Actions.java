package Logic;

public enum Actions {
	
	MOVE_UP("move"), MOVE_DOWN("move"), MOVE_LEFT("move"), MOVE_RIGHT("move"), FIRE("fire"), TURN_UP("turn"),
	TURN_DOWN("turn"), TURN_LEFT("turn"), TURN_RIGHT("turn"), NONE("");

	private String typeOf;

	Actions(String typeOf){
		this.typeOf = typeOf; 	
	}
	
	public String getType(){
		return typeOf;
	}
}

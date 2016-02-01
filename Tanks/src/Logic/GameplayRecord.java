package Logic;

import java.io.Serializable;

public class GameplayRecord implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 7403026897028265591L;
	private Integer tankID;
	private ActionsPair actionsPair;
	private int x;
	private int y;
	
	public GameplayRecord(Integer tankID, int x, int y, ActionsPair actionsPair) {
		this.tankID = tankID;
		this.actionsPair = actionsPair;
		this.x = x;
		this.y = y;
	}
	

	public Integer getTankID() {
		return tankID;
	}

	public ActionsPair getActionsPair() {
		return actionsPair;
	}

	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}
}

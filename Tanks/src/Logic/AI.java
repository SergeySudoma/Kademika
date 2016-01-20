package Logic;

import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import Objects.AbstractObjectOfField;
import Objects.AbstractTank;

public class AI {

	private ActionField af;

	public AI(ActionField af) {
		this.af = af;
	}
	
	public AbstractTank locateNearestTargetTo(AbstractTank tank){

		HashMap<Integer, AbstractTank> map = new HashMap<Integer, AbstractTank>();
		
		for(AbstractTank possibleNearestTank : AbstractTank.getTankList()){
			if(possibleNearestTank.getTankID() != tank.getTankID() && possibleNearestTank.getIsDestroyed() == false){				
				int stepsX = Math.abs(getXdifference(possibleNearestTank, tank));
				int stepsY = Math.abs(getYdifference(possibleNearestTank, tank));				
				int stepsTotal =  stepsX + stepsY;
				map.put(stepsTotal, possibleNearestTank);
			}
		}
		Integer minSteps = Collections.min(map.keySet());
		return map.get(minSteps);
	}
	
	private int getXdifference(AbstractTank tank, AbstractObjectOfField obj){
		String objQuadrant = af.getQuadrant(obj.getX(), obj.getY());
		String tankQuadrant = af.getQuadrant(tank.getX(), tank.getY());
		int objX = af.parseX(objQuadrant) * BattleField.PIXELS_IN_CELL;
		int tankX = af.parseX(tankQuadrant) * BattleField.PIXELS_IN_CELL;
		int xDifference = (objX - tankX) / BattleField.PIXELS_IN_CELL;
		return xDifference;
	}
	
	private int getYdifference(AbstractTank tank, AbstractObjectOfField obj){
		String objQuadrant = af.getQuadrant(obj.getX(), obj.getY());
		String tankQuadrant = af.getQuadrant(tank.getX(), tank.getY());
		int objY = af.parseY(objQuadrant) * BattleField.PIXELS_IN_CELL;		
		int tankY = af.parseY(tankQuadrant) * BattleField.PIXELS_IN_CELL;		
		int yDifference = (objY - tankY) / BattleField.PIXELS_IN_CELL;
		return yDifference;
	}

	public Actions destroyTheTarget(AbstractTank tank, AbstractObjectOfField obj) {
		
		int xDifference = getXdifference(tank, obj);
		int yDifference = getYdifference(tank, obj);		

		Actions act = Actions.NONE;
		
		if(tank.getIsDestroyed() == true){
			return act;
		}

		if (obj.getIsDestroyed() == false) {
			
			if (xDifference > 0 && yDifference == 0){
				tank.setDirection(Direction.RIGHT);
				return Actions.FIRE;
			}
			if (xDifference < 0 && yDifference == 0){
				tank.setDirection(Direction.LEFT);
				return Actions.FIRE;
			}
			if (yDifference < 0 && xDifference == 0){
				tank.setDirection(Direction.UP);
				return Actions.FIRE;
			}
			
			if (yDifference > 0 && xDifference == 0){
				tank.setDirection(Direction.DOWN);
				return Actions.FIRE;
			}

			if (xDifference > 0) {
				if (af.isAvailableForMove(tank, Direction.RIGHT)) {
					return Actions.MOVE_RIGHT;
				} else {
					return Actions.FIRE;
				}

			}

			if (xDifference < 0) {
				if (af.isAvailableForMove(tank, Direction.LEFT)) {
					return Actions.MOVE_LEFT;
				} else {
					return Actions.FIRE;
				}
			}

			if (yDifference < 0) {
				if (af.isAvailableForMove(tank, Direction.UP)) {
					return Actions.MOVE_UP;
				} else {
					return Actions.FIRE;
				}
			}

			if (yDifference > 0) {
				if (af.isAvailableForMove(tank, Direction.DOWN)) {
					return Actions.MOVE_DOWN;
				} else {
					return Actions.FIRE;
				}
			}
		}
		return act;
	}

	private Actions obtainRndAction() {
		Random rnd = new Random();
		Actions[] temp = Actions.values();
		return temp[rnd.nextInt(5)];
	}
}

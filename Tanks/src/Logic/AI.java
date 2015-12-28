package Logic;

import java.util.Random;

import Objects.AbstractObjectOfField;
import Objects.AbstractTank;

public class AI {

	ActionField af;
	BattleField bf;

	public AI(ActionField af, BattleField bf) {
		this.af = af;
		this.bf = bf;
	}

	public Actions destroyTheTarget(AbstractTank tank, AbstractObjectOfField obj) {
		

		Actions act = Actions.NONE;
		
		if(tank.getIsDestroyed() == true){
			return act;
		}


		String objQuadrant = af.getQuadrant(obj.getX(), obj.getY());
		int objX = af.parseX(objQuadrant) * bf.PIXELS_IN_CELL;
		int objY = af.parseY(objQuadrant) * bf.PIXELS_IN_CELL;

		String tankQuadrant = af.getQuadrant(tank.getX(), tank.getY());
		int tankX = af.parseX(tankQuadrant) * bf.PIXELS_IN_CELL;
		int tankY = af.parseY(tankQuadrant) * bf.PIXELS_IN_CELL;

		int xDifference = (objX - tankX) / bf.PIXELS_IN_CELL;
		int yDifference = (objY - tankY) / bf.PIXELS_IN_CELL;

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

package Day_4_Tank_Direction_As_Enum;

public enum Direction {
	UP, DOWN, LEFT, RIGHT;


	public static Direction getDirectionbyNum(int directionNum) {

		Direction direction = null;

		if (directionNum == 1) {
			direction = Direction.UP;
		}

		else if (directionNum == 1) {
			direction = Direction.DOWN;
		}

		else if (directionNum == 3) {
			direction = Direction.LEFT;
		}

		else {
			direction = Direction.RIGHT;
		}

		return direction;

	}
	}





package lesson9FlyingBall;

import java.awt.Color;

public class Demo {

	public static void main(String[] args) {
		Panel panel = new Panel();
		
		panel.getBallList().add(new FlyingBall(0, 0, Color.RED, 5));
		panel.getBallList().add(new FlyingBall(0, 30, Color.BLUE, 6));
		panel.getBallList().add(new FlyingBall(0, 60, Color.GREEN, 7));
		panel.getBallList().add(new FlyingBall(0, 90, Color.YELLOW, 8));
		panel.getBallList().add(new FlyingBall(0, 120, Color.GRAY, 9));
		panel.getBallList().add(new FlyingBall(0, 150, Color.CYAN, 10));
		panel.getBallList().add(new FlyingBall(0, 180, Color.MAGENTA, 11));
		panel.getBallList().add(new FlyingBall(0, 210, Color.PINK, 12));
		panel.getBallList().add(new FlyingBall(0, 230, Color.ORANGE, 13));
	}
}

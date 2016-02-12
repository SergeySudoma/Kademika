package lesson9ThreadsInteraction;

import java.awt.Color;
import java.awt.Graphics;

public class Shuttle {

	private int x;
	private int y = 200;

	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(x, y, 30, 15);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public void updateX() {
		this.x++;
	}
}

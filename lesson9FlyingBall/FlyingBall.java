package lesson9FlyingBall;

import java.awt.Color;
import java.awt.Graphics;

public class FlyingBall extends Thread{
	
	private int x;
	private int y;
	private Color color;
	private int speed;
	
	public FlyingBall(int x, int y, Color color, int speed) {
		this.x = x;
		this.y = y;
		this.color = color;
		this.speed = speed;
		start();
	}
	
	public int getSpeed() {
		return speed;
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
	
	public void draw(Graphics g) {
		g.setColor(color);
		g.fillOval(x, y, 35, 15);
	}

	@Override
	public void run() {
		boolean isGoRight = true;
		
		while(true){
			if(isGoRight){
				x++;
				if(x == 250){
					isGoRight = false;
				}
			}
			else{
				x--;
				if(x == 0){
					isGoRight = true;
				}
			}
			try {
				Thread.sleep(speed);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
	}
}

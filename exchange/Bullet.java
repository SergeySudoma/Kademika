package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet implements Drawable, Destroyable{

	private  int x;
	private  int y;
	Direction direction;
	private int distance;
	private Image image;

	private int speed = 1;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

	}

	void updateX(int x) {
		this.x = this.x + x;
	}

	void updateY(int y) {
		this.y = this.y + y;
	}

	public void destroy() {
		x = -1000;
		y = -1000;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getSpeed(){
		return speed;
	}

	public Direction getDirection() {
		return direction;
	}

	public int getDistance() {
		return distance;
	}

	public void updateDistance() {
		this.distance += 1;
	}

	@Override
	public void draw(Graphics g) {
		
		try {
			image = ImageIO.read(this.getClass().getResource("Bullet.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, getX(), getY(), null);
		
//		g.setColor(new Color(255, 255, 0));
//		g.fillRect(this.getX(), this.getY(), 14, 14);
		
	}
	
	
	

}

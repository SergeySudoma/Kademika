package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Bullet implements Drawable, Destroyable{

	private  int x;
	private  int y;
	Direction direction;
	private int distance;
	protected Image image_up;
	protected Image image_down;
	protected Image image_left;
	protected Image image_right;

	private int speed = 5;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		initImage();
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
	
	private void initImage(){		
		try {

			image_up = ImageIO.read(this.getClass().getResource("Bullet_up.png"));
			image_down = ImageIO.read(this.getClass().getResource("Bullet_down.png"));
			image_left = ImageIO.read(this.getClass().getResource("Bullet_left.png"));
			image_right = ImageIO.read(this.getClass().getResource("Bullet_right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void draw(Graphics g) {
		if (this.getDirection() == Direction.UP) {
			g.drawImage(image_up, getX(), getY(), null);
		} else if (this.getDirection() == Direction.DOWN) {
			g.drawImage(image_down, getX(), getY(), null);
		} else if (this.getDirection() == Direction.LEFT) {
			g.drawImage(image_left, getX(), getY(), null);
		} else {
			g.drawImage(image_right, getX(), getY(), null);
		}
	}
}

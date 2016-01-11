package Objects;

import java.awt.Graphics;
import java.util.ArrayList;

import Logic.BattleField;
import Logic.Destroyable;
import Logic.Direction;
import Logic.Drawable;
import Logic.Tank;

public abstract class AbstractTank extends AbstractObjectOfField implements
		Drawable, Tank, Destroyable {

	private int speed = 10;
	public int actionsCount = 0;
	private Direction direction;
	private String mySimpleName = this.getClass().getSimpleName();
	private static Integer tankIDcount = 0;
	private Integer tankID = tankIDcount;
	private static ArrayList<AbstractTank> tankList = new ArrayList<AbstractTank>();

	public AbstractTank(BattleField bf) {
		this.x = 256;
		this.y = 128;
		this.direction = Direction.UP;
		++tankIDcount;
		tankList.add(this);
	}

	public AbstractTank(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;
		++tankID;
		tankList.add(this);
	}
	
	public Integer getTankID(){
		return tankID;
	}
	
	public static ArrayList<AbstractTank> getTankList(){
		return tankList;
	}

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

	public int getSpeed() {
		return speed;
	}

	public int getX() {
		return x;
	}

	public void updateX(int x) {
		this.x += x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getY() {
		return y;
	}

	public void updateY(int y) {
		this.y += y;
	}

	public Direction getDirection() {
		return direction;
	}

	public void setDirection(Direction direction) {
		this.direction = direction;
	}

	public void turn(Direction direction) throws Exception {
		this.direction = direction;
	}

	public Bullet fire() throws Exception {
		Bullet bullet = new Bullet(x, y, direction);
		bullet.setShooter(tankID);		
		return bullet;
	}

	public String getMySimpleName() {
		return mySimpleName;
	}
}

package Logic;

import Objects.Bullet;

public interface Tank {

	public int getSpeed();
	public int getX();
	public void updateX(int x);
	public void setX(int x);
	public void setY(int y);
	public int getY();
	public void updateY(int y);
	public Direction getDirection();
	public void setDirection(Direction direction);
	public void turn(Direction direction) throws Exception;
	public void moveUp() throws InterruptedException;
	public void moveDown() throws InterruptedException;
	public void moveLeft() throws InterruptedException;
	public void moveRight() throws InterruptedException;
	public Bullet fire() throws Exception;
	public String getMySimpleName();
	public boolean getIsDestroyed();
	public void setDestroyed(boolean isDestroyed);
}

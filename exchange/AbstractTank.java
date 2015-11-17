package lesson_3_Objects_Of_Battlefield;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public abstract class AbstractTank extends JPanel implements Drawable{

	private int x;
	private int y;
	
	private int pixelsInCell = 64;
	private int step = 1;

	private int speed = 2;

	private BattleField bf;
	private ActionField af;
	private Direction direction;
	
	
	public AbstractTank(BattleField bf, ActionField af){
		this.bf = bf;
		this.af = af;
		this.x = 256;
		this.y = 256;
	}
	
	public AbstractTank(BattleField bf, ActionField af, int x, int y, Direction direction){
		this.bf = bf;
		this.af = af;
		this.x = x;
		this.y = y;
		this.direction = direction;

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
	
	public void setX(int x){
		this.x = x;
	}
	
	public void setY(int y){
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

	public void turn(Direction direction) throws Exception {
		this.direction = direction;
		af.processTurn(this);
	}	
	
	public void move(Direction direction) throws Exception {		
		this.direction = direction;
		af.processMove(this);		
	}
	
	
	void fire() throws Exception {
		Bullet bullet = new Bullet(x + 25, y + 25 , direction);
		af.processFire(bullet);
	}
	
	
	public void moveRandom() throws Exception{
		while (true) {
			long rndDig = (System.currentTimeMillis() % 4);
			int rndDigResult = (int) rndDig + 1;
			move(Direction.getDirectionbyNum(rndDigResult));
			Thread.sleep(speed);
		}
	}
	
	
	public void callMoveToQuadrantParams(Direction direction) throws Exception {
		turn(direction);
		fire();
		move(direction);
	}
	
	
	public void moveToQuadrant(int coordinateY, int coordinateX) throws Exception{
		
		int destinationX = coordinateX * pixelsInCell - pixelsInCell;
		int destinationY = coordinateY * pixelsInCell - pixelsInCell;
		int stepsX = (destinationX - x) / step;
		int stepsY = (destinationY - y) / step;

		while (x != destinationX) {
			repaint();
			if (stepsX > 0) {
				callMoveToQuadrantParams(Direction.RIGHT);
			}

			if (stepsX < 0) {
				callMoveToQuadrantParams(Direction.LEFT);
			}
		}

		while (y != destinationY) {
			repaint();
			if (stepsY > 0) {
				callMoveToQuadrantParams(Direction.DOWN);
			}

			if (stepsY < 0) {
				callMoveToQuadrantParams(Direction.UP);
			}
		}
		
	}
	
	public void clean() throws Exception {
		af.countNonEmptyCells();
		moveToQuadrant(1, 1);
		turn(Direction.RIGHT);
		while (af.checkFieldEmpty() == false) {
			fire();
			if (af.checkBulletOutOfField() == true) {
				move(Direction.DOWN);
				turn(Direction.RIGHT);
			}
		}
	}

	public void destroy() {
		updateX(-1000);
		updateY(-1000);
		
	}

	
	
	

}

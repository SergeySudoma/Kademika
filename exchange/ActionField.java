package lesson_3_Objects_Of_Battlefield;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel{


	public static final int PIXELS_IN_CELL = 64;
	public static final int STEP = 1;
	public static final int MIN_DISTANCE = 40;
	private BattleField battleField;
	private T34 defender;
	private Tiger agressor;
	private Bullet bullet;
	private int countNonEmptyCells;
	private String coordinates;
	private int separator;

	
	void runTheGame() throws Exception {		

		getPredefiendCoordinates();
//		agressor = new Tiger(battleField, this, parseX(coordinates), parseY(coordinates), Direction.RIGHT);
		agressor = new Tiger(battleField, this, 64, 64, Direction.RIGHT);
		defender = new T34(battleField, this);
		bullet = new Bullet(-100, -100, Direction.UP);
		
//		agressor.turn(Direction.UP);
//		defender.turn(Direction.UP);
		
		agressor.move(Direction.DOWN);
	}
	
	
	boolean processInterception() throws InterruptedException {
		String coodinates = getQuadrant(bullet.getX(), bullet.getY());
		int separator = coodinates.indexOf("_");
		int checkBulletY = Integer.parseInt(coodinates.substring(0, separator));
		int checkBulletX = Integer.parseInt(coodinates.substring(separator + 1,
				coodinates.length()));

		if (battleField.checkInterception(checkBulletX, checkBulletY) == true){
			battleField.updateObjects(checkBulletX, checkBulletY);
			repaint();
			countNonEmptyCells--;
			return true;
		}
		
		if (getQuadrant(bullet.getX(), bullet.getY()).equals(getQuadrant(agressor.getX(), agressor.getY())) &&
				bullet.getDistance() > MIN_DISTANCE)
		{
			agressor.delArmor();
			bullet.destroy();
			System.out.println(agressor.getArmor());
			if(agressor.getArmor() == 0){
				destroy();
			}
		}
		
		if (getQuadrant(bullet.getX(), bullet.getY()).equals(getQuadrant(defender.getX(), defender.getY())) &&
				bullet.getDistance() > MIN_DISTANCE)
		{
			defender.destroy();
			bullet.destroy();
		}
				
		return false;
	}
	
	private void getPredefiendCoordinates(){		
		String[] coordinatesList = {"", "64_64", "64_320", "448_448"};	
		int randomInt = (int)(System.currentTimeMillis() % 3) + 1;			
		coordinates = coordinatesList[randomInt];
		separator = coordinates.indexOf("_");
	}
	
	private int parseX(String coordinates){		
		return Integer.parseInt(coordinates.substring(0, separator));		
	}
	
	
	private int parseY(String coordinates) {		
		return Integer.parseInt(coordinates.substring(separator + 1,
				coordinates.length()));
	}	
	

	private void destroy() throws InterruptedException {
		agressor.destroy();
		bullet.destroy();
		Thread.sleep(3000);
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, this, parseX(coordinates), parseY(coordinates), Direction.RIGHT);
		repaint();
		
	}

	private String getQuadrant(int x, int y) {
		int x1 = x / PIXELS_IN_CELL;
		int y1 = y / PIXELS_IN_CELL;
		String result = (x1 + "_" + y1);
		return result;
	}

	public boolean checkBulletOutOfField(){
		if (bullet.getX() > battleField.getBfWidth() - 25 || bullet.getX() == 0
				|| bullet.getY() > battleField.getBfWidth() - 25 || bullet.getY() == 0) {
			return true;
		}
		return false;
	}
	

	
	public boolean checkFieldEmpty() {
		if (countNonEmptyCells == 0) {
			return true;
		}
		return false;
	}

	void countNonEmptyCells() {
		for (int i = 0; i < battleField.getDimensionX(); i++) {
			for (int j = 0; j < battleField.getDimensionY(); j++) {
				if (battleField.getBattleField()[i][j].contains("B")) {
					countNonEmptyCells++;
				}
			}
		}
	}
	
	
	

	public ActionField() throws Exception {

		battleField = new BattleField();

		JFrame frame = new JFrame("TANKS GAME");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 15, battleField.getBfHeight() + 35));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		frame.pack();
		frame.setVisible(true);
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		battleField.draw(g);
		defender.draw(g);
		agressor.draw(g);
		bullet.draw(g);
	}
	

	public void processMove(AbstractTank tank) throws Exception {
		
		Direction direction = tank.getDirection();
	
		tank.turn(direction);

		for (int i = 0; i < PIXELS_IN_CELL; i++) {
			Thread.sleep(tank.getSpeed());
			repaint();
			
			if (tank.getY() > 0 && direction == Direction.UP) {
				tank.updateY(-STEP);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved UP");

			}

			else if (tank.getY() < battleField.getBfHeight() - PIXELS_IN_CELL && direction == Direction.DOWN) {
				tank.updateY(+STEP);
				repaint();
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved DOWN");
			}

			else if (tank.getX() > 0 && direction == Direction.LEFT) {
				tank.updateX(-STEP);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved LEFT");
			}

			else if (tank.getX() < battleField.getBfWidth() - PIXELS_IN_CELL && direction == Direction.RIGHT ){
				tank.updateX(STEP);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved RIGHT");
			}
		}
	}

	public void processTurn(AbstractTank tank) throws Exception {
		repaint();
	}

	public void processFire(Bullet bullet) throws Exception {
		
		this.bullet = bullet;

		while (bullet.getX() > 0 && bullet.getX() <= 576 - 25
				&& bullet.getY() > 0 && bullet.getY() <= 576 - 25) {

			if (bullet.getDirection() == Direction.UP) {
				bullet.updateY(-STEP);
				System.out.println(bullet.getX() + " " + bullet.getY());
				bullet.updateDistance();
			}

			else if (bullet.getDirection() == Direction.DOWN) {
				bullet.updateY(+STEP);
				System.out.println(bullet.getX() + " " + bullet.getY());
				bullet.updateDistance();
			}

			else if (bullet.getDirection() == Direction.LEFT) {
				bullet.updateX(-STEP);
				System.out.println(bullet.getX() + " " + bullet.getY());
				bullet.updateDistance();
			}

			else if (bullet.getDirection() == Direction.RIGHT) {
				bullet.updateX(+STEP);
				System.out.println(bullet.getX() + " " + bullet.getY());
				bullet.updateDistance();
			}
			repaint();
			Thread.sleep(bullet.getSpeed());

			if (processInterception()) {
				bullet.destroy();	
				repaint();
			}
		}
}

}

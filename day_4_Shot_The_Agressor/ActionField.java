package day_4_Shot_The_Agressor;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class ActionField extends JPanel{

	private boolean COLORDED_MODE = false;

	private BattleField battleField;
	private Tank tank;
	private Tiger agressor;
	private Bullet bullet;
	private int countNonEmptyCells;
	public static final int PIXELS_IN_CELL = 64;
	public static final int STEP = 1;
	private String coordinates;
	private int separator;
	public static final int MIN_DISTANCE = 40;

	
	void runTheGame() throws Exception {
		
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, this, parseX(coordinates), parseY(coordinates), Direction.RIGHT);
		agressor.turn(Direction.RIGHT);
		tank.turn(Direction.LEFT);
		tank.fire();
		agressor.fire();
	}
	
	
	boolean processInterception() throws InterruptedException {
		String coodinates = getQuadrant(bullet.getX(), bullet.getY());
		int separator = coodinates.indexOf("_");
		int checkBulletY = Integer.parseInt(coodinates.substring(0, separator));
		int checkBulletX = Integer.parseInt(coodinates.substring(separator + 1,
				coodinates.length()));

		if (battleField.scanQuadrant(checkBulletX, checkBulletY) == "B") {
			battleField.updateQuadrant(checkBulletX, checkBulletY, " ");
			repaint();
			countNonEmptyCells--;
			return true;
		}
		
		if (getQuadrant(bullet.getX(), bullet.getY()).equals(getQuadrant(agressor.getX(), agressor.getY())) &&
				bullet.getDistance() > MIN_DISTANCE)
			{
			bullet.destroy();
			agressor.destroy();
			}
		
		
		if (getQuadrant(bullet.getX(), bullet.getY()).equals(getQuadrant(tank.getX(), tank.getY())) &&
				bullet.getDistance() > MIN_DISTANCE)
		{
			tank.destroy();
			bullet.destroy();
		}
				
		return false;
	}
	
	private void getPredefiendCoordinates(){		
		String[] coordinatesList = {"", "64_64", "64_256", "448_448"};	
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

	private String getQuadrantXY(int coordinateY, int coordinateX) {
		String result = (coordinateY - STEP) * PIXELS_IN_CELL + "_"
				+ (coordinateX - STEP) * PIXELS_IN_CELL;
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
		tank = new Tank(battleField, this);
		bullet = new Bullet(-100, -100, Direction.UP);

		JFrame frame = new JFrame("BATTLE FIELD, DAY 2");
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

		int i = 0;
		Color cc;
		for (int v = 0; v < 9; v++) {
			for (int h = 0; h < 9; h++) {
				if (COLORDED_MODE) {
					if (i % 2 == 0) {
						cc = new Color(252, 241, 177);
					} else {
						cc = new Color(233, 243, 255);
					}
				} else {
					cc = new Color(180, 180, 180);
				}
				i++;
				g.setColor(cc);
				g.fillRect(h * 64, v * 64, 64, 64);
			}
		}

		for (int j = 0; j < battleField.getDimensionY(); j++) {
			for (int k = 0; k < battleField.getDimensionX(); k++) {
				if (battleField.scanQuadrant(j, k).equals("B")) {
					String coordinates = getQuadrantXY(j + 1, k + 1);
					int separator = coordinates.indexOf("_");
					int y = Integer.parseInt(coordinates
							.substring(0, separator));
					int x = Integer.parseInt(coordinates
							.substring(separator + 1));
					g.setColor(new Color(0, 0, 255));
					g.fillRect(x, y, 64, 64);
				}
			}
		}



		//tank
		g.setColor(new Color(255, 0, 0));
		g.fillRect(tank.getX(), tank.getY(), 64, 64);
		g.setColor(new Color(0, 255, 0));
		if (tank.getDirection() == Direction.UP) {
			g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
		} else if (tank.getDirection() == Direction.DOWN) {
			g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
		} else if (tank.getDirection() == Direction.LEFT) {
			g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
		} else {
			g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
		}
		
		//agressor
		g.setColor(new Color(0, 255, 0));
		g.fillRect(agressor.getX(), agressor.getY(), 64, 64);
		g.setColor(new Color(255, 0, 0));
		if (agressor.getDirection() == Direction.UP) {
			g.fillRect(agressor.getX() + 20, agressor.getY(), 24, 34);
		} else if (agressor.getDirection() == Direction.DOWN) {
			g.fillRect(agressor.getX() + 20, agressor.getY() + 30, 24, 34);
		} else if (agressor.getDirection() == Direction.LEFT) {
			g.fillRect(agressor.getX(), agressor.getY() + 20, 34, 24);
		} else {
			g.fillRect(agressor.getX() + 30, agressor.getY() + 20, 34, 24);
		}
		

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

	public void processMove(Tank tank) throws Exception {
		
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

	public void processTurn(Tank tank) throws Exception {
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

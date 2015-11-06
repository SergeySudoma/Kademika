package Day_4_Tank_Sefldestruction;

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
	private Bullet bullet;
	private int countNonEmptyCells;
	private int pixelsInCell = 64;
	private int step = 1;
	private int up = 1;
	private int down = 2;
	private int left = 3;
	private int right = 4;
	
	
	void runTheGame() throws Exception {
		
//		tank.fire();
//		tank.move(3);
//		tank.turn(2);
//		tank.fire();
//		tank.fire();
//		tank.move(4);
//		tank.move(2);
//		tank.fire();
//		tank.moveToQuadrant(1, 1);
//		tank.clean();
//		tank.moveRandom();
		tank.destroy();
	}
	
	
	boolean processInterception() {
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
		return false;
	}
	
	

	private String getQuadrant(int x, int y) {
		int x1 = x / pixelsInCell;
		int y1 = y / pixelsInCell;
		String result = (x1 + "_" + y1);
		return result;
	}

	private String getQuadrantXY(int coordinateY, int coordinateX) {
		String result = (coordinateY - step) * pixelsInCell + "_"
				+ (coordinateX - step) * pixelsInCell;
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
			for (int j = 0; j < battleField.getDimensionX(); j++) {
				if (battleField.getBattleField()[i][j].contains("B")) {
					countNonEmptyCells++;
				}
			}
		}
	}
	
	
	

	public ActionField() throws Exception {

		battleField = new BattleField();
		tank = new Tank(battleField, this);
		bullet = new Bullet(-100, -100, -1);

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

		g.setColor(new Color(255, 0, 0));
		g.fillRect(tank.getX(), tank.getY(), 64, 64);

		g.setColor(new Color(0, 255, 0));
		if (tank.getDirection() == 1) {
			g.fillRect(tank.getX() + 20, tank.getY(), 24, 34);
		} else if (tank.getDirection() == 2) {
			g.fillRect(tank.getX() + 20, tank.getY() + 30, 24, 34);
		} else if (tank.getDirection() == 3) {
			g.fillRect(tank.getX(), tank.getY() + 20, 34, 24);
		} else {
			g.fillRect(tank.getX() + 30, tank.getY() + 20, 34, 24);
		}

		g.setColor(new Color(255, 255, 0));
		g.fillRect(bullet.getX(), bullet.getY(), 14, 14);
	}

	public void processMove(Tank tank) throws Exception {
		
		int direction = tank.getDirection();
		this.tank = tank;		
		
		tank.turn(direction);

		for (int i = 0; i < pixelsInCell; i++) {
			Thread.sleep(tank.getSpeed());
			repaint();
			
			if (tank.getY() > 0 && direction == up) {
				tank.updateY(-step);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved UP");

			}

			else if (tank.getY() < battleField.getBfHeight() - pixelsInCell && direction == down) {
				tank.updateY(+step);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved DOWN");
			}

			else if (tank.getX() > 0 && direction == left) {
				tank.updateX(-step);
				System.out.println(tank.getX() + ":" + tank.getY() + " " + "tank moved LEFT");
			}

			else {
				tank.updateX(step);
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

			if (tank.getDirection() == up) {
				bullet.updateY(-step);
			}

			else if (tank.getDirection() == down) {
				bullet.updateY(+step);
			}

			else if (tank.getDirection() == left) {
				bullet.updateX(-step);
			}

			else if (tank.getDirection() == right) {
				bullet.updateX(+step);
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
package Logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.DestroyFailedException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;
import javax.swing.WindowConstants;

import Objects.BT7;
import Objects.Blank;
import Objects.Bullet;
import Objects.BurnedBlank;
import Objects.ExplosionAnimation;
import Objects.ShotAnimation;
import Objects.T34;
import Objects.Tiger;
import Logic.Direction;
import Logic.BattleField;

public class ActionField extends JPanel {

	public static final int PIXELS_IN_CELL = 64;
	public static final int STEP = 1;
	private BattleField battleField;
	private T34 defender;
	private Tiger agressor;
	private BT7 killer;
	private Bullet bullet;
	private String coordinates;
	private int separator;
	private JFrame frame;

	public ActionField() throws Exception {

		battleField = new BattleField();
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, parseX(coordinates),
				parseY(coordinates), Direction.RIGHT);
		defender = new T34(battleField);
		killer = new BT7(battleField, 128, 64, Direction.RIGHT);

		frame = new JFrame("TANKS GAME");
		frame.setLocation(750, 150);
		frame.setMinimumSize(new Dimension(battleField.getBfWidth() + 15,
				battleField.getBfHeight() + 35));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.getContentPane().add(this);
		setLayout(null);
		frame.pack();
		frame.setVisible(true);
		repaint();
	}


	void runTheGame() throws Exception {

//		 while (true) {
//		 if(!defender.getIsDestroyed()){
//		 processAction(defender.setUp(), defender);
//		 }
		destroyTheEagle();
//		 }
	}
	
	private void drawExplosionAnimation(Bullet bullet) throws InterruptedException, IOException{

		int x = bullet.getX() / PIXELS_IN_CELL * PIXELS_IN_CELL;
		int y = bullet.getY() / PIXELS_IN_CELL * PIXELS_IN_CELL;
		int delay = 1000;
		ExplosionAnimation explosionAnimation = new ExplosionAnimation();
		explosionAnimation.setBounds(x, y, PIXELS_IN_CELL, PIXELS_IN_CELL);
		explosionAnimation.setOpaque(false);
		add(explosionAnimation);
		battleField.addToList(new BurnedBlank(x, y));
		
		Timer timer = new Timer(delay, new ActionListener() {			
			
            @Override
            public void actionPerformed(ActionEvent e) {
                
                remove(explosionAnimation);
            }
        });
        timer.start();

}
	
	
	private void drawShotAnimation(Bullet bullet){

		int xShift = 3;
		int yShift = 50;
		int dimensionX = 50;
		int dimensionY = 50;
		int delay = 300;
		ShotAnimation shotAnimation = new ShotAnimation(bullet);
		if(bullet.getDirection() == Direction.UP){
			shotAnimation.setBounds(bullet.getX() - xShift, bullet.getY() - yShift, dimensionX, dimensionY);
		}
		else if(bullet.getDirection() == Direction.DOWN){
			shotAnimation.setBounds(bullet.getX() - xShift, bullet.getY() + yShift, dimensionX, dimensionY);
		}
		else if(bullet.getDirection() == Direction.LEFT){
			shotAnimation.setBounds(bullet.getX() - yShift, bullet.getY() + xShift, dimensionX, dimensionY);
		}
		else{
			shotAnimation.setBounds(bullet.getX() + yShift, bullet.getY() + xShift, dimensionX, dimensionY);
		}
		shotAnimation.setOpaque(false);
		add(shotAnimation);
		
		Timer timer = new Timer(delay, new ActionListener() {			
			
            @Override
            public void actionPerformed(ActionEvent e) {
                
                remove(shotAnimation);
            }
        });
        timer.start();
	}
	
	public void destroyTheEagle() throws Exception {
		int eagleX = battleField.getEagleX() / battleField.PIXELS_IN_CELL * battleField.PIXELS_IN_CELL;
		int eagleY = battleField.getEagleY() / battleField.PIXELS_IN_CELL  * battleField.PIXELS_IN_CELL;
		
		int killerX = killer.getX() / battleField.PIXELS_IN_CELL * battleField.PIXELS_IN_CELL;
		int killerY = killer.getY() / battleField.PIXELS_IN_CELL * battleField.PIXELS_IN_CELL;

		int xDif = (eagleX - killerX) / battleField.PIXELS_IN_CELL;
		int yDif = (eagleY - killerY) / battleField.PIXELS_IN_CELL;
		
		for (int i = 1; i <= Math.abs(xDif); i++) {
			if (xDif > 0) {
				processAction(Actions.MOVE_RIGHT, killer);
				processAction(Actions.FIRE, killer);
			} else if (xDif < 0) {
				processAction(Actions.MOVE_LEFT, killer);
				processAction(Actions.FIRE, killer);
			}
		}
			if (yDif < 0) {
				processAction(Actions.TURN_UP, killer);
			} else if (yDif > 0) {
				processAction(Actions.TURN_DOWN, killer);
			}
			
		while (battleField.getEagle().getIsDestroyed() == false) {
			processAction(Actions.FIRE, killer);
		}
	}

	private boolean isAvailableForMove(Tank tank) {
		if (tank.getDirection() == Direction.UP) {
			if (battleField.checkQuadrant(tank.getX() / PIXELS_IN_CELL,
					(tank.getY() - PIXELS_IN_CELL) / PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else if (tank.getDirection() == Direction.DOWN) {
			if (battleField.checkQuadrant(tank.getX() / PIXELS_IN_CELL,
					(tank.getY() + PIXELS_IN_CELL) / PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else if (tank.getDirection() == Direction.LEFT) {
			if (battleField.checkQuadrant((tank.getX() - PIXELS_IN_CELL)
					/ PIXELS_IN_CELL, tank.getY() / PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else {
			if (battleField.checkQuadrant((tank.getX() + PIXELS_IN_CELL)
					/ PIXELS_IN_CELL, tank.getY() / PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}
		return false;
	}

	private void processAction(Actions action, Tank tank) throws Exception {
		if (action == Actions.MOVE_UP) {
			processMove(tank);
		}

		else if (action == Actions.MOVE_DOWN) {
			processMove(tank);
		}

		else if (action == Actions.MOVE_LEFT) {
			processMove(tank);
		}

		else if (action == Actions.MOVE_RIGHT) {
			processMove(tank);
		}

		else if (action == Actions.FIRE) {
			processFire(tank.fire());
		}

		else if (action == Actions.TURN_UP) {
			tank.setDirection(Direction.UP);
		}

		else if (action == Actions.TURN_DOWN) {
			tank.setDirection(Direction.DOWN);
		}

		else if (action == Actions.TURN_LEFT) {
			tank.setDirection(Direction.LEFT);
		}

		else if (action == Actions.TURN_RIGHT) {
			tank.setDirection(Direction.RIGHT);
		}
		repaint();
	}

	private void processMove(Tank tank) throws InterruptedException {
		if (isAvailableForMove(tank)) {
			for (int i = 0; i < battleField.PIXELS_IN_CELL; i++) {
				Thread.sleep(tank.getSpeed());
				this.repaint();

				if (tank.getY() > 0 && tank.getDirection() == Direction.UP) {
					tank.updateY(-STEP);
				}

				else if (tank.getY() < battleField.getBfHeight()
						- PIXELS_IN_CELL
						&& tank.getDirection() == Direction.DOWN) {
					tank.updateY(+STEP);
				}

				else if (tank.getX() > 0
						&& tank.getDirection() == Direction.LEFT) {
					tank.updateX(-STEP);
				}

				else if (tank.getX() < battleField.getBfWidth()
						- PIXELS_IN_CELL
						&& tank.getDirection() == Direction.RIGHT) {
					tank.updateX(+STEP);
				}
			}
		}
	}

	private boolean processInterception() throws InterruptedException,
			DestroyFailedException {
		String coodinates = getQuadrant(bullet.getX(), bullet.getY());
		separator = coodinates.indexOf("_");
		int checkBulletY = parseX(coodinates);
		int checkBulletX = parseY(coodinates);

		if (battleField.checkInterception(checkBulletX, checkBulletY) == true) {
			battleField.updateObjects(checkBulletX, checkBulletY);
			repaint();
			return true;
		}

		if (getQuadrant(bullet.getX(), bullet.getY()).equals(
				getQuadrant(agressor.getX(), agressor.getY()))
				&& bullet.getShooter().equals(defender.getMySimpleName())) {
			agressor.delArmor();
			if (agressor.getArmor() == 0) {
				agressor.destroy();
			}
		}

		if (getQuadrant(bullet.getX(), bullet.getY()).equals(
				getQuadrant(defender.getX(), defender.getY()))
				&& bullet.getShooter().equals(agressor.getMySimpleName())) {
			defender.destroy();
		}

		return false;
	}

	private void getPredefiendCoordinates() {
		String[] coordinatesList = { "", "64_64", "64_320", "448_448" };
		int randomInt = (int) (System.currentTimeMillis() % 3) + 1;
		coordinates = coordinatesList[randomInt];
		separator = coordinates.indexOf("_");
	}

	private int parseX(String coordinates) {
		return Integer.parseInt(coordinates.substring(0, separator));
	}

	private int parseY(String coordinates) {
		return Integer.parseInt(coordinates.substring(separator + 1,
				coordinates.length()));
	}

	private void destroy() throws InterruptedException, DestroyFailedException {
		agressor.destroy();
		bullet.destroy();
		Thread.sleep(3000);
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, parseX(coordinates),
				parseY(coordinates), Direction.RIGHT);
		repaint();

	}

	private String getQuadrant(int x, int y) {
		int x1 = x / PIXELS_IN_CELL;
		int y1 = y / PIXELS_IN_CELL;
		String result = (x1 + "_" + y1);
		return result;
	}

	private boolean checkBulletOutOfField() {
		if (bullet.getX() > battleField.getBfWidth() - 25 || bullet.getX() == 0
				|| bullet.getY() > battleField.getBfWidth() - 25
				|| bullet.getY() == 0) {
			return true;
		}
		return false;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		battleField.draw(g);

		if (defender != null) {
			defender.draw(g);
		}

		if (agressor != null) {
			agressor.draw(g);
		}

		if (bullet != null) {
			bullet.draw(g);
		}

		if (killer != null) {
			killer.draw(g);
		}
	}

	public void processFire(Bullet bullet) throws Exception {

		this.bullet = bullet;

		drawShotAnimation(bullet);

		while (bullet.getX() > 0 && bullet.getX() <= 576 - 25
				&& bullet.getY() > 0 && bullet.getY() <= 576 - 25) {
			
			if (bullet.getDirection() == Direction.UP) {
				bullet.updateY(-STEP);
			}

			else if (bullet.getDirection() == Direction.DOWN) {
				bullet.updateY(+STEP);
			}

			else if (bullet.getDirection() == Direction.LEFT) {
				bullet.updateX(-STEP);
			}

			else if (bullet.getDirection() == Direction.RIGHT) {
				bullet.updateX(+STEP);
			}
			repaint();
			Thread.sleep(bullet.getSpeed());

			if (processInterception()) {
				drawExplosionAnimation(bullet);
				bullet.destroy();
				repaint();
			}
		}
	}
}

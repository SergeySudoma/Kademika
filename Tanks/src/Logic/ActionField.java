package Logic;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.security.auth.DestroyFailedException;
import javax.swing.JPanel;
import javax.swing.Timer;
import Objects.AbstractTank;
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

	private BattleField battleField;
	private AbstractTank defender;
	private Tiger agressor;
	private BT7 killer;
	private Bullet bullet;
	private String coordinates;
	private AI ai;
	private TankFrame tankFrame;
	private String gameResult = null;
	
	public static final int STEP = 1;
	

	public ActionField(TankFrame tankFrame) throws Exception {
		this.tankFrame = tankFrame;
		initContent();
	}
	
	private void initContent(){
		battleField = new BattleField();
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, parseX(coordinates), parseY(coordinates), Direction.DEFAULT);
		killer = new BT7(battleField, 64, 448, Direction.DEFAULT);
		ai = new AI(this, battleField);
	}
	

	void addT34() {
		defender = new T34(battleField);		
	}
	
	
	void addTiger() {
		defender = new Tiger(battleField);		
	}
	
	void runTheGame() throws Exception {
				
		while(isGameOver() == false){	
			Actions defenderAction = ai.destroyTheTarget(defender, ai.locateNearestTargetTo(defender));
			processAction(defenderAction, defender);

			Actions killerAction = ai.destroyTheTarget(killer, battleField.getEagle());
			processAction(killerAction, killer);
			
			Actions agressorAction = ai.destroyTheTarget(agressor, defender);
			processAction(agressorAction, agressor);
		}	
			tankFrame.addGameOverMenu(gameResult);
	}
	
	
	private boolean isGameOver(){
		if(battleField.getEagle().getIsDestroyed() == true || defender.getIsDestroyed() == true){
			gameResult = "fail";
			return true;
		}
		else if(agressor.getIsDestroyed() == true && killer.getIsDestroyed() == true){
			gameResult = "win";
			return true;
		}		
		return false;		
	}
	

	private void drawExplosionAnimation(Bullet bullet) throws InterruptedException, IOException{

		String explosionQuadrant = getQuadrant(bullet.getX(), bullet.getY());
		int x = parseX(explosionQuadrant) * BattleField.PIXELS_IN_CELL;
		int y = parseY(explosionQuadrant) * BattleField.PIXELS_IN_CELL;;
		
		int delay = 1000;
		
		ExplosionAnimation explosionAnimation = new ExplosionAnimation();
		explosionAnimation.setBounds(x, y, BattleField.PIXELS_IN_CELL, BattleField.PIXELS_IN_CELL);
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
	
	
	boolean isAvailableForMove(Tank tank, Direction direction) {
		if (direction == Direction.UP) {
			if (battleField.checkQuadrant(tank.getX() / BattleField.PIXELS_IN_CELL,
					(tank.getY() - BattleField.PIXELS_IN_CELL) / BattleField.PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else if (direction == Direction.DOWN) {
			if (battleField.checkQuadrant(tank.getX() / BattleField.PIXELS_IN_CELL,
					(tank.getY() + BattleField.PIXELS_IN_CELL) / BattleField.PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else if (direction == Direction.LEFT) {
			if (battleField.checkQuadrant((tank.getX() - BattleField.PIXELS_IN_CELL)
					/ BattleField.PIXELS_IN_CELL, tank.getY() / BattleField.PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}

		else {
			if (battleField.checkQuadrant((tank.getX() + BattleField.PIXELS_IN_CELL)
					/ BattleField.PIXELS_IN_CELL, tank.getY() / BattleField.PIXELS_IN_CELL) instanceof Blank) {
				return true;
			}
		}
		return false;
	}

	private void processAction(Actions action, Tank tank) throws Exception {
		if (action == Actions.MOVE_UP) {
			tank.setDirection(Direction.UP);
			processMove(tank);
		}

		else if (action == Actions.MOVE_DOWN) {
			tank.setDirection(Direction.DOWN);
			processMove(tank);
		}

		else if (action == Actions.MOVE_LEFT) {
			tank.setDirection(Direction.LEFT);
			processMove(tank);
		}

		else if (action == Actions.MOVE_RIGHT) {
			tank.setDirection(Direction.RIGHT);
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
		if (isAvailableForMove(tank, tank.getDirection())) {
			for (int i = 0; i < BattleField.PIXELS_IN_CELL; i++) {
				Thread.sleep(tank.getSpeed());
				this.repaint();

				if (tank.getY() > 0 && tank.getDirection() == Direction.UP) {
					tank.updateY(-STEP);
				}

				else if (tank.getY() < battleField.getBfHeight()
						- BattleField.PIXELS_IN_CELL
						&& tank.getDirection() == Direction.DOWN) {
					tank.updateY(+STEP);
				}

				else if (tank.getX() > 0
						&& tank.getDirection() == Direction.LEFT) {
					tank.updateX(-STEP);
				}

				else if (tank.getX() < battleField.getBfWidth()
						- BattleField.PIXELS_IN_CELL
						&& tank.getDirection() == Direction.RIGHT) {
					tank.updateX(+STEP);
				}
			}
		}
	}

	private boolean processInterception() throws InterruptedException,
			DestroyFailedException {
		String bulletQuadrant = getQuadrant(bullet.getX(), bullet.getY());
		int checkBulletY = parseX(bulletQuadrant);
		int checkBulletX = parseY(bulletQuadrant);

		if (battleField.checkInterception(checkBulletX, checkBulletY) == true) {
			battleField.updateObjects(checkBulletX, checkBulletY);
			repaint();
			return true;
		}

		for(AbstractTank tank : AbstractTank.getTankList()){
				String tankQuadrant = getQuadrant(tank.getX(), tank.getY());
				int tankQuadrantY = parseX(tankQuadrant);
				int tankQuadrantX = parseY(tankQuadrant);
				if(checkBulletX == tankQuadrantX && checkBulletY == tankQuadrantY  && tank.getTankID() != bullet.getShooter()){
					tank.destroy();
					return true;
				}
			}

		return false;
	}

	private void getPredefiendCoordinates() {
		String[] coordinatesList = { "", "64_64", "64_320", "448_448" };
		int randomInt = (int) (System.currentTimeMillis() % 3) + 1;
		coordinates = coordinatesList[randomInt];
	}

	int parseX(String coordinates) {
		return Integer.parseInt(coordinates.substring(0, coordinates.indexOf('_')));
	}

	int parseY(String coordinates) {
		return Integer.parseInt(coordinates.substring(coordinates.indexOf('_') + 1,
				coordinates.length()));
	}

	private void agressorRespawn() throws InterruptedException, DestroyFailedException {
		agressor.destroy();
		bullet.destroy();
		Thread.sleep(3000);
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, parseX(coordinates), parseY(coordinates), Direction.RIGHT);
		repaint();

	}

	String getQuadrant(int x, int y) {
		int quadrantX = x / BattleField.PIXELS_IN_CELL;
		int quadrantY = y / BattleField.PIXELS_IN_CELL;
		return (quadrantX + "_" + quadrantY);
	}

	@Override
	protected void paintComponent(Graphics g) {
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

		while (bullet.getX() >= 0 && bullet.getX() <= 576 - 25
				&& bullet.getY() >= 0 && bullet.getY() <= 576 - 25) {
			
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

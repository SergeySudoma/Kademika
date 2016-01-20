package Logic;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;

import javax.security.auth.DestroyFailedException;
import javax.swing.JPanel;
import javax.swing.Timer;
import Objects.AbstractObjectOfField;
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
	private HashMap<Object, Object> actionsMap = new HashMap<Object, Object>();
	private HashMap<Direction, String> availableDirectionMap = new HashMap<Direction, String>();
	
	public static final int STEP = 1;
	

	public ActionField(TankFrame tankFrame) throws Exception {
		this.tankFrame = tankFrame;
		initContent();
	}
	
	private void initContent(){
		initActionsMap();
		initBattlefield();
		initAgressor();
		initKiller();
		initAI();		
	}
	
	private void initAI() {
		ai = new AI(this);		
	}

	private void initBattlefield(){
		battleField = new BattleField();
	}
	
	private void initAgressor(){
		getPredefiendCoordinates();
		agressor = new Tiger(battleField, parseX(coordinates), parseY(coordinates), Direction.DEFAULT);
	}
	
	private void initKiller(){
		killer = new BT7(battleField, 64, 448, Direction.DEFAULT);
	}

	void addT34() {
		defender = new T34(battleField);		
	}
	
	
	void addTiger() {
		defender = new Tiger(battleField);		
	}
	
	void runTheGame() throws Exception {
				
		while(isGameOver() == false){
			processDefenderMission();
			processAgressorMission();
			processKillerMission();
		}	
			tankFrame.addGameOverMenu(gameResult);
	}
	
	private void processDefenderMission() throws Exception{
		Actions defenderAction = ai.destroyTheTarget(defender, ai.locateNearestTargetTo(defender));
		processAction(defenderAction, defender);
	}
	
	
	private void processKillerMission() throws Exception{
		Actions killerAction = ai.destroyTheTarget(killer, battleField.getEagle());
		processAction(killerAction, killer);
	}
	
	private void processAgressorMission() throws Exception{
		Actions agressorAction = ai.destroyTheTarget(agressor, defender);
		processAction(agressorAction, agressor);
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

		int delay = 300;
		
		ShotAnimation shotAnimation = new ShotAnimation(bullet);
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
	
	private void initAvailableDirectionMap(Tank tank){
		
		int currentQuadrantX = tank.getX() / BattleField.PIXELS_IN_CELL;
		int currentQuadrantY = tank.getY() / BattleField.PIXELS_IN_CELL;
		int oneQuadrant = 1;
		
		String upperQuadrant = String.valueOf(currentQuadrantX) + "_" + String.valueOf(currentQuadrantY - oneQuadrant);
		String lowerQuadrant = String.valueOf(currentQuadrantX) + "_" + String.valueOf(currentQuadrantY + oneQuadrant);
		String lefterQuadrant = String.valueOf(currentQuadrantX - oneQuadrant) + "_" + String.valueOf(currentQuadrantY);
		String righterQuadrant = String.valueOf(currentQuadrantX + oneQuadrant) + "_" + String.valueOf(currentQuadrantY);
		
		availableDirectionMap.put(Direction.UP, upperQuadrant);
		availableDirectionMap.put(Direction.DOWN, lowerQuadrant);
		availableDirectionMap.put(Direction.LEFT, lefterQuadrant);
		availableDirectionMap.put(Direction.RIGHT, righterQuadrant);		
	}
	
	boolean isAvailableForMove(Tank tank, Direction direction) {
		initAvailableDirectionMap(tank);
		String coordinatesToCheck = availableDirectionMap.get(direction);
		int coordinateXtoCheck = parseX(coordinatesToCheck);
		int coordinateYtoCheck = parseY(coordinatesToCheck);
		
		if(battleField.checkQuadrant(coordinateXtoCheck, coordinateYtoCheck) instanceof Blank){
			return true;
		}
		return false;		
	}
	
	private void initActionsMap(){
		actionsMap.put(Actions.MOVE_UP, Direction.UP);
		actionsMap.put(Actions.MOVE_DOWN, Direction.DOWN);
		actionsMap.put(Actions.MOVE_LEFT, Direction.LEFT);
		actionsMap.put(Actions.MOVE_RIGHT, Direction.RIGHT);
		actionsMap.put(Actions.FIRE, Actions.FIRE);
		actionsMap.put(Direction.UP, Direction.UP);
		actionsMap.put(Direction.DOWN, Direction.DOWN);
		actionsMap.put(Direction.LEFT, Direction.LEFT);
		actionsMap.put(Direction.RIGHT, Direction.RIGHT);
	}

	private void processAction(Actions action, Tank tank) throws Exception {
		
		  String actionType = action.getType();
		  Boolean move = actionType.equals("move");
		  Boolean turn = actionType.equals("turn") || move;
		  Boolean fire = actionType.equals("fire");

		  if (turn) tank.setDirection((Direction)actionsMap.get(action));
		  if (move) processMove(tank);
		  if (fire) processFire(tank.fire());

		  repaint();
	}
	
	
	private boolean isInField(AbstractObjectOfField object){		
		boolean checkY = object.getY() > 0 && object.getY() < battleField.getBfHeight()
				- BattleField.PIXELS_IN_CELL;
		boolean checkX = object.getX() > 0 && object.getX() < battleField.getBfWidth()
				- BattleField.PIXELS_IN_CELL;
		boolean result = checkX && checkY;  		
		return result;
	}


	private void processMove(Tank tank) throws InterruptedException {
		if (isInField((AbstractObjectOfField) tank)){
			if (isAvailableForMove(tank, tank.getDirection())) {
				for (int i = 0; i < BattleField.PIXELS_IN_CELL; i++) {
				Thread.sleep(tank.getSpeed());
				this.repaint();

				if (tank.getDirection() == Direction.UP) {
					tank.updateY(-STEP);
				}

				else if (tank.getDirection() == Direction.DOWN) {
					tank.updateY(+STEP);
				}

				else if (tank.getDirection() == Direction.LEFT) {
					tank.updateX(-STEP);
				}

				else if (tank.getDirection() == Direction.RIGHT) {
					tank.updateX(+STEP);
				}
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
		for(Drawable obj : Drawable.drawableList){
			if(obj != null){
				obj.draw(g);
			}
		};
	}

	public void processFire(Bullet bullet) throws Exception {

		this.bullet = bullet;
		int compensation = 25;
		int maximalX = battleField.getBfHeight() - compensation;
		int maximalY = battleField.getBfHeight() - compensation;
		int minimalX = 0;
		int minimalY = 0;

		drawShotAnimation(bullet);

		while (bullet.getX() >= minimalX && bullet.getX() <= maximalX
				&& bullet.getY() >= minimalY && bullet.getY() <= maximalY) {
			
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

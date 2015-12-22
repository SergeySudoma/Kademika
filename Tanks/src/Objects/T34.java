package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;
import Logic.Actions;
import Logic.BattleField;
import Logic.Direction;

public class T34 extends AbstractTank {
	
	public T34(BattleField bf,int x, int y, Direction direction) {
		super(x, y, direction);
		initImages();
	}
	
	public T34(BattleField bf) {
		super(bf);
		initImages();		
	}
	
	private void initImages(){
		
		try {
			image_up = ImageIO.read(this.getClass().getResource("green_tank_up.png"));
			image_down = ImageIO.read(this.getClass().getResource("green_tank_down.png"));
			image_left = ImageIO.read(this.getClass().getResource("green_tank_left.png"));
			image_right = ImageIO.read(this.getClass().getResource("green_tank_right.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private Actions[] actions = {
			Actions.TURN_UP,
			Actions.FIRE,
			Actions.MOVE_UP,
		Actions.FIRE,
	};
	
	public Actions setUp(){
		if(actionsCount >= actions.length){
			actionsCount = 0;
		}
		return actions[actionsCount++];
	}	
}

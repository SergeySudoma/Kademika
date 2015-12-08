package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;
import Logic.Actions;
import Logic.BattleField;
import Logic.Direction;

public class T34 extends AbstractTank {
	
	int index = 0;	

	public T34(BattleField bf,int x, int y, Direction direction) {
		super(bf, x, y, direction);
		initImages();
	}
	
	public T34(BattleField bf) {
		super(bf);
		initImages();		
	}
	
	private void initImages(){
		
		try {
			image_up = ImageIO.read(this.getClass().getResource("Tank1_up.png"));
			image_down = ImageIO.read(this.getClass().getResource("Tank1_down.png"));
			image_left = ImageIO.read(this.getClass().getResource("Tank1_left.png"));
			image_right = ImageIO.read(this.getClass().getResource("Tank1_right.png"));			
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}
	
	private Actions[] actions = {
		Actions.MOVE_UP,
		Actions.MOVE_UP,
		Actions.MOVE_UP,
		Actions.MOVE_UP,
		Actions.MOVE_UP,
		Actions.MOVE_UP,
//		Actions.FIRE,
//		Actions.FIRE,
//		Actions.FIRE,
//		Actions.FIRE,
//		Actions.FIRE
	};
	
	public Actions setUp(){
		if(index >= actions.length){
			index = 0;
		}
		return actions[index++];
	}	
}

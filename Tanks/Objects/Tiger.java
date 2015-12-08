package Objects;

import java.io.IOException;
import javax.imageio.ImageIO;
import Logic.BattleField;
import Logic.Direction;

public class Tiger extends AbstractTank{
	
	private int armor = 2;

	public Tiger(BattleField bf, int x, int y,
			Direction direction) {
		super(bf, x, y, direction);
		initImage();
		
	}
	
	private void initImage() {		
		try {
			image_up = ImageIO.read(this.getClass().getResource("Tank2_up.png"));
			image_down = ImageIO.read(this.getClass().getResource("Tank2_down.png"));
			image_left = ImageIO.read(this.getClass().getResource("Tank2_left.png"));
			image_right = ImageIO.read(this.getClass().getResource("Tank2_right.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}

	public int getArmor(){
		return armor;
	}
	
	public int delArmor(){
		return armor = armor - 1;
	}
}

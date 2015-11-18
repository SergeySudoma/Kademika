package Objects;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

import Logic.ActionField;
import Logic.BattleField;
import Logic.Direction;

public class Tiger extends AbstractTank{
	
	private int armor = 2;
	protected Image image_up;
	protected Image image_down;
	protected Image image_left;
	protected Image image_right;

	public Tiger(BattleField bf, ActionField af, int x, int y,
			Direction direction) {
		super(bf, af, x, y, direction);
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

	
	public void draw(Graphics g) {
		if (this.getDirection() == Direction.UP) {
			g.drawImage(image_up, getX(), getY(), null);
		} else if (this.getDirection() == Direction.DOWN) {
			g.drawImage(image_down, getX(), getY(), null);
		} else if (this.getDirection() == Direction.LEFT) {
			g.drawImage(image_left, getX(), getY(), null);
		} else {
			g.drawImage(image_right, getX(), getY(), null);
		}
	}	
}

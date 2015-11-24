package Objects;

import java.awt.*;
import java.io.IOException;
import java.awt.Graphics;
import javax.imageio.ImageIO;
import Logic.ActionField;
import Logic.BattleField;
import Logic.Direction;

public class T34 extends AbstractTank{

	public T34(BattleField bf, ActionField af, int x, int y, Direction direction) {
		super(bf, af, x, y, direction);
		initImages();
	}
	
	public T34(BattleField bf, ActionField af) {
		super(bf, af);
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
}

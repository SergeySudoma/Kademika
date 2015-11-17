package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

public class T34 extends AbstractTank{

	protected Image image_up;
	protected Image image_down;
	protected Image image_left;
	protected Image image_right;
	
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

package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Tiger extends AbstractTank{
	
	private int armor = 2;
	private Image image;

	public Tiger(BattleField bf, ActionField af, int x, int y,
			Direction direction) {
		super(bf, af, x, y, direction);
		initImage();
		
	}
	
	private void initImage() {		
		try {
			image = ImageIO.read(this.getClass().getResource("Tank2.png"));
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
		g.drawImage(image, getX(), getY(), null);
	}	
}

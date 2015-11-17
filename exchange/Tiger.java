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
		
	}
	
	public int getArmor(){
		return armor;
	}
	
	public int delArmor(){
		return armor = armor - 1;
	}
	
	
	public void fly(){
		System.out.println("flyyy");
	}
	
	public void draw(Graphics g) {
		
		try {
			image = ImageIO.read(this.getClass().getResource("Tank2.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, getX(), getY(), null);
		
//		g.setColor(new Color(0, 255, 0));
//		g.fillOval(this.getX(), this.getY(), 64, 64);
//		g.setColor(new Color(255, 0, 0));
//		if (this.getDirection() == Direction.UP) {
//			g.fillRect(this.getX() + 20, this.getY(), 24, 34);
//		} else if (this.getDirection() == Direction.DOWN) {
//			g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
//		} else if (this.getDirection() == Direction.LEFT) {
//			g.fillRect(this.getX(), this.getY() + 20, 34, 24);
//		} else {
//			g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
//		}	
	}	
}

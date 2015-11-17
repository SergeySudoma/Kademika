package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;

public class Rock extends AbstractObjectOfField {
	
	private Image image;
	
	public Rock(int x, int y){
		super(x, y);
	}


	@Override
	public void draw(Graphics g) {
		
		try {
			image = ImageIO.read(this.getClass().getResource("Rock.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, getX(), getY(), null);
		
		
//		g.setColor(Color.BLACK);
//		g.fillRect(getX(), getY(), 64, 64);
//		g.setColor(Color.ORANGE);
//		g.fillRect(getX() + 45, getY() + 10, 10, 10);
//		g.fillRect(getX() + 25, getY() + 25, 10, 10);
//		g.fillRect(getX() + 10, getY() + 45, 10, 10);
//		g.drawString("ROCK", getX() + 5, getY() + 15);
	}


	@Override
	public void destroy() {
		setX(-1000);
		setY(-1000);
	}
}



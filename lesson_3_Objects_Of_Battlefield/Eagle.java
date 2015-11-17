package lesson_3_Objects_Of_Battlefield;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Eagle extends AbstractObjectOfField{
	
	private Image image;

	public Eagle(int x, int y){
		super(x, y);
		initImage();
	}


	private void initImage() {
		try {
			image = ImageIO.read(this.getClass().getResource("Shield.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}		
	}


	@Override
	public void draw(Graphics g) {		
		g.drawImage(image, getX(), getY(), null);
	}


	@Override
	public void destroy() {
		setX(-1000);
		setY(-1000);
	}
}


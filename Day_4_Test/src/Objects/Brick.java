package Objects;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

import Logic.Destroyable;
import Logic.Targetable;

public class Brick extends AbstractObjectOfField implements Destroyable, Targetable{
	
	private Image image;

	public Brick(int x, int y){
		super(x, y);
		initImage();
	}


	private void initImage() {
		try {
			image = ImageIO.read(this.getClass().getResource("brick.jpg"));
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
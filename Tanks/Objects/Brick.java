package Objects;

import java.awt.*;
import java.io.IOException;
import javax.imageio.ImageIO;

public class Brick extends AbstractObjectOfField {
	
	private Image image;

	public Brick(int x, int y){
		super(x, y);
		initImage();
	}


	private void initImage() {
		try {
			image = ImageIO.read(this.getClass().getResource("Brick.png"));
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
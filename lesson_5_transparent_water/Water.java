package Objects;

import java.awt.*;
import java.io.IOException;

import javax.imageio.ImageIO;


public class Water extends AbstractObjectOfField{
		
	
	private Image image;
	
	
		public Water(int x, int y){
			super(x, y);
			initImage();
		}


		private void initImage() {
			try {
				image = ImageIO.read(this.getClass().getResource("water.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}			
		}


		@Override
		public void draw(Graphics g) {
			Graphics2D g2d = (Graphics2D)g;
			Composite nonTransparent = g2d.getComposite();
			Composite transparent = AlphaComposite.SrcOver.derive(0.5f);
			g2d.setComposite(transparent);			
			g2d.drawImage(image, getX(), getY(), null);
			g2d.setComposite(nonTransparent);		
		}

		@Override
		public void destroy() {
			setX(-1000);
			setY(-1000);
		}
	}
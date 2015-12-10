package lesson_5_text_on_panel;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Frame extends JPanel {

	static Frame f;
	static int x = 0;
	static int y = 255;

	public Frame() throws InterruptedException {

		JFrame frame = new JFrame("Hello");
		frame.setLocation(50, 50);
		frame.setMinimumSize(new Dimension(640, 480));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		frame.getContentPane().add(this);

		frame.pack();
		frame.setVisible(true);
	}

	public void rainbow() throws InterruptedException {
		while (x <= 255) {
			if (x == 255) {
				x = 0;
			}
			if (y == 0) {
				y = 255;
			}
			x++;
			y--;
			Thread.sleep(20);
			repaint();
		}
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(new Color(y, y, y));
		g.fillRect(0, 0, 640, 480);

		g.setColor(new Color(x, y, 0));
		g.fillOval(x, y, x, x);

		g.setColor(new Color(y, x, y));
		g.fillOval(y, x, x, x);
		
		g.setColor(new Color(y, y, x));
		g.fillRect(x, x, x, x);
		
		g.setColor(new Color(y, x, x));
		g.fillRoundRect(y, y, y, x, x, y);
		
	    Graphics2D g2d = (Graphics2D) g;
	    AffineTransform at = new AffineTransform();
	    g2d.setFont(new Font(null, Font.BOLD, 55));
	    g2d.setColor(new Color(x, x, y));
	    at.rotate(0.5);
	    g2d.setTransform(at);
	    g2d.drawString("Hello", x, x);
	}

	public static void main(String[] args) throws InterruptedException {
		f = new Frame();
		f.rainbow();
	}

}

package lesson_3_New_Draw;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Stroke;

public class Circle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		
		Graphics2D g2 = (Graphics2D) g;		
		g2.setStroke(new BasicStroke(13));		
		g.setColor(Color.ORANGE);
		g.drawOval(35, 50, 100, 150);
		
	}
}


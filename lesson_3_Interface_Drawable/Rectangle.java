package lesson_3_Interface_Drawable;

import java.awt.Color;
import java.awt.Graphics;

public class Rectangle extends Shape {
	
	@Override
	public void draw(Graphics g) {
		g.setColor(Color.BLUE);
		g.fillRect(180, 70, 200, 250);
	}
}


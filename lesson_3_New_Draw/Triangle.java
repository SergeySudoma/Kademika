package lesson_3_New_Draw;

import java.awt.Color;
import java.awt.Graphics;

public class Triangle extends Shape{
	
	@Override
	public void draw(Graphics g) {
		int[] x = {430,570,500};
		int[] y = {125,125,250};
		g.setColor(Color.RED);
		g.fillPolygon(x, y, 3);
	}
}

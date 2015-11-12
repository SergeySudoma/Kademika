package lesson_3_New_Draw;

import java.awt.Color;
import java.awt.Graphics;

public class Shape {
	
	private Color color;

	public void draw(Graphics g) {
		String s = "no shape to draw for " + this.getClass().getSimpleName() + " object";
		char[] arrayChar = s.toCharArray();
		g.setColor(Color.DARK_GRAY);
		g.drawChars(arrayChar, 0, arrayChar.length, 355, 15);
		//g.dra
	}
	
}

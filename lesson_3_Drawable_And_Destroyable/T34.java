package lesson_3_Drawable_And_Destroyable;

import java.awt.Color;
import java.awt.Graphics;

public class T34 extends AbstractTank{

	public T34(BattleField bf, ActionField af, int x, int y, Direction direction) {
		super(bf, af, x, y, direction);
	}
	
	public T34(BattleField bf, ActionField af) {
		super(bf, af);
		
	}


	public void draw(Graphics g) {
		
		g.setColor(new Color(255, 0, 0));
		g.fillRect(this.getX(), this.getY(), 64, 64);
		g.setColor(new Color(0, 255, 0));
		if (this.getDirection() == Direction.UP) {
			g.fillRect(this.getX() + 20, this.getY(), 24, 34);
		} else if (this.getDirection() == Direction.DOWN) {
			g.fillRect(this.getX() + 20, this.getY() + 30, 24, 34);
		} else if (this.getDirection() == Direction.LEFT) {
			g.fillRect(this.getX(), this.getY() + 20, 34, 24);
		} else {
			g.fillRect(this.getX() + 30, this.getY() + 20, 34, 24);
		}
		
	}
	
	

}

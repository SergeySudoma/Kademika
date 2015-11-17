package lesson_3_Objects_Of_Battlefield;

import java.awt.Image;

public abstract class AbstractObjectOfField implements Drawable, Destroyable{

	private int x;
	private int y;
	protected Image image;
	protected Image image_up;
	protected Image image_down;
	protected Image image_left;
	protected Image image_right;
	
	public AbstractObjectOfField(){
		
	}
	
	public AbstractObjectOfField(int x, int y){
		this.x = x;
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}
}



package Objects;

import java.awt.Image;
import java.io.ObjectInputStream.GetField;

import javax.security.auth.Destroyable;

import Logic.Drawable;

public abstract class AbstractObjectOfField implements Drawable, Destroyable{

	protected int x;
	protected int y;
	protected Image image;
	protected Image image_up;
	protected Image image_down;
	protected Image image_left;
	protected Image image_right;
	protected boolean isDestroyed = false;
		
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
	
	public boolean getIsDestroyed() {
		return isDestroyed;
	}

	public void setDestroyed() {
		isDestroyed = true;
	}
	
	public void destroy(){
		setX (-1000);
		setY (-1000);
		setDestroyed();
	}
}



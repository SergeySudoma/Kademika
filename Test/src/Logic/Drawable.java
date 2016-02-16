package Logic;

import java.awt.*;
import java.util.ArrayList;

public interface Drawable {
	
	public static ArrayList<Drawable> drawableList = new ArrayList<Drawable>();
	public void draw(Graphics g);
	
}

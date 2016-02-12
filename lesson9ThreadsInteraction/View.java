package lesson9ThreadsInteraction;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JPanel;

public class View extends JPanel{

	private Shuttle shuttle;
	private Gates gates;	
	private ArrayList<Star> stars = new ArrayList<Star>();
	
	public View(Shuttle shuttle, Gates gates){
		this.setBackground(Color.BLACK);
		initStars();
		this.shuttle = shuttle;
		this.gates = gates;
	}

	private int randomCoordinates() {
		Random rnd = new Random();
		return rnd.nextInt(400);				
	}
	
	private void initStars(){
		
		for(int i = 0; i < 150; i++){
			stars.add(new Star());
		}
		
	}
	
	private class Star{
		private int x;
		private int y;
		
		public Star(){
			this.x = randomCoordinates();
			this.y = randomCoordinates();
		}
		
		public void draw(Graphics g){
			g.setColor(new Color(randomCoordinates() / 2, randomCoordinates() / 2,  randomCoordinates()/ 2));
			g.fillRect(x, y, 1, 1);
		}
		
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(Star item : stars){
			item.draw(g);
		}
		shuttle.draw(g);
		gates.draw(g);
		
	}
	
	
	public Shuttle getShuttle() {
		return shuttle;
	}

	public void setShuttle(Shuttle shuttle) {
		this.shuttle = shuttle;
	}

	public Gates getGates() {
		return gates;
	}

	public void setGates(Gates gates) {
		this.gates = gates;
	}
	
}

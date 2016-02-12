package lesson9ThreadsInteraction;

import java.awt.Color;
import java.awt.Graphics;

public class Gates {

	private GatePart gamePart1;
	private GatePart gamePart2;
	
	public Gates(){
		gamePart1 = new GatePart(370, 110);
		gamePart2 = new GatePart(370, 200);
	}
	
	
	public void draw(Graphics g){
		g.setColor(Color.RED);
		g.fillRect(gamePart1.getX(), gamePart1.getY(), 30, 90);
		g.fillRect(gamePart2.getX(), gamePart2.getY(), 30, 90);
	}
	
	class GatePart{
		private int x;
		private int y;
		
		public GatePart(int x, int y){
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
	
	
	public GatePart getGamePart1() {
		return gamePart1;
	}


	public void setGamePart1(GatePart gamePart1) {
		this.gamePart1 = gamePart1;
	}


	public GatePart getGamePart2() {
		return gamePart2;
	}


	public void setGamePart2(GatePart gamePart2) {
		this.gamePart2 = gamePart2;
	}

}

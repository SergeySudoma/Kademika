package day_4_Shot_The_Agressor;

public class Bullet {

	private  int x;
	private  int y;
	Direction direction;

	private int speed = 1;

	public Bullet(int x, int y, Direction direction) {
		this.x = x;
		this.y = y;
		this.direction = direction;

	}

	void updateX(int x) {
		this.x = this.x + x;
	}

	void updateY(int y) {
		this.y = this.y + y;
	}

	void destroy() {
		x = -1000;
		y = -1000;
	}
	
	public int getX(){
		return x;
	}
	
	public int getY(){
		return y;
	}
	
	public int getSpeed(){
		return speed;
	}
	

}

package Day_4_frame_7;

public class T34 extends Tank{

	public T34(String color, int crew, int speed) {
		super(color, crew, speed);
		
	}
	
	@Override
	public void printInfo(Tank tank) {
		System.out.print(T34.class.getSimpleName() + " info: ");
		super.printInfo(tank);
	}
	
	@Override
	public void move(Tank tank) {
		System.out.print(T34.class.getSimpleName());
		super.move(this);
	}

}

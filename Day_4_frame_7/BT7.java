package Day_4_frame_7;

public class BT7 extends Tank{

	public BT7(String color, int crew, int speed) {
		super(color, crew, speed);
		
	}
	
	@Override
	public void printInfo(Tank tank) {
		System.out.print(BT7.class.getSimpleName() + " info: ");
		super.printInfo(tank);
	}
	
	@Override
	public void move(Tank tank) {
		System.out.print(BT7.class.getSimpleName());
		super.move(this);
	}

}

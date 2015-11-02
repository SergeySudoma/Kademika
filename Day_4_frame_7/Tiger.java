package Day_4_frame_7;

public class Tiger extends Tank{

	public Tiger(String color, int crew, int speed) {
		super(color, crew, speed);
	}
	
	@Override
	public void printInfo(Tank tank) {
		System.out.print(Tiger.class.getSimpleName() + " info: ");
		super.printInfo(tank);
	}
	
	@Override
	public void move(Tank tank) {
		System.out.print(Tiger.class.getSimpleName());
		super.move(this);
	}

}

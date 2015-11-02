package Day_4_frame_7;

public class Tank {

	String color;
	int crew;
	int speed;

	public Tank(String color, int crew, int speed) {
		this.color = color;
		this.crew = crew;
		this.speed = speed;

	}

	public static void createTanks() {

		Tank[] tanks = new Tank[5];
		tanks[0] = new Tank("red", 2, 110);
		tanks[1] = new Tank("orange", 2, 120);
		tanks[2] = new Tank("yellow", 2, 130);
		tanks[3] = new Tank("green", 2, 140);
		tanks[4] = new Tank("blue", 2, 150);

		printTankInfo(tanks);

	}

	public static void printTankInfo(Tank[] tanks) {
		for (Tank tank : tanks) {
			System.out.println(tank.color + ", " + tank.crew + ", "
					+ tank.speed);

		}
	}
	
	public void printInfo(Tank tank){
		System.out.println("color - " + tank.color + ", " + "crew - " + tank.crew + ", "
				+ "maximum speed - " + tank.speed);
	}
	
	public void move(Tank tank){
		System.out.println(" is moving");
	}

}

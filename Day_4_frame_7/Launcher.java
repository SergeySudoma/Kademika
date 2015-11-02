package Day_4_frame_7;

public class Launcher {

	public static void main(String[] args) {
		
		BT7 tankBT7 = new BT7("red", 2, 50);
		T34 tankT34 = new T34("blue", 3, 60);
		Tiger tankTiger = new Tiger("yellow", 4, 70);

		tankBT7.printInfo(tankBT7);
		tankT34.printInfo(tankT34);
		tankTiger.printInfo(tankTiger);
		
		tankBT7.move(tankBT7);
		tankT34.move(tankT34);
		tankTiger.move(tankTiger);
	}

}

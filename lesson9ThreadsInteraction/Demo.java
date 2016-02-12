package lesson9ThreadsInteraction;

public class Demo {

	public static void main(String[] args) throws InterruptedException {
		
		Controller controller = new Controller();
		
		controller.shuttleGoHome();
		controller.initGates();
		
	}

}

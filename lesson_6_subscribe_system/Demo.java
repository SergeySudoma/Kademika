package lesson_6_subscribe_system;

public class Demo {

	public static void main(String[] args) {
		Newspaper np = new Newspaper();
		Magazine mz = new Magazine();
		
		Subscriber sb = new Subscriber();
		np.addObserver(sb);
		mz.addObserver(sb);
		
		for(int i = 0; i < 10; i++){
			np.printNewRelease();
			mz.printNewRelease();
			np.notifyObservers();
			mz.notifyObservers();
			
		}

	}

}

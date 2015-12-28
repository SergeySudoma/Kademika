package lesson_6_subscribe_system;

import java.util.Observable;

public class Newspaper extends Observable{

	public void printNewRelease(){
		this.setChanged();
	}
	
}


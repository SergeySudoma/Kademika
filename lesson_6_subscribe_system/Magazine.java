package lesson_6_subscribe_system;

import java.util.Observable;

public class Magazine extends Observable{
	
	public void printNewRelease(){
		super.setChanged();
	}


}

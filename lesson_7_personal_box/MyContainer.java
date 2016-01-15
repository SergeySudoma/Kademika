package lesson_7_personal_box;

import java.util.ArrayList;

public class MyContainer<T> {
	
	ArrayList<T> list = new ArrayList<T>();
	
	public MyContainer(){
		
	}
	
	public void addItem(T item){
		list.add(item);
	}
	
	public T getItem(int index){
		return list.get(index);
	}
	
	public void deleteItem(T item){
		list.remove(item);
		
	}
	

}

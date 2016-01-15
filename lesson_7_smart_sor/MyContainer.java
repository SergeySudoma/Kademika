package lesson_7_smart_sor;

import java.util.ArrayList;
import java.util.Comparator;

public class MyContainer<T extends AbstractTank> {
	
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
	
	public void printContent(){
		for(T t : list){
			System.out.println(t.getID());
		}
	}
	
	public void sortByID() {
		list.sort(new Comparator<T>() {
			public int compare(T o1, T o2) {
				return Integer.valueOf(o1.getID()).compareTo(Integer.valueOf(o2.getID()));
			}
		});
	}
	

}

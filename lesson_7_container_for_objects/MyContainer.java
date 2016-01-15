package lesson_7_container_for_objects;

public class MyContainer<T> {
	
	private T item;
	
	public MyContainer(){
		
	}
	
	public T getItem(){
		return item;
	}
	
	public void setItem(T item){
		this.item = item;
	}
	
	public void deleteItem(T item){
		if(this.item == item){
			this.item = null;
		}
	}
	

}

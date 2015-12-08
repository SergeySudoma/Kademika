package lesson_4_stack_lifo;

import java.util.LinkedList;

public class Stack {
	
	LinkedList<Object> list = new LinkedList<Object>();
	
	public void push(Object obj){
		list.addLast(obj);
	}
	
	public Object pop(){
		Object obj = list.getLast();
		list.removeLast();
		return obj;
	}
	
	public Object peak(){
		return list.getLast();
	}

}

package lesson_4_Array_Based_List;

import lesson_4_Array_Based_List.SimpleArrayList;

public class Demo {

	public static void main(String[] args) {
		
		SimpleArrayList list = new SimpleArrayList();
		
		//sample values
		Integer a = new Integer(5);
		Integer b = new Integer(6);
		Integer c = new Integer(7);
		
		
		//add to list test
		list.add(a);
		list.add(b);
		list.add(c);		
		System.out.println(list.size());
		
		//getting object by index test		
		System.out.println(list.getByIndex(0));
		//System.out.println(list.getByIndex(5));
		
		//remove from list test
		list.remove(b);		
		System.out.println(list.size());
		
		//contatins test
		Integer d = new Integer(8);
		System.out.println(list.contains(c));
		System.out.println(list.contains(d));

	}

}

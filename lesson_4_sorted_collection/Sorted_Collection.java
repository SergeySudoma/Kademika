package lesson_4_sorted_collection;

import java.util.ArrayList;
import java.util.Collections;


public class Sorted_Collection{
	
	public static void main(String[] args){

	String string1 = "aaa";
	String string2 = "bbb";
	String string3 = "ccc";
	String string4 = "eee";
	String string5 = "ddd";
	String string6 = "eee";
	String string7 = "fff";
	String string8 = "ggg";
	String string9 = "hhh";
	String string10 = "jjj";		
		
	ArrayList<String> list = new ArrayList<String>();
	
	list.add(string1);
	list.add(string2);
	list.add(string3);
	list.add(string4);
	list.add(string5);
	list.add(string6);
	list.add(string7);
	list.add(string8);
	list.add(string9);
	list.add(string10);
	

	Collections.sort(list, new StringComparator());

	for(String str : list){
		System.out.println(str);
	}
	
}	

}

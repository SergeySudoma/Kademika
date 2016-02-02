package lesson8FileBasedList;

import java.io.IOException;

public class Demo {

	public static void main(String[] args) throws ClassNotFoundException, IOException {
		
		FileBasedList fileBasedList = new FileBasedList("fileBasedListTest.fbl");
		
		fileBasedList.add(new String("hello"));
		fileBasedList.add(new String("this"));
		fileBasedList.add(new String("is"));
		fileBasedList.add(new String("test"));
		
		for(Object obj : fileBasedList){
			System.out.println(obj);
		}
		
		String s = "hello";		
		fileBasedList.remove(s);
		
		System.out.println(fileBasedList.size());
		
		for(Object obj : fileBasedList){
			System.out.println(obj);
		}
		

	}
}

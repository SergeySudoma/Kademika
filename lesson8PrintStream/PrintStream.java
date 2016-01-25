package lesson8PrintStream;

import java.io.ByteArrayInputStream;

public class PrintStream {

	public static void main(String[] args) {
		
		byte[] byteArray = {10,20,30,40,50,60,1,2,3,4,5,6,7,8};
		ByteArrayInputStream inputStream = new ByteArrayInputStream(byteArray);
		
		printStreamData(inputStream);

	}
	
	public static void printStreamData(ByteArrayInputStream inputStream){
		while(inputStream.available() > 0){
			System.out.print(inputStream.read() + "*");			
		}
	}

}

package lesson8PrintTextFile;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;

public class printTextFile {

	public static void main(String[] args) throws IOException {
		
		printStreamData(getInputStream(getCurrentDate()));
		
	}
	
	public static InputStream getInputStream(byte[] byteArray){
		return new ByteArrayInputStream(byteArray);
	}
	
	public static byte[] getCurrentDate(){
		String currentTimeString = String.valueOf(new Date().getTime());
		byte[] currentTimeByteArray = currentTimeString.getBytes();
		return currentTimeByteArray;
	}
	
	public static void printStreamData(InputStream inputStream) throws IOException{
		File fileName = new File("Launcher.java");
		FileWriter fileWriter = new FileWriter(fileName);
		
		while(inputStream.available() > 0){
			fileWriter.write(inputStream.read());
		}
		
		fileWriter.close();
		
	}
}

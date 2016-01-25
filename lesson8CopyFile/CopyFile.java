package lesson8CopyFile;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;

public class CopyFile {

	public static void main(String[] args) throws IOException {
		
		String fileName = "Launcher.java";
		File file = new File(fileName);
		
		copyFile(file);

	}
	
	public static void copyFile(File f) throws IOException{
		FileReader fileReader = new FileReader(f);
		String copiedFileName = f.getName().substring(0, f.getName().indexOf(".")) + "copy";
		FileWriter fileWriter = new FileWriter(copiedFileName);
		char c = 0;
		
		while(c != (char)-1){
			c = (char) fileReader.read();
			fileWriter.write(c);		
		}
		
		fileReader.close();
		fileWriter.close();
			

	}

}

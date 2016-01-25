package lesson8UseBuffer;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
		BufferedReader bufferedReader = new BufferedReader(fileReader, 256);
		
		String copiedFileName = f.getName().substring(0, f.getName().indexOf(".")) + "copy";
		
		FileWriter fileWriter = new FileWriter(copiedFileName);
		BufferedWriter bufferedWriter = new BufferedWriter(fileWriter, 256); 
		
		String c = null;
		
		while((c = bufferedReader.readLine()) != null){
		    bufferedWriter.write(c);
		    bufferedWriter.newLine();
		}
		
		bufferedReader.close();
		bufferedWriter.close();
		fileReader.close();
		fileWriter.close();
	}
}

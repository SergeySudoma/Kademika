package lesson8ChangeEncoding;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class ChangeEncoding {

	public static void main(String[] args) throws IOException {
		File file = new File("Launcher.java");
		
		changeEncoding(file, "US-ASCII", "GB18030");
	}
	
	public static void changeEncoding(File file, String currentEncoding, String neededEncoding) throws IOException{
		File out = new File("Launcher1.java");
		BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream(file), currentEncoding));
		BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(out), neededEncoding));
		
		int ch = 0; 
		while (ch >= 0){
			ch = reader.read();
			writer.write((char)ch);
		}
		
		reader.close();
		writer.close();
	}
}

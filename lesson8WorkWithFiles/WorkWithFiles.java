package lesson8WorkWithFiles;

import java.io.File;
import java.io.IOException;

public class WorkWithFiles {

	public static void main(String[] args) throws IOException {
		
		createFolder();
		printDirTree();

		

	}
	
	private static void printDirTree() {
		System.out.println(System.getProperty("user.dir"));
		
	}

	private static void createFolder() throws IOException{
		File folder = new File("D://Test.io");
		folder.mkdir();
		File.createTempFile("testFile", "txt", folder);
	}

}

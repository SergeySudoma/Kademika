package lesson8RedirectSysoutPrint;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;


public class RedirectSysoutPrint {

	public static void main(String[] args) throws FileNotFoundException {
		
		System.setOut(new PrintStream(new File("test.txt")));
		System.out.println("This message should appear in \"test.txt\"");
	}
}
	

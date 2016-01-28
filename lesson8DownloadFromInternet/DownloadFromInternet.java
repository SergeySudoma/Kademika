package lesson8DownloadFromInternet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class DownloadFromInternet {

	public static void main(String[] args) throws IOException {

		URL url = new URL("http://manuli-agri.com.ua");
		URLConnection connection = url.openConnection();

		BufferedReader inputStream = new BufferedReader(new InputStreamReader(connection.getInputStream()));
		BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(new File(url.getAuthority() + ".txt")));
		
		String line;
		
		while((line = inputStream.readLine()) != null){
			bufferedWriter.write(line);
		}

		bufferedWriter.close();
		inputStream.close();
}
}

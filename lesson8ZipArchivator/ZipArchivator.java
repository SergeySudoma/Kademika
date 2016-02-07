package lesson8ZipArchivator;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Scanner;
import java.util.zip.ZipEntry;
import java.util.zip.ZipException;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

import lesson8CopyFile.CopyFile;

public class ZipArchivator {
	
	private static FileInputStream fileInputStream;

	public static void main(String[] args) throws IOException {

		zipOrUnzipSelection();
	}
	
	

	public static void zipOrUnzipSelection() throws IOException {
		System.out.println("Input <zip> to zip or <unzip> to unzip: ");

		Scanner scan = new Scanner(System.in);
		String selection = scan.nextLine();

		if (selection.equals("zip")) {
			zip();
		} else if (selection.equals("unzip")) {
			unZip();
		} else {
			System.out.println("invalid comand");
		}
		scan.close();
	}
	
	private static void zipFolder(ZipOutputStream zipOutputStream, File file) throws IOException{
		
		if(file.getParent() == null){
			ZipEntry rootFolder = new ZipEntry(file.getName() + "/");
			zipOutputStream.putNextEntry(rootFolder);
		}
		else if(file.getParent() != null){
			ZipEntry rootFolder = new ZipEntry(file.getParent() + "/" + file.getName() + "/");
			zipOutputStream.putNextEntry(rootFolder);
		}
		
		String[] fileStructure = file.list();
		for(String item : fileStructure){
			File sub = new File(file, item);
			if(sub.isDirectory()){
				zipFolder(zipOutputStream, sub);
			}
			else{
				zipFile(zipOutputStream, sub);
			}
		}
	}
	
	private static void zipFile(ZipOutputStream zipOutputStream, File file) throws IOException{
			
		fileInputStream = new FileInputStream(file);
		ZipEntry entry = new ZipEntry(file.getParent() + "/" + file.getName());
		zipOutputStream.putNextEntry(entry);
		char data = 0;

		while (fileInputStream.available() > 0) {
			data = (char) fileInputStream.read();
			zipOutputStream.write(data);
		}
	}
	
	
	private static void zip() throws IOException{

		ArrayList<File> itemsToZipNames = new ArrayList<File>();
		String zipArchiveName;

		Scanner scan = new Scanner(System.in);

		System.out.println("Input filenames or directoty to zip: ");

		while (true) {
			String nextLine = scan.nextLine();
			if (nextLine.equals("")) {
				break;
			}
			itemsToZipNames.add(new File(nextLine));
		}

		System.out.println("Input zip-archive name in format <name.extension>: ");
		zipArchiveName = scan.nextLine();

		ZipOutputStream zipOutputStream = new ZipOutputStream(new FileOutputStream(new File(zipArchiveName)));
		
		for(File item : itemsToZipNames ){
			if(item.isDirectory()){
				zipFolder(zipOutputStream, item);
			}
			else if(item.isFile()){
				System.out.println("File " + item.getName() + " is zipped" );
				zipFile(zipOutputStream, item);
			}
		System.out.println("Zipped successfully");
		}
		
		zipOutputStream.close();
		fileInputStream.close();
		scan.close();
		
	}


	private static void unZip() throws ZipException, IOException {
		System.out.println("Input zip-file name in format <filename.zip> :");
		
		Scanner scan = new Scanner(System.in);
		String zippedFileName = scan.nextLine();
		scan.close();
		
		ZipFile zipFile = new ZipFile(new File(zippedFileName));
		Enumeration<? extends ZipEntry> entries = zipFile.entries();
		
		while(entries.hasMoreElements()){
			ZipEntry entry = entries.nextElement();
			if(entry.isDirectory()){
				System.out.println("Folder " + entry.getName() + " created" );
				File dir = new File(entry.getName());
				dir.mkdir();
			}
			else{
				System.out.println("File " + entry.getName() + " extracted" );
				File file = new File(entry.getName());
				file.getParentFile().mkdirs();
				InputStream in = zipFile.getInputStream(entry);
				FileOutputStream out = new FileOutputStream(new File(entry.getName()));
				char ch = 0;
				while(in.available() > 0){
					ch = (char) in.read();
					out.write(ch);
				}
				in.close();
				out.close();
			}
			
		}
		zipFile.close();
		
	}

}

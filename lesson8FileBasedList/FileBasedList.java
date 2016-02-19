package lesson8FileBasedList;

import java.io.BufferedInputStream;
import java.io.EOFException;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class FileBasedList implements Serializable, Iterable<Object> {

	private String fileName;
	private File destinationFile;
	private FileBasedListStorage fileBasedListStorage;

	public FileBasedList(String fileName) throws IOException {
		this.fileName = fileName;
		destinationFile = new File(fileName);
		destinationFile.createNewFile();
		fileBasedListStorage = new FileBasedListStorage(); 
	}
	
	public class FileBasedListStorage implements Serializable{
		/**
		 * 
		 */
		private static final long serialVersionUID = -7759224516052272466L;
		private ArrayList<Object> storageList = new ArrayList<Object>();
	}
	

	public void add(Object obj) throws IOException, ClassNotFoundException {
		loadFromFile();
		fileBasedListStorage.storageList.add(obj);
		saveToFile();
		fileBasedListStorage.storageList.clear();
	}

	private void saveToFile() throws IOException {
		ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream(destinationFile));
		if (fileBasedListStorage.storageList != null) {
			objectOutputStream.writeObject(fileBasedListStorage);
		}
		objectOutputStream.close();
		fileBasedListStorage.storageList.clear();
	}

	private void loadFromFile() throws ClassNotFoundException, IOException{
		try{
			ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream(destinationFile));
			fileBasedListStorage = (FileBasedListStorage) objectInputStream.readObject();
		}
		catch(EOFException e){
			return;
		}
	}
	

	public int size() throws FileNotFoundException, ClassNotFoundException,	IOException {
		loadFromFile();
		return fileBasedListStorage.storageList.size();
	}

	public void remove(Object obj) throws IOException, ClassNotFoundException {
		loadFromFile();
		fileBasedListStorage.storageList.remove(obj);		
		saveToFile();
		fileBasedListStorage.storageList.clear();
	}

	@Override
	public Iterator<Object> iterator() {
		return new Iterator<Object>() {

			int count = 0;

			@Override
			public Object next() {
				try {
					loadFromFile();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				return fileBasedListStorage.storageList.get(count++);
			}

			@Override
			public boolean hasNext() {
				ArrayList<Object> tempList = null;
				try {
					loadFromFile();
				} catch (ClassNotFoundException | IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				if (count < fileBasedListStorage.storageList.size() && fileBasedListStorage.storageList.size() > 0) {
					return true;
				} else {
					return false;
				}
			}
		};
	}

}

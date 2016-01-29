package Logic;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

public class GameplayRecord implements Serializable{

	private transient static final long serialVersionUID = 1L;
	private transient Tank tank;
	private transient Actions action; 
	private static ArrayList<GameplayRecord> list = new ArrayList<GameplayRecord>();
	private transient String gamePlayRecordFileName = "tanksGamePlay.tnk";
	
	public GameplayRecord(Tank tank, Actions action) throws FileNotFoundException, IOException, ClassNotFoundException{
		this.tank = tank;
		this.action = action;
		list.add(this);
		writeGamePlayToFile();
		System.out.println(list.size());
	}
	
	private void writeGamePlayToFile() throws FileNotFoundException, IOException{
		File gamePlayRecordFile = new File(gamePlayRecordFileName);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(gamePlayRecordFile));
		out.writeObject(this);
		out.close();
	}
	
	private void readGamePlayFile() throws FileNotFoundException, IOException, ClassNotFoundException{
		File gamePlayRecordFile = new File(gamePlayRecordFileName);
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(gamePlayRecordFile));
		GameplayRecord gamePlayBackRecord = (GameplayRecord) in.readObject(); 
		for(GameplayRecord item : gamePlayBackRecord.list){
			System.out.println(item.getAction() + " " + item.getTank());
		}
	}
	
	public Tank getTank() {
		return tank;
	}

	public void setTank(Tank tank) {
		this.tank = tank;
	}

	public Actions getAction() {
		return action;
	}

	public void setAction(Actions action) {
		this.action = action;
	}
}
	


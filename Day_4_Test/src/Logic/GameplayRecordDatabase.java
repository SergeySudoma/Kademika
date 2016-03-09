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
import java.util.concurrent.CopyOnWriteArrayList;

import Objects.AbstractTank;

public class GameplayRecordDatabase implements Serializable{
	
	private static final long serialVersionUID = 2652718269037451607L;
	private ArrayList<GameplayRecord> gameplayRecords = new ArrayList<GameplayRecord>();
	private String[][] battlefield;
	private final transient String GAMEPLAYRECORDFILENAME = "tanksGamePlay.tnk";
	private AbstractTank initialStateKiller;
	private AbstractTank initialStateDefender;
	private AbstractTank initialStateAgressor;
	
	public GameplayRecordDatabase(){
	}

	public void addGameplayRecord(GameplayRecord gameplayRecord){
		gameplayRecords.add(gameplayRecord);
	}
	
	public void writeGamePlayToFile() throws FileNotFoundException, IOException{
		File gamePlayRecordFile = new File(GAMEPLAYRECORDFILENAME);
		ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(gamePlayRecordFile));
		out.writeObject(this);
		out.close();
	}
	
	public GameplayRecordDatabase getGameplayFromFile() throws Exception{
		File gamePlayRecordFile = new File(GAMEPLAYRECORDFILENAME);
		ObjectInputStream in = new ObjectInputStream(new FileInputStream(gamePlayRecordFile));
		GameplayRecordDatabase gameplayRecordDatabase = (GameplayRecordDatabase) in.readObject();
		in.close();
		return gameplayRecordDatabase;
	}
	
	public ArrayList<GameplayRecord> getGameplayRecords(){
		return gameplayRecords;
	}

	public String[][] getBattlefield() {
		return battlefield;
	}
	
	public void setBattlefield(String[][] battlefield){
		this.battlefield = battlefield;		
	}
	
	public AbstractTank getInitialStateKiller() {
		return initialStateKiller;
	}

	public void setInitialStateKiller(AbstractTank initialStateKiller) {
		this.initialStateKiller = initialStateKiller;
	}

	public AbstractTank getInitialStateDefender() {
		return initialStateDefender;
	}

	public void setInitialStateDefender(AbstractTank initialStateDefender) {
		this.initialStateDefender = initialStateDefender;
	}

	public AbstractTank getInitialStateAgressor() {
		return initialStateAgressor;
	}

	public void setInitialStateAgressor(AbstractTank initialStateAgressor) {
		this.initialStateAgressor = initialStateAgressor;
	}
}


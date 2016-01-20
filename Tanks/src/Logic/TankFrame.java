package Logic;

import java.awt.Dimension;
import java.io.IOException;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class TankFrame extends JFrame implements PanelManager{
	
	private JPanel currentJPanel;
	
	public TankFrame() throws Exception{
		super("TANKS BATTLE");
		createFrame();
	}
	
	public void createFrame(){
		this.setLocation(450, 75);
		this.setMinimumSize(new Dimension(BattleField.bfWidth, BattleField.bfHeight + 25));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.setResizable(false);
		this.pack();
	}

	@Override
	public void addMainMenuPanel() {
		TankSelection ts = new TankSelection(this);
		
		if(currentJPanel != null){
			remove(currentJPanel);
		}
		
		currentJPanel = ts;
		this.add(ts);
		this.revalidate();
	}
	
	
	@Override
	public void addActionFieldAndRunGame(String selectedTank) throws Exception{
		ActionField af = new ActionField(this);
		this.remove(currentJPanel);
		currentJPanel = af;
		this.add(af);

		if(selectedTank.equals("t34")){
			af.addT34();
		}
		else if(selectedTank.equals("tiger")){
			af.addTiger();
		}
		
		Thread t1 = new Thread(new Runnable() {			
			@Override
			public void run() {
				try {
					af.runTheGame();
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}			
			}
		});
		
		this.revalidate();		
		t1.start();		
	}

	@Override
	public void addGameOverMenu(String gameResult) throws IOException {
		GameOverMenu gameOverMenu = new GameOverMenu(gameResult, this);
		this.remove(currentJPanel);
		currentJPanel = gameOverMenu;
		this.add(gameOverMenu);		
		this.revalidate();
		
	}
}

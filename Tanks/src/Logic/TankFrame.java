package Logic;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;


public class TankFrame extends JFrame implements PanelManager{
	
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
		this.add(ts);
		this.revalidate();
	}
	
	
	@Override
	public void addActionFieldAndRunGame(String selectedTank) throws Exception{
		ActionField af = new ActionField();
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
}

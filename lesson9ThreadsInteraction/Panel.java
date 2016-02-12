package lesson9ThreadsInteraction;

import javax.swing.JFrame;
import javax.swing.WindowConstants;


public class Panel extends JFrame{
	
	public Panel(){
		initPanel();
	}

	private void initPanel() {
		setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		setBounds(650, 150, 450, 450);
		setVisible(true);		
	}

}

package Test;

import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


public class Frame extends JFrame implements PanelManager{
	
	public Frame(){
		super("ggg");
		createFrame();
	}	
	
	public void createFrame(){
		this.setLocation(450, 75);
		this.setMinimumSize(new Dimension(500,500));
		this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		this.pack();
	}
	

	@Override
	public void removePanel(JPanel p) {
		this.remove(p);
		revalidate();
		repaint();
	}

	@Override
	public void addContent1() {		
		this.add(new Content(this));
		revalidate();
		repaint();
	}

	@Override
	public void addContent2() {
		this.add(new Content2(this));
		revalidate();
		repaint();		
	}
}

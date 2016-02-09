package lesson9FlyingBall;

import java.awt.Graphics;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

public class Panel extends JPanel{
	
	ArrayList<FlyingBall> ballList = new ArrayList<FlyingBall>();
	
	public Panel(){
		initPanel();
	}

	private void initPanel(){
		JFrame frame = new JFrame();
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.setBounds(650, 150, 300, 300);
		frame.add(this);
		frame.setVisible(true);
	}

	public ArrayList<FlyingBall> getBallList() {
		return ballList;
	}

	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
		for(FlyingBall item : ballList){
			try {
				Thread.sleep(item.getSpeed());
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			item.draw(g);
			repaint();
		}
	}

}

package Test;

import java.awt.Color;
import java.io.IOException;


import javax.swing.JFrame;
import javax.swing.JPanel;

import javax.swing.WindowConstants;

public class TestColorFrame extends JFrame{
	
	public TestColorFrame() throws IOException{	
	 setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	 setSize(400, 400);
	 setLocation(600, 200);
	}
	
	
	public class P1 extends JPanel{
		
		public P1(){
			this.setBackground(Color.BLUE);
		}

	}

	public class P2 extends JPanel{
		
		public P2(){
			this.setBackground(Color.RED);
		}
	}

	
	public static void main(String[] args) throws IOException, InterruptedException {
		
		TestColorFrame  tf = new TestColorFrame();
		
		P1 p1 = tf.new P1();
		P2 p2 = tf.new P2();
		
		tf.add(p1);
		tf.setVisible(true);
	
		tf.add(p2);
		tf.setVisible(true);
		
		p2.setVisible(false);
		tf.repaint();
		
	
	}

}

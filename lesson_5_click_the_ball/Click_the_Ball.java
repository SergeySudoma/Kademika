package lesson_5_click_the_ball;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

	public class Click_the_Ball extends JPanel implements MouseMotionListener {
		
		private static JFrame frame;
		private static int xBall = 150;
		private static int yBall = 150;
		private static int diam = 45;
		private static int frameX = 400;
		private static int frameY = 400;
		
		public Click_the_Ball(){
			addMouseMotionListener(this);
		}
		
		@Override
		public void paint(Graphics g) {
			super.paint(g);
			g.setColor(Color.RED);
			g.fillOval(xBall, yBall, diam, diam);
		}
		
		public static void main(String[] args){		
			frame = new JFrame();
			frame.setBounds(200, 200, frameX, frameY);
			frame.setMinimumSize(new Dimension(frameX, frameY));
			frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
			frame.add(new Click_the_Ball());
			frame.setVisible(true);

		}

		@Override
		public void mouseDragged(MouseEvent e) {
			
		}
		
		@Override
		public void mouseMoved(MouseEvent e) {
			
			int circleCenterX = xBall + diam / 2;
			int circleCenterY = yBall + diam / 2;
			
			ArrayList<Integer> byX = new ArrayList<Integer>();
			ArrayList<Integer> byY = new ArrayList<Integer>();
			
			for(int i = circleCenterX; i <= circleCenterX + 50; i++ ){
				byX.add(i);
			}
			
			for(int i = circleCenterX - 50; i < circleCenterX; i++ ){
				byX.add(i);
			}
			
			for(int i = circleCenterY; i <= circleCenterY + 50; i++ ){
				byY.add(i);
			}
			
			for(int i = circleCenterY - 50; i < circleCenterY; i++ ){
				byY.add(i);
			}
			
			if(byX.contains(e.getX()) && (byY.contains(e.getY()))){
				
				if(e.getX() < circleCenterX && e.getY() < circleCenterY ){
					xBall += 10;
					yBall += 10;
				}
				
				if(e.getX() > circleCenterX && e.getY() < circleCenterY ){
					xBall -= 10;
					yBall += 10;
				}
				
				if(e.getX() < circleCenterX && e.getY() > circleCenterY ){
					xBall += 10;
					yBall -= 10;
				}
				
				if(e.getX() > circleCenterX && e.getY() > circleCenterY ){
					xBall -= 10;
					yBall -= 10;
				}
				
				if(circleCenterX <= 0 || circleCenterX >= 400){
					xBall = 200;
				}
				
				if(circleCenterY <= 0 || circleCenterY >= 400){
					yBall = 200;
				}
				
				}
			repaint();
		}
	}
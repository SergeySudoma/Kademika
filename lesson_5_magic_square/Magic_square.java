package lesson_5_magic_square;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import lesson_3_Add_Square.Square;


public class Magic_square extends JPanel implements MouseListener{
	static Magic_square mq;
	Color squareColor1;
	Color squareColor2;
	Color squareColor3;
	Color background;
	Color[] color = {Color.RED, Color.BLUE, Color.ORANGE, Color.GREEN, Color.BLACK, Color.CYAN, Color.DARK_GRAY,
			Color.MAGENTA, Color.PINK, Color.WHITE, Color.YELLOW};
	
	public Magic_square(){
		addMouseListener(this);
	}
	
	private void initColor() {
		Random rnd = new Random();
		squareColor1 = color[rnd.nextInt(color.length - 1 )];
		squareColor2 = color[rnd.nextInt(color.length - 1 )];
		squareColor3 = color[rnd.nextInt(color.length - 1 )];
		mq.setBackground(color[rnd.nextInt(color.length - 1 )]);
		repaint();
	}

	@Override
	public void paint(Graphics g) {
		super.paint(g);
		g.setColor(squareColor1);
		g.fillRect(20, 20, 100, 100);
		
		g.setColor(squareColor2);
		g.fillRect(230, 20, 100, 100);
		
		g.setColor(squareColor3);
		g.fillRect(120, 150, 100, 100);
		
		
	}	
	
	public static void main(String[] args){		
		JFrame frame = new JFrame();
		frame.setBounds(200, 200, 400, 400);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		mq = new Magic_square();
		frame.add(mq);
		frame.setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		initColor();	
	}

	@Override
	public void mousePressed(MouseEvent e) {
	}

	@Override
	public void mouseReleased(MouseEvent e) {
	}

	@Override
	public void mouseEntered(MouseEvent e) {
	}

	@Override
	public void mouseExited(MouseEvent e) {
	}
}

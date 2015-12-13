package lesson_5_gui_for_shop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;


public class UI{
	
	private Shop shop;
	private JFrame frame;
	private JPanel panel;
	
	public UI(Shop shop) {
		this.shop = shop;
		initFrame();
		addComponents();
	
	}

	private void addComponents() {
		
		JLabel nameLabel = new JLabel("Enter your name: ");
		panel.add(nameLabel);
		
		JTextField nameField = new JTextField();
		panel.add(nameField);
		
		JRadioButton carAudi = new JRadioButton("AUDI");
		JRadioButton carBMW = new JRadioButton("BMW");
		JRadioButton carOpel = new JRadioButton("OPEL");
		JRadioButton carSubaru = new JRadioButton("SUBARU");
		JRadioButton carDodge = new JRadioButton("DODGE");
		
		ButtonGroup group = new ButtonGroup();
		group.add(carAudi);
		group.add(carBMW);
		group.add(carOpel);
		group.add(carSubaru);
		group.add(carDodge);
		
		panel.add(carAudi);
		panel.add(carBMW);
		panel.add(carOpel);
		panel.add(carSubaru);
		panel.add(carDodge);
		
		JTextField quantityField = new JTextField();
		panel.add(quantityField);
				
		JButton buttonBuy = new JButton("BUY");
		panel.add(buttonBuy);
		
	}

	private void initFrame() {
		frame = new JFrame(" \"Hot Wheels\" car shop");
		panel = new JPanel();
		frame.setMinimumSize(new Dimension(800, 600));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		frame.setVisible(true);
	}

}
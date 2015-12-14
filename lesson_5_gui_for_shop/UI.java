package lesson_5_gui_for_shop;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.text.Format;
import java.text.NumberFormat;
import java.text.ParseException;

import javax.print.attribute.standard.JobName;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.text.MaskFormatter;


public class UI{
	
	private Shop shop;
	private JFrame frame;
	private JPanel panel;
	
	public UI(Shop shop) throws ParseException {
		this.shop = shop;
		initFrame();
		addComponents();
	
	}

	private void addComponents() throws ParseException {
		
		JLabel nameLabel = new JLabel("Enter your name: ");
		panel.add(nameLabel);
		
		JTextField nameField = new JTextField();
		panel.add(nameField);
		
		ButtonGroup group = new ButtonGroup();
		
		for(Car car : shop.getCars()){
			JRadioButton button = new JRadioButton(car.getModel().toString());
			panel.add(button);
			group.add(button);
		}
		
		JFormattedTextField quantityField = new JFormattedTextField(new MaskFormatter("##"));
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
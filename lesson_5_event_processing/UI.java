package lesson_5_event_processing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
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


public class UI {
	
	private Shop shop;
	private JFrame frame;
	private JPanel panel;
	ButtonGroup group;

	
	public UI(Shop shop, Database database) throws ParseException, IOException {
		this.shop = shop;		
		initFrame();
		addComponents();
		frame.setVisible(true);	
	}
	
	
	private class Background extends JPanel{

		@Override
		public void paint(Graphics g) {
			super.paint(g);
			Image image = null;
			try {
				image = ImageIO.read(new File("background.jpg"));
			} catch (IOException e) {
				e.printStackTrace();
			}
			g.drawImage(image, 0, 0, null);
		}
	}


	private void addComponents() throws ParseException, IOException {
		
		frame.add(new Background());
		
		GridBagConstraints gdc = new GridBagConstraints();
		
		JLabel nameLabel = new JLabel("Enter your name: ");
		nameLabel.setForeground(Color.white);
		gdc.anchor = GridBagConstraints.CENTER;
		gdc.gridx = 0;
		gdc.gridy = 0;
		panel.add(nameLabel, gdc);
				
		JTextField nameField = new JTextField(15);
		gdc.gridx = 1;
		gdc.gridy = 0;
		panel.add(nameField, gdc);
		
		JLabel carSelectionLabel = new JLabel("Select car: ");
		carSelectionLabel.setForeground(Color.white);
		gdc.anchor = GridBagConstraints.WEST;
		gdc.fill = GridBagConstraints.VERTICAL;
		gdc.gridx = 0;
		gdc.gridy = 3;
		panel.add(carSelectionLabel, gdc);
		
		

		group = new ButtonGroup();
		gdc.anchor = GridBagConstraints.CENTER;
		gdc.fill = GridBagConstraints.BOTH;
		gdc.gridx = 1;
		gdc.gridy = 0;
		for(Model model : Model.values()){
			JRadioButton carSelectionRadioButton = new JRadioButton(model + "  $" + shop.getSalesPrice(model));
			++gdc.gridy;
			carSelectionRadioButton.setForeground(Color.white);
			panel.add(carSelectionRadioButton, gdc);
			group.add(carSelectionRadioButton);
			carSelectionRadioButton.setOpaque(false);
			carSelectionRadioButton.setActionCommand(carSelectionRadioButton.getText());
		}

		
		
		JLabel quantityLabel = new JLabel("Required quantity: ");
		quantityLabel.setForeground(Color.white);
		gdc.gridx = 0;
		gdc.gridy = 9;
		panel.add(quantityLabel, gdc);
		
		
		JFormattedTextField quantityField = new JFormattedTextField(new MaskFormatter("#"));
		gdc.anchor = GridBagConstraints.LINE_START;
		gdc.gridx = 1;
		gdc.gridy = 9;
		gdc.fill = GridBagConstraints.HORIZONTAL;
		quantityField.setActionCommand(quantityField.getText());
		panel.add(quantityField, gdc);
		
		JButton buttonBuy = new JButton("BUY");
		gdc.fill = GridBagConstraints.LINE_START;
		gdc.gridy = 10;		
		panel.add(buttonBuy, gdc);
		buttonBuy.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				Customer customer = new Customer(nameField.getText());
				Car car = new Car();
				getSelectedButton();
				car.setModel(getSelectedButton());
				shop.sellCar(car, customer, Integer.parseInt(quantityField.getText()));				
			}
		});	

	}
	
	private String getSelectedButton()
	{  
	    for (Enumeration<AbstractButton> buttons = group.getElements(); buttons.hasMoreElements();) {
	            AbstractButton button = buttons.nextElement();
	            if (button.isSelected()) {	            	
	                return button.getActionCommand();
	            }
	    }
		return null;
	}

	private void initFrame() {
		frame = new JFrame(" \"Hot Wheels\" car shop");
		panel = new JPanel();
		GridBagLayout layout = new GridBagLayout();
		panel.setLayout(layout);
		frame.setMinimumSize(new Dimension(810, 630));
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		frame.add(panel);
		frame.pack();
		panel.setOpaque(false);
	}

}
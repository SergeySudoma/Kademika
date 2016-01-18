package lesson_7_discounts_shop;

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
import java.util.ArrayList;
import java.util.Enumeration;

import javax.imageio.ImageIO;
import javax.swing.AbstractButton;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.WindowConstants;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;
import javax.swing.text.MaskFormatter;


public class UI {
	
	private Shop shop;
	private JFrame frame;
	private JPanel panel;
	private ButtonGroup group;

	
	public UI(Shop shop, Database database) throws ParseException, IOException{
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


	private void addComponents() throws ParseException {
		
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
				try {
					shop.sellCar(car, customer, Integer.parseInt(quantityField.getText()));
				} catch (NumberFormatException e1) {
					System.out.println("Quantity field can't be blank");
				} catch (ParseException e1) {
					System.out.println("Enter required quantity!");
				}				
			}
		});	
	
		
		JMenuBar menubar = new JMenuBar();
		frame.setJMenuBar(menubar);
		
		JMenu reportsMenu = new JMenu("Reports");
		menubar.add(reportsMenu);
		
		JMenuItem todayTransationReport = new JMenuItem("Today transactions");
		reportsMenu.add(todayTransationReport);
		
		todayTransationReport.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					shop.printTodayTransactions();
					createTodayTransactionReportPanel();
				} catch (ParseException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}				
			}
		});
}
	
	
	public class myTableModel implements TableModel{ 
		
		private ArrayList<Deal> deals;
		
		public myTableModel(ArrayList<Deal> deals) {
			this.deals = deals;
		}
		
		@Override
		public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public void removeTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
		
		@Override
		public boolean isCellEditable(int rowIndex, int columnIndex) {
			return false;
		}
		
		@Override
		public Object getValueAt(int rowIndex, int columnIndex) {
			Deal deal = deals.get(rowIndex);
			switch(columnIndex){
			case 0:
				return rowIndex + 1;
			case 1:
				return deal.getCustomer().getName();
			case 2:
				return deal.getCar().getModel();
			case 3:
				return deal.getPrice();
			case 4:
				return deal.getQuantity();
			case 5:
				try {
					return shop.parseStringDate(deal.getDate());
				} catch (ParseException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}			
			return null;
		}
		
		@Override
		public int getRowCount() {
			return deals.size();
		}
		
		@Override
		public String getColumnName(int columnIndex) {
		    switch (columnIndex) {
	        case 0:
	            return "No.";
	        case 1:
	            return "Customer";
	        case 2:
	            return "Car";
	        case 3:
	            return "Price, USD";
	        case 4:
	            return "Quantity, pcs";
		    case 5:
		    	return "Date";
		    }
	    return "";
		}
		
		@Override
		public int getColumnCount() {
			return 6;
		}
		
		@Override
		public Class<?> getColumnClass(int columnIndex) {
			return String.class;
		}
		
		@Override
		public void addTableModelListener(TableModelListener l) {
			// TODO Auto-generated method stub
			
		}
	};
	

	
	private void createTodayTransactionReportPanel(){
		
		TableModel model = new myTableModel(shop.getSalesList());
		JTable table = new JTable(model);

		JFrame reportFrame = new JFrame("Transactions report");		
		reportFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
		reportFrame.setBounds(300, 300, 600, 300);
		reportFrame.add(new JScrollPane(table));
		reportFrame.setVisible(true);		
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
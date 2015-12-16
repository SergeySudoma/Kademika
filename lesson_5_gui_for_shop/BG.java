package lesson_5_gui_for_shop;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;

public class BG {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BG window = new BG();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BG() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(177, 116, 89, 23);
		//frame.getContentPane().add(btnNewButton);
		frame.add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon("D:\\Java\\workspace\\Kademika\\background.jpg"));
		label.setBounds(10, 11, 800, 600);
		//frame.getContentPane().add(label);
		frame.add(label);
	}
}

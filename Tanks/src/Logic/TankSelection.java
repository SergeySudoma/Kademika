package Logic;

import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;

import Objects.AbstractTank;

public class TankSelection extends JPanel {

	private PanelManager panelManager;
	private String selectedTank = null;

	public TankSelection(PanelManager panelManager) {
		this.panelManager = panelManager;
		createComponents();
	}

	private void createComponents() {

		this.setLayout(new GridBagLayout());

		GridBagConstraints c = new GridBagConstraints();

		ImageIcon bt7_icon = new ImageIcon(this.getClass().getResource(
				"green_tank_left.png"));
		ImageIcon bt7_icon_selected = new ImageIcon(this.getClass()
				.getResource("green_tank_left_selected.png"));
		JButton bt7_Button = new JButton(bt7_icon);
		c.anchor = GridBagConstraints.EAST;
		c.weightx = 0.1;
		c.insets = new Insets(150, 300, 0, 0);
		this.add(bt7_Button, c);

		ImageIcon tiger_icon = new ImageIcon(this.getClass().getResource(
				"red_tank_right.png"));
		ImageIcon tiger_icon_selected = new ImageIcon(this.getClass()
				.getResource("red_tank_right_selected.png"));
		JButton tiger_Button = new JButton(tiger_icon);
		c.insets = new Insets(150, 17, 0, 10);
		this.add(tiger_Button, c);

		ImageIcon start_icon_unpressed = new ImageIcon(this.getClass().getResource(
				"start_1.png"));
		JButton start_Button = new JButton(start_icon_unpressed);
		this.add(start_Button, c);

		bt7_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				bt7_Button.setIcon(bt7_icon_selected);
				tiger_Button.setIcon(tiger_icon);
				selectedTank = "t34";
			}
		});

		tiger_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				tiger_Button.setIcon(tiger_icon_selected);
				bt7_Button.setIcon(bt7_icon);
				selectedTank = "tiger";
			}
		});

		start_Button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (selectedTank != null) {

					try {
						panelManager.addActionFieldAndRunGame(selectedTank);
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			}
		});

	}

	@Override
	public void paintComponent(Graphics g) {
		Image image = null;
		try {
			image = ImageIO.read(this.getClass().getResource(
					"background_menu_1.png"));
		} catch (IOException e) {
			e.printStackTrace();
		}
		g.drawImage(image, 0, 0, null);
	}
}

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
import net.miginfocom.swing.MigLayout;

import javax.swing.SpringLayout;
import javax.swing.Icon;

public class TankSelection extends JPanel {

	private PanelManager panelManager;
	private String selectedTank = null;

	public TankSelection(PanelManager panelManager) {
		this.panelManager = panelManager;
		createComponents();
	}

	private void createComponents() {

		ImageIcon bt7_icon = new ImageIcon(this.getClass().getResource(
				"green_tank_left.png"));
		ImageIcon bt7_icon_selected = new ImageIcon(this.getClass()
				.getResource("green_tank_left_selected.png"));
		SpringLayout springLayout = new SpringLayout();
		setLayout(springLayout);
		JButton bt7_Button = new JButton(bt7_icon);
		springLayout.putConstraint(SpringLayout.WEST, bt7_Button, 329, SpringLayout.WEST, this);
		this.add(bt7_Button);

		ImageIcon tiger_icon = new ImageIcon(this.getClass().getResource("red_tank_right.png"));
		ImageIcon tiger_icon_selected = new ImageIcon(this.getClass().getResource("red_tank_right_selected.png"));
		JButton tiger_Button = new JButton(tiger_icon);
		springLayout.putConstraint(SpringLayout.SOUTH, tiger_Button, -173, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.SOUTH, bt7_Button, 0, SpringLayout.SOUTH, tiger_Button);
		springLayout.putConstraint(SpringLayout.EAST, bt7_Button, -6, SpringLayout.WEST, tiger_Button);
		this.add(tiger_Button);

		ImageIcon start_icon_unpressed = new ImageIcon(this.getClass().getResource("start_1.png"));
		JButton start_Button = new JButton(start_icon_unpressed);
		springLayout.putConstraint(SpringLayout.WEST, tiger_Button, -82, SpringLayout.WEST, start_Button);
		springLayout.putConstraint(SpringLayout.EAST, tiger_Button, -6, SpringLayout.WEST, start_Button);
		springLayout.putConstraint(SpringLayout.WEST, start_Button, -78, SpringLayout.EAST, this);
		springLayout.putConstraint(SpringLayout.SOUTH, start_Button, -171, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, start_Button, -10, SpringLayout.EAST, this);
		this.add(start_Button);
		
		ImageIcon replay_icon = new ImageIcon(this.getClass().getResource("replay.png"));
		JButton replay_button = new JButton(replay_icon);
		springLayout.putConstraint(SpringLayout.NORTH, replay_button, 98, SpringLayout.SOUTH, start_Button);
		springLayout.putConstraint(SpringLayout.WEST, replay_button, 0, SpringLayout.WEST, start_Button);
		springLayout.putConstraint(SpringLayout.SOUTH, replay_button, -10, SpringLayout.SOUTH, this);
		springLayout.putConstraint(SpringLayout.EAST, replay_button, 0, SpringLayout.EAST, start_Button);
		this.add(replay_button);
		
				replay_button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent e) {
						try {
							panelManager.addActionFieldAndPlayLastGamePlay();
						} catch (Exception e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}						
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
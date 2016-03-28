package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Content2 extends JPanel {

	PanelManager panelManager;
	
	public Content2(PanelManager panelManager) {
		this.panelManager = panelManager;
		addContent();
	}

	public void addContent(){
		JButton but = new JButton("button-button");
		add(but);
		Content2 c2 = this;
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button-button");
				panelManager.removePanel(c2);
				panelManager.addContent1();
			}
		});
	}
}

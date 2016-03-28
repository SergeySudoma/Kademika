package Test;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class Content extends JPanel {

	PanelManager panelManager;
	
	public Content(PanelManager panelManager) {
		this.panelManager = panelManager;
		addContent();
	}

	public void addContent(){
		JButton but = new JButton("button");
		add(but);
		Content c1 = this;
		but.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				System.out.println("button");
				panelManager.removePanel(c1);
				panelManager.addContent2();
			}
		});
	}
}

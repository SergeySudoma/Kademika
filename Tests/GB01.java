package Test;
import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class GB01 extends Applet implements ActionListener {


	   GridBagLayout gbl = new GridBagLayout();
	   Color[] colors = {Color.yellow, Color.pink, Color.green, Color.red,
	               Color.magenta, Color.cyan};


	   public void init() {
	      setup_layout();
	   }

	   private void setup_layout() {
	      setLayout(gbl);
	      for (int i=0; i<2; i++) {
	          makeButton(i,colors[i]);
	      }
	   }

	   void makeButton(int w, Color C) {
	       GridBagConstraints c = new GridBagConstraints();
	       Button b = new Button("" + w);
	       b.setBackground(C);

	       c.weightx = w;
	       c.weighty = 1;
	       c.fill = GridBagConstraints.BOTH;
	       gbl.setConstraints(b, c);
	       b.addActionListener(this);
	       add(b);
	   }

	   public void actionPerformed(ActionEvent evt) {
	       Button b = (Button)evt.getSource();
	       GridBagConstraints gbc = gbl.getConstraints(b);

	       if (++gbc.weightx > 4) {
	           gbc.weightx = 0;
	       }
	       gbl.setConstraints(b, gbc);
	       b.setLabel("" + gbc.weightx);
	       invalidate();
	       validate();
	   }

	}
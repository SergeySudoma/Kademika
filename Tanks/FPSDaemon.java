package Logic;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Timer;

public class FPSDaemon extends Thread {

	private int fpsPerSecond = 60;
	private ActionField af;

	public FPSDaemon(ActionField af) {
		this.af = af;
		this.setDaemon(true);
		this.start();		
	}

	@Override
	public void run() {
		super.run();

		Timer fpsTimer = new Timer(1000 / fpsPerSecond, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				af.repaint();
			}
		});
		fpsTimer.start();
	}

}

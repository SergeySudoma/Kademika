package lesson9ThreadsInteraction;

import Test.printInts;

public class Controller {

	private boolean shipArrived = false;
	private View view;
	private Gates gates;
	private Shuttle shuttle;
	private Panel panel;

	public Controller() {
		gates = new Gates();
		shuttle = new Shuttle();
		view = new View(shuttle, gates);
		panel = new Panel();
		panel.add(view);
		panel.setVisible(true);
	}

	public void shuttleGoHome() throws InterruptedException {
		Thread shuttleThread = new Thread(new Runnable() {

			@Override
			public void run() {
				for (int i = 0; i < 450; i++) {
					try {
						shuttle.updateX();
						Thread.sleep(5);
						view.repaint();
						if (shuttle.getX() == gates.getGamePart1().getX() - 50) {
							synchronized (shuttle) {
								shipArrived = true;
								synchronized (gates) {
									gates.notify();
								}
								shuttle.wait();
							}
						}
						
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				synchronized (gates) {
					gates.notify();
				}
			}
		});
		shuttleThread.start();
	}

	private void openGates() {
		for (int i = 0; i < 55; i++) {
			view.getGates().getGamePart1()
					.setY(view.getGates().getGamePart1().getY() - 1);
			view.getGates().getGamePart2()
					.setY(view.getGates().getGamePart2().getY() + 1);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			view.repaint();
		}
	}
	
	private void closeGates() {
		for (int i = 0; i < 55; i++) {
			view.getGates().getGamePart1()
					.setY(view.getGates().getGamePart1().getY() + 1);
			view.getGates().getGamePart2()
					.setY(view.getGates().getGamePart2().getY() - 1);
			try {
				Thread.sleep(5);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			view.repaint();
		}
	}

	public void initGates() throws InterruptedException {
		Thread t2 = new Thread(new Runnable() {

			@Override
			public void run() {

				synchronized (gates) {
					while (shipArrived == false) {
						try {
							gates.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					openGates();
					synchronized (shuttle) {
						shuttle.notify();
					}
					synchronized (gates) {
						try {
							gates.wait();
						} catch (InterruptedException e) {
							e.printStackTrace();
						}
					}
					closeGates();
				}
			}
		});
		t2.start();

	}
}

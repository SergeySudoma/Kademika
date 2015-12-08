package Objects;

import java.awt.Dimension;

import javax.swing.*;

import Logic.ActionField;
import Logic.BattleField;

public class Frame extends JFrame{
	
	ActionField af;
	BattleField bf;
	
	public Frame(){

	super("TANKS GAME");
	this.setLocation(750, 150);
	this.setMinimumSize(new Dimension(600, 600));
	this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
	//this.getContentPane().add(af);
	this.pack();
	//af.getRepaint();
	}
}


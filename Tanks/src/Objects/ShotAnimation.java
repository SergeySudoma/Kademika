package Objects;

import java.io.IOException;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

import Logic.Direction;

public class ShotAnimation extends JLabel{

	private AudioInputStream inputStream;
	private ImageIcon image;
	
	public ShotAnimation(Bullet bullet){
		initImage(bullet.getDirection());
		this.setIcon(image);
		playSound();
	}

	private void playSound() {
		try {
		Clip clip = AudioSystem.getClip();
		inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("shot_sound.wav"));
        clip.open(inputStream);
        clip.start(); 
        
        }
        catch(Exception e){  
        	
        }
	}
	
	private void initImage(Direction direction) {
		if(direction == Direction.UP){
			image = new ImageIcon(this.getClass().getResource("shot_up.gif"));
		}
		else if(direction == Direction.DOWN){
			image = new ImageIcon(this.getClass().getResource("shot_down.gif"));
		}
		else if(direction == Direction.LEFT){
			image = new ImageIcon(this.getClass().getResource("shot_left.gif"));
		}
		else{
			image = new ImageIcon(this.getClass().getResource("shot_right.gif"));
		}
	}
}

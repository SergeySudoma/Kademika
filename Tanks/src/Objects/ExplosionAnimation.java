package Objects;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class ExplosionAnimation extends JLabel {

	private ImageIcon image;
	
	public ExplosionAnimation(){
		initImage();
		this.setIcon(image);	
		playSound();		
	}

	private void playSound() {
		try {
		Clip clip = AudioSystem.getClip();
        AudioInputStream inputStream;
		inputStream = AudioSystem.getAudioInputStream(this.getClass().getResource("explosion_sound.wav"));
        clip.open(inputStream);
        clip.start(); 
		}
        catch(Exception e){        	
        }
	}
	
	private void initImage() {
			image = new ImageIcon(this.getClass().getResource("explosion.gif"));
	}
}
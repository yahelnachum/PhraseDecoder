package application.boundaries;

import java.awt.AlphaComposite;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.Timer;

import application.utilities.Converter;

public class StartupPanel extends JPanel {

	private final int frames = 210;
	private ImageIcon[] imgArray = new ImageIcon[frames];
	private int frameCount = 0;
	private Timer timer;
	
	/**
	 * Create the panel and start the animation.
	 */
	public StartupPanel(final HeartLoadingScreen parent) {
		
		// make it transparent
		setBackground(new Color(0, 0, 0, 0));
		
		// get the frames for the animation
		for(int i = 0; i < frames; i++){
			
			imgArray[i] = new ImageIcon(Converter.resourceStreamToFile("/application/resources/pictures/frames/heart_filling_"+ String.format("%04d", i+1)+".png").getPath());
		}
		
		// run the animation and startup the actual application after its done
		timer = new Timer(40, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
            	if(frameCount < frames-1){
            		frameCount++;
            	}
            	else{
            		timer.stop();
            		parent.startupApplication();
            	}
                repaint();
            }
        });
        timer.start();
        
        // load sound and play it
        try {
        	// create temp file and push the resource stream into it
        	File yourFile = Converter.resourceStreamToFile("/application/resources/sounds/water_sound_effect.wav");
        	
			// play audio from file
	        AudioInputStream stream;
	        AudioFormat format;
	        DataLine.Info info;
	        Clip clip;
	        
	        stream = AudioSystem.getAudioInputStream(yourFile);
	        format = stream.getFormat();
	        info = new DataLine.Info(Clip.class, format);
	        clip = (Clip) AudioSystem.getLine(info);
	        clip.open(stream);
	        clip.start();
		} catch (IOException | LineUnavailableException | UnsupportedAudioFileException e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}        
	}
	
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        
        // paint the current frame of animation
        ((Graphics2D)g).setComposite(AlphaComposite.getInstance(AlphaComposite.SRC));
        g.drawImage(imgArray[frameCount].getImage(), 0, 0, imgArray[frameCount].getIconWidth(), imgArray[frameCount].getIconHeight(), imgArray[frameCount].getImageObserver());
        
    }

}

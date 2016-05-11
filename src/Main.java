import java.awt.EventQueue;
import java.util.ArrayList;

import application.boundaries.HeartLoadingScreen;
import application.boundaries.MainFrame;
import application.entities.FileReader;
import application.entities.PhraseManager;
import application.utilities.Clock;
import application.utilities.Converter;


public class Main {

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					HeartLoadingScreen heartFrame = new HeartLoadingScreen();
					Thread.sleep(2000);
					heartFrame.dispose();
					MainFrame frame = MainFrame.getInstanceOfMainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}

package application.boundaries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

/**
 * @author Yahel
 * A frame to display the loading animation.
 */
public class HeartLoadingScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HeartLoadingScreen() {
		
		// set up the icon of the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.icon));
		
		// get screen size and put the frame in the middle of it
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int x = (int) Math.round((width / 2) - (500 / 2));
		int y = (int) Math.round((height/ 2) - (500 / 2));
				
		// make the frame invisible
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, 500, 500);
		
		// set up the content panel and make it transparent
		getContentPane().setLayout(new BorderLayout());
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		setBackground(new Color(0, 0, 0, 0));
		
		// set up the startup panel
		StartupPanel startupPanel = new StartupPanel(this);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(startupPanel, gbc_lblNewLabel);
		
		setVisible(true);
		requestFocus();
	}
	
	/**
	 * Dispose of loading animation frame and start up the actual application.
	 */
	public void startupApplication(){
		this.dispose();
		MainFrame mf = MainFrame.getInstanceOfMainFrame();
		mf.setVisible(true);
		mf.requestFocus();
	}

}

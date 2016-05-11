package application.boundaries;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Toolkit;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class HeartLoadingScreen extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public HeartLoadingScreen() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImageIcon imageIcon = new ImageIcon("heart.png");
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		int x = (int) Math.round((width / 2) - (imageIcon.getIconWidth() / 2));
		int y = (int) Math.round((height/ 2) - (imageIcon.getIconHeight() / 2));
				
		setUndecorated(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(x, y, imageIcon.getIconWidth(), imageIcon.getIconHeight());
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
		
		JLabel lblNewLabel = new JLabel("New label");
		
		lblNewLabel.setSize(new Dimension(imageIcon.getIconWidth(), imageIcon.getIconHeight()));
		lblNewLabel.setIcon(imageIcon);
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		contentPane.add(lblNewLabel, gbc_lblNewLabel);
		
		setVisible(true);
		requestFocus();
	}

}

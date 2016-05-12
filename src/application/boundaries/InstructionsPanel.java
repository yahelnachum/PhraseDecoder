package application.boundaries;

import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JLabel;
import java.awt.GridBagConstraints;
import java.awt.Font;
import java.awt.Dimension;
import javax.swing.JTextPane;
import java.awt.Color;
import javax.swing.UIManager;
import java.awt.SystemColor;
import java.awt.Insets;

/**
 * @author Yahel
 * Panel to display instructions of application.
 */
public class InstructionsPanel extends JPanel {
	private final JLabel enterLabel = new JLabel("Press enter to continue.");

	/**
	 * Create the panel.
	 */
	public InstructionsPanel() {
		
		// set up layout of panel
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[]{0, 0};
		gridBagLayout.rowHeights = new int[]{0, 0, 0, 0};
		gridBagLayout.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gridBagLayout.rowWeights = new double[]{5.0, 10.0, 1.0, Double.MIN_VALUE};
		setLayout(gridBagLayout);
		
		// set up instructions title
		JTextPane instructionsTitle = new JTextPane();
		instructionsTitle.setRequestFocusEnabled(false);
		instructionsTitle.setText("Instructions:");
		instructionsTitle.setFont(new Font("Yu Gothic UI", Font.PLAIN, 30));
		instructionsTitle.setEditable(false);
		instructionsTitle.setBackground(SystemColor.menu);
		GridBagConstraints gbc_instructionsTitle = new GridBagConstraints();
		gbc_instructionsTitle.anchor = GridBagConstraints.SOUTH;
		gbc_instructionsTitle.insets = new Insets(0, 0, 5, 0);
		gbc_instructionsTitle.gridx = 0;
		gbc_instructionsTitle.gridy = 0;
		add(instructionsTitle, gbc_instructionsTitle);
		
		// set up instructions body
		JTextPane instructionsBody = new JTextPane();
		instructionsBody.setMargin(new Insets(10, 10, 10, 10));
		instructionsBody.setPreferredSize(new Dimension(500, 500));
		instructionsBody.setMinimumSize(new Dimension(500, 200));
		instructionsBody.setRequestFocusEnabled(false);
		instructionsBody.setBackground(MainFrame.phrasePanelColor);
		instructionsBody.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		instructionsBody.setText("Drag and drop files from your computer into the designated area to decode a phrase.\r\n\r\nPress the 'r' key to get a new random phrase.");
		instructionsBody.setEditable(false);
		GridBagConstraints gbc_instructionsBody = new GridBagConstraints();
		gbc_instructionsBody.anchor = GridBagConstraints.NORTH;
		gbc_instructionsBody.insets = new Insets(0, 0, 5, 0);
		gbc_instructionsBody.gridx = 0;
		gbc_instructionsBody.gridy = 1;
		add(instructionsBody, gbc_instructionsBody);
		
		// set up enter label
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 2;
		enterLabel.setRequestFocusEnabled(false);
		enterLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		add(enterLabel, gbc_lblNewLabel);

	}

}

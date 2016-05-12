package application.boundaries;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.Dimension;
import java.awt.Insets;


public class PhrasePanel extends JPanel {

	private JLabel phraseLabel;
	private JLabel resetLabel;
	
	/**
	 * Create the panel.
	 */
	public PhrasePanel() {
		
		// set up layout
		GridBagLayout gbl_phrasePanel = new GridBagLayout();
		gbl_phrasePanel.columnWidths = new int[]{46, 0};
		gbl_phrasePanel.rowHeights = new int[]{100, 0, 0};
		gbl_phrasePanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_phrasePanel.rowWeights = new double[]{10.0, 1.0, Double.MIN_VALUE};
		setLayout(gbl_phrasePanel);
		
		// add the phrase label
		phraseLabel = new JLabel(MainFrame.init_phraseLabelText);
		phraseLabel.setPreferredSize(new Dimension(300, 200));
		phraseLabel.setMaximumSize(new Dimension(2000, 1000));
		phraseLabel.setMinimumSize(new Dimension(300, 200));
		phraseLabel.setForeground(new Color(100,100,100));
		phraseLabel.setHorizontalAlignment(SwingConstants.CENTER);
		phraseLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		phraseLabel.setFont(new Font("Yu Gothic UI", phraseLabel.getFont().getStyle() & ~Font.BOLD & ~Font.ITALIC, 20));
		GridBagConstraints gbc_phraseLabel = new GridBagConstraints();
		gbc_phraseLabel.insets = new Insets(0, 0, 5, 0);
		gbc_phraseLabel.fill = GridBagConstraints.BOTH;
		gbc_phraseLabel.gridx = 0;
		gbc_phraseLabel.gridy = 0;
		add(phraseLabel, gbc_phraseLabel);
		
		// add the reset label but make it invisible
		resetLabel = new JLabel("Press 'r' to get a new random phrase.");
		resetLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 11));
		GridBagConstraints gbc_resetLabel = new GridBagConstraints();
		gbc_resetLabel.gridx = 0;
		gbc_resetLabel.gridy = 1;
		add(resetLabel, gbc_resetLabel);
		resetLabel.setVisible(false);
	}
	
	/**
	 * @return Return the phrase label
	 */
	public JLabel getPhraseLabel(){
		return phraseLabel;
	}
	
	/**
	 * @return Return the reset label
	 */
	public JLabel getResetLabel(){
		return resetLabel;
	}

}

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;


public class MainFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setBounds(new Rectangle(0, 0, 500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 500, 500);
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{208, 0};
		gbl_contentPane.rowHeights = new int[]{200, 400, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{2.0, 3.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		DragAndDropPanel dragAndDropPanel = new DragAndDropPanel();
		dragAndDropPanel.setBorder(null);
		dragAndDropPanel.setBackground(Color.GRAY);
		int i = 100;
		dragAndDropPanel.setBorder(BorderFactory.createDashedBorder(new Color(i,i,i), 4.0f, 3.0f, 3.0f, false));
		GridBagConstraints gbc_dragAndDropPanel = new GridBagConstraints();
		gbc_dragAndDropPanel.fill = GridBagConstraints.BOTH;
		gbc_dragAndDropPanel.insets = new Insets(0, 0, 5, 0);
		gbc_dragAndDropPanel.gridx = 0;
		gbc_dragAndDropPanel.gridy = 0;
		contentPane.add(dragAndDropPanel, gbc_dragAndDropPanel);
		GridBagLayout gbl_dragAndDropPanel = new GridBagLayout();
		gbl_dragAndDropPanel.columnWidths = new int[]{46, 0};
		gbl_dragAndDropPanel.rowHeights = new int[]{100, 0};
		gbl_dragAndDropPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_dragAndDropPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		dragAndDropPanel.setLayout(gbl_dragAndDropPanel);
		
		JLabel lblNewLabel = new JLabel("Drag and drop files from your computer here.");
		lblNewLabel.setForeground(Color.LIGHT_GRAY);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		dragAndDropPanel.add(lblNewLabel, gbc_lblNewLabel);
		
		PhrasePanel phrasePanel = new PhrasePanel();
		GridBagConstraints gbc_phrasePanel = new GridBagConstraints();
		gbc_phrasePanel.fill = GridBagConstraints.BOTH;
		gbc_phrasePanel.gridx = 0;
		gbc_phrasePanel.gridy = 1;
		contentPane.add(phrasePanel, gbc_phrasePanel);
	}
}

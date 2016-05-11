package application.boundaries;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import java.awt.Rectangle;
import java.awt.FlowLayout;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.BoxLayout;

import java.awt.Dimension;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.Font;
import java.awt.Toolkit;

import javax.swing.SwingConstants;
import javax.swing.border.BevelBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.LineBorder;
import javax.swing.border.TitledBorder;

import application.controllers.RestartPhraseController;


public class MainFrame extends JFrame {

	public final static Color dashedBorderColor = new Color(100,100,100);
	
	public final static Color enterDragColor = new Color(150,150,150);
	public final static Color exitDragColor = new Color(125,125,125);
	public final static Color phrasePanelColor = new Color(240,240,240);
	public final static Color phraseFullyDecodedPanelColor = new Color(200,255,200);
	
	public final static String init_phraseLabelText = "Phrase will appear here.";
	
	private JPanel contentPane;
	DragAndDropPanel dragAndDropPanel;
	PhrasePanel phrasePanel;
	private static MainFrame mainFrame = new MainFrame();

	/**
	 * Create the frame.
	 */
	private MainFrame() {
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		
		ImageIcon imageIcon = new ImageIcon("heart.png");
		
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		
		int x = (int) Math.round((width / 2) - (500 / 2));
		int y = (int) Math.round((height/ 2) - (500 / 2));
		
		setBounds(new Rectangle(x, y, 500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
		
		dragAndDropPanel = new DragAndDropPanel();
		dragAndDropPanel.setBorder(null);
		dragAndDropPanel.setBackground(exitDragColor);
		dragAndDropPanel.setBorder(BorderFactory.createDashedBorder(dashedBorderColor, 4.0f, 3.0f, 3.0f, false));
		GridBagConstraints gbc_dragAndDropPanel = new GridBagConstraints();
		gbc_dragAndDropPanel.fill = GridBagConstraints.BOTH;
		gbc_dragAndDropPanel.insets = new Insets(0, 0, 0, 0);
		gbc_dragAndDropPanel.gridx = 0;
		gbc_dragAndDropPanel.gridy = 0;
		contentPane.add(dragAndDropPanel, gbc_dragAndDropPanel);
		
		phrasePanel = new PhrasePanel();
		phrasePanel.setBackground(phrasePanelColor);
		GridBagConstraints gbc_phrasePanel = new GridBagConstraints();
		gbc_phrasePanel.fill = GridBagConstraints.BOTH;
		gbc_phrasePanel.insets = new Insets(0, 0, 0, 0);
		gbc_phrasePanel.gridx = 0;
		gbc_phrasePanel.gridy = 1;
		contentPane.add(phrasePanel, gbc_phrasePanel);
		
		addKeyListener(new RestartPhraseController());
	}
	
	public static MainFrame getInstanceOfMainFrame(){
		return mainFrame;
	}
	
	public DragAndDropPanel getDragAndDropPanel(){
		return dragAndDropPanel;
	}
	
	public PhrasePanel getPhrasePanel(){
		return phrasePanel;
	}
}

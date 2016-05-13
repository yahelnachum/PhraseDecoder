package application.boundaries;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.KeyStroke;
import javax.swing.border.EmptyBorder;

import application.controllers.ExitInstructionsPanelController;
import application.controllers.RestartPhraseController;
import application.utilities.Converter;


/**
 * @author Yahel
 * The main frame of the application.
 */
public class MainFrame extends JFrame {

	public final static Color dashedBorderColor = new Color(100,100,100);
	
	public final static Color enterDragColor = new Color(150,150,150);
	public final static Color exitDragColor = new Color(125,125,125);
	public final static Color phrasePanelColor = new Color(240,240,240);
	public final static Color phraseFullyDecodedPanelColor = new Color(200,255,200);
	
	public final static String init_phraseLabelText = "Phrase will appear here.";
	
	public final static String icon = Converter.resourceStreamToFile("/application/resources/pictures/icon.png").getPath();
	
	private JPanel contentPane;
	private DragAndDropPanel dragAndDropPanel;
	private PhrasePanel phrasePanel;
	private InstructionsPanel panel;
	private GridBagConstraints gbc_panel;
	private ExitInstructionsPanelController exitInstructionsPanelController = new ExitInstructionsPanelController();
	private static MainFrame mainFrame = new MainFrame();

	/**
	 * Create the frame.
	 */
	private MainFrame() {
		// set up the icon of the frame
		setIconImage(Toolkit.getDefaultToolkit().getImage(MainFrame.icon));
		
		// get screen size and position application in the center.
		Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
		double width = screenSize.getWidth();
		double height = screenSize.getHeight();
		int x = (int) Math.round((width / 2) - (500 / 2));
		int y = (int) Math.round((height/ 2) - (500 / 2));
		
		setBounds(new Rectangle(x, y, 500, 500));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// set up the content panel
		contentPane = new JPanel();
		contentPane.setBounds(new Rectangle(0, 0, 500, 500));
		contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{0, 0};
		gbl_contentPane.rowHeights = new int[]{0, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		panel = new InstructionsPanel();
		gbc_panel = new GridBagConstraints();
		gbc_panel.fill = GridBagConstraints.BOTH;
		gbc_panel.gridx = 0;
		gbc_panel.gridy = 0;
		contentPane.add(panel, gbc_panel);
		
		contentPane.getInputMap(contentPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "HI");
		contentPane.getActionMap().put("HI", new ExitInstructionsPanelController());
		//addKeyListener(exitInstructionsPanelController);
	}
	
	/**
	 * Set up frame after the instructions have been read
	 */
	public void afterInstructionsPanel(){
		// remove everything
		contentPane.removeAll();
		
		// set up new layout
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{208, 0};
		gbl_contentPane.rowHeights = new int[]{200, 400, 0};
		gbl_contentPane.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{2.0, 3.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		// set up the drag and drop panel
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
		
		// set up the phrase panel
		phrasePanel = new PhrasePanel();
		phrasePanel.setBackground(phrasePanelColor);
		GridBagConstraints gbc_phrasePanel = new GridBagConstraints();
		gbc_phrasePanel.fill = GridBagConstraints.BOTH;
		gbc_phrasePanel.insets = new Insets(0, 0, 0, 0);
		gbc_phrasePanel.gridx = 0;
		gbc_phrasePanel.gridy = 1;
		contentPane.add(phrasePanel, gbc_phrasePanel);
		
		// add a key listener to restart the phrase manager
		contentPane.getInputMap(contentPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("ENTER"), "doNothing");
		contentPane.getInputMap(contentPane.WHEN_IN_FOCUSED_WINDOW).put(KeyStroke.getKeyStroke("R"), "RESET");
		contentPane.getActionMap().put("RESET", new RestartPhraseController());
		
		// refresh
		revalidate();
	}
	
	/**
	 * @return Returns an instance of the main frame.
	 */
	public static MainFrame getInstanceOfMainFrame(){
		return mainFrame;
	}
	
	/**
	 * @return Returns the drag and drop panel
	 */
	public DragAndDropPanel getDragAndDropPanel(){
		return dragAndDropPanel;
	}
	
	/**
	 * @return Returns the phrase panel
	 */
	public PhrasePanel getPhrasePanel(){
		return phrasePanel;
	}
}

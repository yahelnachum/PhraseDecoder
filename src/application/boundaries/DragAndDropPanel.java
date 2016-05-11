package application.boundaries;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.TooManyListenersException;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import application.controllers.DragAndDropController;

import java.awt.Dimension;


public class DragAndDropPanel extends JPanel{

	DropTarget dt;
	DragAndDropController dth;
	JLabel dragAndDropLabel;
	
	/**
	 * Create the panel.
	 */
	public DragAndDropPanel() {
		
		GridBagLayout gbl_dragAndDropPanel = new GridBagLayout();
		gbl_dragAndDropPanel.columnWidths = new int[]{46, 0};
		gbl_dragAndDropPanel.rowHeights = new int[]{100, 0};
		gbl_dragAndDropPanel.columnWeights = new double[]{1.0, Double.MIN_VALUE};
		gbl_dragAndDropPanel.rowWeights = new double[]{1.0, Double.MIN_VALUE};
		setLayout(gbl_dragAndDropPanel);
				
		dragAndDropLabel = new JLabel("<html><center>Drag and drop files from your computer here.</center></html>");
		dragAndDropLabel.setMinimumSize(new Dimension(200, 100));
		dragAndDropLabel.setForeground(Color.LIGHT_GRAY);
		dragAndDropLabel.setHorizontalAlignment(SwingConstants.CENTER);
		dragAndDropLabel.setHorizontalTextPosition(SwingConstants.CENTER);
		dragAndDropLabel.setFont(new Font("Yu Gothic UI", Font.PLAIN, 20));
		GridBagConstraints gbc_lblNewLabel = new GridBagConstraints();
		gbc_lblNewLabel.fill = GridBagConstraints.BOTH;
		gbc_lblNewLabel.gridx = 0;
		gbc_lblNewLabel.gridy = 0;
		add(dragAndDropLabel, gbc_lblNewLabel);
		

		dt = new DropTarget();
		dth = new DragAndDropController();
		try {
			dt.addDropTargetListener(dth);
		} catch (TooManyListenersException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.setDropTarget(dt);
	}
}

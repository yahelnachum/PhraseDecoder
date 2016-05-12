package application.controllers;

import java.awt.Color;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTargetDragEvent;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.dnd.DropTargetEvent;
import java.awt.dnd.DropTargetListener;
import java.io.File;
import java.io.IOException;
import java.util.List;

import application.boundaries.MainFrame;
import application.boundaries.PhrasePanel;
import application.entities.Phrase;
import application.entities.PhraseManager;
import application.utilities.Converter;

/**
 * @author Yahel
 * Controls the behavior of the drag and drop feature in the application.
 */
public class DragAndDropController implements DropTargetListener{

	@Override
	public void drop(DropTargetDropEvent dtde) {
		
		// change background color
		MainFrame.getInstanceOfMainFrame().getDragAndDropPanel().setBackground(MainFrame.exitDragColor);
		
		// accept drop and get files from drop
		dtde.acceptDrop(DnDConstants.ACTION_LINK);
		List files = null;
		try {
			files = (List) dtde.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
		} catch (UnsupportedFlavorException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		// get the path to the files and decode the phrase
		if(files != null){
			File file = (File) files.get(0);
			String filePath = file.getPath();
			PhraseManager pm = PhraseManager.getPhraseManagerInstance();
			pm.decodeCurrentPhrase(filePath);
			Phrase currentPhrase = pm.getCurrentPhrase();
			String phraseText = Converter.charArrayToString(currentPhrase.getDecodedPhrase());
			
			// if phrase is fully decoded then turn background to green.
			PhrasePanel pp = MainFrame.getInstanceOfMainFrame().getPhrasePanel();
			pp.getPhraseLabel().setText("<html><center>" + phraseText + "</center></html>");
			if(currentPhrase.phraseFullyDecoded()){
				pp.setBackground(MainFrame.phraseFullyDecodedPanelColor);
				pp.getResetLabel().setVisible(true);
			}
			
			
			
		}
		
		dtde.dropComplete(true);
	}

	@Override
	public void dragEnter(DropTargetDragEvent dtde) {
		MainFrame.getInstanceOfMainFrame().getDragAndDropPanel().setBackground(MainFrame.enterDragColor);
	}

	@Override
	public void dragExit(DropTargetEvent dte) {
		MainFrame.getInstanceOfMainFrame().getDragAndDropPanel().setBackground(MainFrame.exitDragColor);
	}

	@Override
	public void dragOver(DropTargetDragEvent dtde) {}

	@Override
	public void dropActionChanged(DropTargetDragEvent dtde) {}
}

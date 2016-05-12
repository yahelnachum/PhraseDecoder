package application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import application.boundaries.MainFrame;
import application.entities.PhraseManager;

/**
 * @author Yahel
 * Exits instructions and enters actual application.
 */
public class ExitInstructionsPanelController extends AbstractAction{

	public void actionPerformed(ActionEvent arg0) {
		MainFrame.getInstanceOfMainFrame().afterInstructionsPanel();
	}
}

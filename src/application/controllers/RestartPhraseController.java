package application.controllers;

import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.AbstractAction;

import application.boundaries.MainFrame;
import application.entities.PhraseManager;

/**
 * @author Yahel
 * Restarts the PhraseManager when r is pressed
 */
public class RestartPhraseController extends AbstractAction{

	@Override
	public void actionPerformed(ActionEvent arg0) {
		MainFrame mf = MainFrame.getInstanceOfMainFrame();
		mf.getPhrasePanel().setBackground(MainFrame.phrasePanelColor);
		mf.getPhrasePanel().getPhraseLabel().setText(MainFrame.init_phraseLabelText);
		mf.getPhrasePanel().getResetLabel().setVisible(false);
		PhraseManager.getPhraseManagerInstance().resetManager();
	}
}

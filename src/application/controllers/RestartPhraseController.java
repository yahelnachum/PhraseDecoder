package application.controllers;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import application.boundaries.MainFrame;
import application.entities.PhraseManager;

public class RestartPhraseController extends KeyAdapter{

	public void keyTyped(KeyEvent e){
		if(e.getKeyChar() == 'r'){
			MainFrame mf = MainFrame.getInstanceOfMainFrame();
			mf.getPhrasePanel().setBackground(MainFrame.phrasePanelColor);
			mf.getPhrasePanel().getPhraseLabel().setText(MainFrame.init_phraseLabelText);
			mf.getPhrasePanel().getResetLabel().setVisible(false);
			PhraseManager.getPhraseManagerInstance().resetManager();
		}
	}
}

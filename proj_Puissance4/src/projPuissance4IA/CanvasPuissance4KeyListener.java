package projPuissance4IA;

import java.awt.*;
import java.awt.event.*;


public class CanvasPuissance4KeyListener extends KeyAdapter implements KeyListener {

	private Jeu jeu;
	private Frame frame;
	private boolean iaEnabled;
	
	public CanvasPuissance4KeyListener(Jeu jeu, Frame frame, boolean iaisEnabled) {
		this.jeu = jeu;
		this.frame = frame;
		iaEnabled = iaisEnabled;
	}
	
	public void keyPressed(KeyEvent e) {
		int colonne = 1;
		switch(e.getKeyCode()) {
		case KeyEvent.VK_1:
			colonne = 1;
			break;
		case KeyEvent.VK_2:
			colonne = 2;
			break;
		case KeyEvent.VK_3:
			colonne = 3;
			break;
		case KeyEvent.VK_4:
			colonne = 4;
			break;
		case KeyEvent.VK_5:
			colonne = 5;
			break;
		case KeyEvent.VK_6:
			colonne = 6;
			break;
		case KeyEvent.VK_7:
			colonne = 7;
			break;
		case KeyEvent.VK_8:
			colonne = 8;
			break;
		case KeyEvent.VK_9:
			colonne = 9;
			break;
		}
		if(iaEnabled) {if(jeu.updateIAGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled); frame.dispose();}}
		else {if(jeu.updateGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled); frame.dispose();}}
	}

}

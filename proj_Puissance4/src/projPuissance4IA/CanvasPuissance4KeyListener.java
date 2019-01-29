package projPuissance4IA;

import java.awt.*;
import java.awt.event.*;

/**
 * Ce contr�leur permet de jouer en utilisant les touches num�rot�es du clavier (pas du 
 * pav� num�rique)
 * 
 * @author Ewald
 *
 */
public class CanvasPuissance4KeyListener extends KeyAdapter implements KeyListener {

	/**
	 * Le contr�leur de jeu actuel
	 * @see Jeu
	 */
	private Jeu jeu;
	
	/**
	 * La FramePuissance4 actuelle, pour la passer au contr�leur suivant, et la dispose() � la fin
	 * de la partie
	 * @see FramePuissance4
	 * @see Frame
	 * @see FrameVictoire
	 */
	private Frame frame;
	
	/**
	 * Bool�en repr�sentant l'activation ou non de l'IA
	 */
	private boolean iaEnabled;
	
	/**
	 * Constructeur du CanvasPuissance4KeyListener
	 * 
	 * @param jeu le contr�leur de jeu actuel
	 * @param frame la FramePuissance4 dans laquelle le jeu est affich�
	 * @param iaisEnabled le bool�en repr�sentant l'activation de l'IA
	 * @see CanvasPuissance4KeyListener#jeu
	 * @see CanvasPuissance4KeyListener#frame
	 * @see CanvasPuissance4KeyListener#iaEnabled
	 */
	public CanvasPuissance4KeyListener(Jeu jeu, Frame frame, boolean iaisEnabled) {
		this.jeu = jeu;
		this.frame = frame;
		iaEnabled = iaisEnabled;
	}
	
	/**
	 * M�thode appel�e lorsqu'une touche est press�e, permet de joueur dans la bonne colonne, de
	 * v�rifier si la partie est termin�e, et si oui de passer � une FrameVictoire
	 * @see FrameVictoire
	 */
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
		if(iaEnabled) {if(jeu.updateIAGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
		else {if(jeu.updateGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
	}

}

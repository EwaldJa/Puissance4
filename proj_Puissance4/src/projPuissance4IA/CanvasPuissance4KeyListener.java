package projPuissance4IA;

import java.awt.*;
import java.awt.event.*;

/**
 * Ce contrôleur permet de jouer en utilisant les touches numérotées du clavier (pas du 
 * pavé numérique)
 * 
 * @author Ewald
 *
 */
public class CanvasPuissance4KeyListener extends KeyAdapter implements KeyListener {

	/**
	 * Le contrôleur de jeu actuel
	 * @see Jeu
	 */
	private Jeu jeu;
	
	/**
	 * La FramePuissance4 actuelle, pour la passer au contrôleur suivant, et la dispose() à la fin
	 * de la partie
	 * @see FramePuissance4
	 * @see Frame
	 * @see FrameVictoire
	 */
	private Frame frame;
	
	/**
	 * Booléen représentant l'activation ou non de l'IA
	 */
	private boolean iaEnabled;
	
	/**
	 * Constructeur du CanvasPuissance4KeyListener
	 * 
	 * @param jeu le contrôleur de jeu actuel
	 * @param frame la FramePuissance4 dans laquelle le jeu est affiché
	 * @param iaisEnabled le booléen représentant l'activation de l'IA
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
	 * Méthode appelée lorsqu'une touche est pressée, permet de joueur dans la bonne colonne, de
	 * vérifier si la partie est terminée, et si oui de passer à une FrameVictoire
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

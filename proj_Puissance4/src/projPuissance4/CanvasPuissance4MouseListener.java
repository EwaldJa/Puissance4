package projPuissance4;

import java.awt.Frame;
import java.awt.event.*;

/**
 * Ce contrôleur permet de jouer cliquant sur la colonne souhaitée
 * 
 * @author Ewald
 *
 */
public class CanvasPuissance4MouseListener extends MouseAdapter {
	
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
	 * Constructeur du CanvasPuissance4MouseListener
	 * 
	 * @param jeu le contrôleur de jeu actuel
	 * @param frame la FramePuissance4 dans laquelle le jeu est affiché
	 * @param iaisEnabled le booléen représentant l'activation de l'IA
	 * @see CanvasPuissance4MouseListener#jeu
	 * @see CanvasPuissance4MouseListener#frame
	 * @see CanvasPuissance4MouseListener#iaEnabled
	 */
	public CanvasPuissance4MouseListener(Jeu jeu, Frame frame, boolean iaisEnabled) {
		this.jeu = jeu;
		this.frame = frame;
		iaEnabled = iaisEnabled;
	}

	/**
	 * Méthode appelée lorsqu'un clic est effectué dans le canvas, permet de joueur dans la bonne colonne, de
	 * vérifier si la partie est terminée, et si oui de passer à une FrameVictoire
	 * @see FrameVictoire
	 */
	public void mousePressed(MouseEvent e) {
		int clicX = e.getX();
		if ((clicX > FramePuissance4.GAP_CASE) && (clicX < (jeu.getColonnes() * (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) + FramePuissance4.GAP_CASE + FramePuissance4.LEGENDE))) {
			int colonne = 1;
			while(clicX > FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) {
				colonne++;
				clicX -= (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE);
			}
			if (iaEnabled) {if(jeu.updateIAGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
			else {if(jeu.updateGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
		}

	}

}

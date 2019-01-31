package projPuissance4;

import java.awt.Frame;
import java.awt.event.*;

/**
 * Ce contr�leur permet de jouer cliquant sur la colonne souhait�e
 * 
 * @author Ewald
 *
 */
public class CanvasPuissance4MouseListener extends MouseAdapter {
	
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
	 * Constructeur du CanvasPuissance4MouseListener
	 * 
	 * @param jeu le contr�leur de jeu actuel
	 * @param frame la FramePuissance4 dans laquelle le jeu est affich�
	 * @param iaisEnabled le bool�en repr�sentant l'activation de l'IA
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
	 * M�thode appel�e lorsqu'un clic est effectu� dans le canvas, permet de joueur dans la bonne colonne, de
	 * v�rifier si la partie est termin�e, et si oui de passer � une FrameVictoire
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

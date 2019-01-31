package projPuissance4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du bouton servant à quitter le jeu sur la FrameVictoire
 * 
 * @author Ewald
 * @see FrameVictoire
 */
public class QuitterListener implements ActionListener {
	
	/**
	 * Frame qu'il faudra quitter dès que le joueur appuie sur la croix
	 * @see FrameVictoire
	 */
	private FrameVictoire myframe;

	/**
	 * Constructeur du QuitterListener
	 * @param frame écoutée par le Listener
	 * @see FrameVictoire
	 */
	public QuitterListener(FrameVictoire frame) {
		myframe = frame;
	}

	/**
	 * Appelle à la méthode quitter() de FrameVictoire pour fermer celle-ci à la demande de l'utilisateur
	 * @see FrameVictoire#quitter()
	 */
	public void actionPerformed(ActionEvent e) {
		myframe.quitter();
	}

}

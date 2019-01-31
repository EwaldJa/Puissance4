package projPuissance4;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du bouton permettant de recommencer une partie avec de nouveaux param�tres sur la FrameVictoire
 * 
 * @author Ewald
 * @see FrameVictoire
 */
public class RecommencerListener implements ActionListener {

	/**
	 * Frame qu'il faudra quitter d�s que le joueur appuie sur la croix
	 * @see FrameVictoire
	 */
	private FrameVictoire myframe;

	/**
	 * Constructeur du RecommencerListener
	 * @param frame �cout�e par le Listener
	 * @see FrameVictoire
	 */
	public RecommencerListener(FrameVictoire frame) {
		myframe = frame;
	}

	/**
	 * Appelle � la m�thode quitter() de FrameVictoire pour fermer celle-ci � la demande de l'utilisateur, et instancie un nouveau GameFrame
	 * @see FrameVictoire#quitter()
	 * @see GameFrame
	 */
	public void actionPerformed(ActionEvent e) {
		myframe.quitter();
		new GameFrame();
	}

}

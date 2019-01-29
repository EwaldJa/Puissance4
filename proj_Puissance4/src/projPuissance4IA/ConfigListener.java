package projPuissance4IA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener plac� sur les boutons dans la GameFrame. Il permet de r�cup�rer la pr�-configuration du jeu
 * 
 * @author Ewald
 * @see GameFrame
 */
public class ConfigListener implements ActionListener {

	/**
	 * La GameFrame permettant de r�cup�rer le mode de jeu et la configuration de la vue
	 * @see GameFrame
	 */
	private GameFrame myframe;
	
	/**
	 * Bool�en repr�sentant l'activation du mode 1v1, Humain contre Machine
	 */
	boolean iaEnabled;
	
	/**
	 * Constructeur du ConfigListener
	 * @param gameFrame pour r�cup�rer la configuration
	 * @param iaisEnabled repr�sentant le mode IA
	 * @see ConfigListener#myframe
	 * @see ConfigListener#iaEnabled
	 */
	public ConfigListener(GameFrame gameFrame, boolean iaisEnabled) {
		myframe = gameFrame;
		iaEnabled = iaisEnabled;
	}

	@Override
	/**
	 * M�thode appel�e au clic sur un bouton pour passer � la phase de choix des caract�ristiques de 
	 * la partie, r�cup�re la pr�-configuration (IA ou non et vue), instancie une LaunchFrame, et
	 * ferme la GameFrame
	 * @see GameFrame
	 * @see LaunchFrame
	 */
	public void actionPerformed(ActionEvent arg0) {
		new LaunchFrame(myframe.getVue(), iaEnabled);
		myframe.dispose();
	}

}

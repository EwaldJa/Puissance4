package projPuissance4IA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Listener placé sur les boutons dans la GameFrame. Il permet de récupérer la pré-configuration du jeu
 * 
 * @author Ewald
 * @see GameFrame
 */
public class ConfigListener implements ActionListener {

	/**
	 * La GameFrame permettant de récupérer le mode de jeu et la configuration de la vue
	 * @see GameFrame
	 */
	private GameFrame myframe;
	
	/**
	 * Booléen représentant l'activation du mode 1v1, Humain contre Machine
	 */
	boolean iaEnabled;
	
	/**
	 * Constructeur du ConfigListener
	 * @param gameFrame pour récupérer la configuration
	 * @param iaisEnabled représentant le mode IA
	 * @see ConfigListener#myframe
	 * @see ConfigListener#iaEnabled
	 */
	public ConfigListener(GameFrame gameFrame, boolean iaisEnabled) {
		myframe = gameFrame;
		iaEnabled = iaisEnabled;
	}

	@Override
	/**
	 * Méthode appelée au clic sur un bouton pour passer à la phase de choix des caractéristiques de 
	 * la partie, récupère la pré-configuration (IA ou non et vue), instancie une LaunchFrame, et
	 * ferme la GameFrame
	 * @see GameFrame
	 * @see LaunchFrame
	 */
	public void actionPerformed(ActionEvent arg0) {
		new LaunchFrame(myframe.getVue(), iaEnabled);
		myframe.dispose();
	}

}

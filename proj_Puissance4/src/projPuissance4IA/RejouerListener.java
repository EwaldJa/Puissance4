package projPuissance4IA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du bouton permettant de rejouer une partie avec les m�mes param�tres sur la FrameVictoire
 * 
 * @author Ewald
 * @see FrameVictoire
 */
public class RejouerListener implements ActionListener {
	
	/**
	 * Contr�leur permettant d'obtenir les caract�ristiques de la partie@see Jeu
	 */
	private Jeu jeu;
	/**
	 * Frame qu'il faudra quitter d�s que le joueur appuie sur la croix
	 * @see FrameVictoire
	 */
	private FrameVictoire myframe;
	
	/**
	 * Bool�en repr�sentant si le mode IA versus Humain est activ� (true) ou non (false)
	 */
	private boolean iaEnabled;

	public RejouerListener(FrameVictoire frame, Jeu jeu, boolean iaisEnabled) {
		this.jeu = jeu;
		myframe = frame;
		iaEnabled = iaisEnabled;
	}

	/**
	 * Appelle � la m�thode quitter() de FrameVictoire pour fermer celle-ci � la demande de l'utilisateur, et instancie un nouveau Jeu, en fonction des
	 * param�tres de la manche qui vient de se terminer
	 * @see FrameVictoire#quitter()
	 * @see Jeu
	 */
	public void actionPerformed(ActionEvent e) {
		IA ia = null;
		Joueur[] mesjoueurs = null;
		if (iaEnabled){
			mesjoueurs = new Joueur[2];
			Joueur j1 = new Joueur('O', Color.GREEN);
			ia = new IA('X', jeu.getIA().getDifficulty());
			ia.setJSuivant(j1); j1.setJSuivant(ia);
			mesjoueurs[0] = j1;	mesjoueurs[1] = ia;
		}
		else {
			mesjoueurs = jeu.getTabJoueurs();
		}
		Jeu newjeu = new Jeu(jeu.getGraphismes(), jeu.getLignes(), jeu.getColonnes(), jeu.getAlignement(), mesjoueurs, iaEnabled, ia);
		if (!newjeu.getGraphismes()) {newjeu.jouer(iaEnabled);}
		myframe.quitter();
	}

}

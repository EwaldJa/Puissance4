package projPuissance4IA;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * Ecouteur du bouton permettant de rejouer une partie avec les mêmes paramètres sur la FrameVictoire
 * 
 * @author Ewald
 * @see FrameVictoire
 */
public class RejouerListener implements ActionListener {
	
	/**
	 * Contrôleur permettant d'obtenir les caractéristiques de la partie@see Jeu
	 */
	private Jeu jeu;
	/**
	 * Frame qu'il faudra quitter dès que le joueur appuie sur la croix
	 * @see FrameVictoire
	 */
	private FrameVictoire myframe;
	
	/**
	 * Booléen représentant si le mode IA versus Humain est activé (true) ou non (false)
	 */
	private boolean iaEnabled;

	public RejouerListener(FrameVictoire frame, Jeu jeu, boolean iaisEnabled) {
		this.jeu = jeu;
		myframe = frame;
		iaEnabled = iaisEnabled;
	}

	/**
	 * Appelle à la méthode quitter() de FrameVictoire pour fermer celle-ci à la demande de l'utilisateur, et instancie un nouveau Jeu, en fonction des
	 * paramètres de la manche qui vient de se terminer
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

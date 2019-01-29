package projPuissance4IA;

import java.awt.Color;
import java.awt.event.*;

/**
 * Ecouteur du bouton de lancement de jeu sur une instance de LaunchFrame. Permet de lancer une partie de Puissance 4
 * 
 * @author Ewald
 * @see LaunchFrame
 */
public class LancementListener implements ActionListener {

	/**
	 * La LaunchFrame servant à récupérer les caractéristiques de la partie, quis eront passées au modèle et au contrôleur
	 * @see LaunchFrame
	 */
	private LaunchFrame myframe;
	/**
	 * Un booléen représentant le choix de l'utilisateur, concernant un affichage graphique (true) ou console (false)
	 */
	private boolean graphismes;
	/**
	 * Un booléen représentant si le mode 1v1 Humain vs Machine a été sélectionné (true) ou non (false)
	 */
	private boolean iaEnabled;
	
	/**
	 * Constructeur du LancementListener
	 * @param launchFrame la LaunchFrame pour récupérer les paramètres de la partie
	 * @param graph le booléen pour récuperer le mode d'affichage de la partie
	 * @param iaisEnabled le booléen pour activer ou non l'IA
	 * @see LaunchFrame
	 */
	public LancementListener(LaunchFrame launchFrame, boolean graph, boolean iaisEnabled) {
		myframe = launchFrame;
		graphismes = graph;
		iaEnabled = iaisEnabled;
	}

	/**
	 * Méthode qui va instancier les contrôleurs et le modèle nécéssaire pour permettre une partie, en focntion des paramètres spécifiés
	 * par l'utilisateur dans la GameFrame et la LaunchFrame. Lance ensuite la partie
	 * @see LaunchFrame
	 * @see GameFrame
	 * @see Jeu
	 */
	public void actionPerformed(ActionEvent e) {
		if (iaEnabled) {
			Joueur[] mesjoueurs = new Joueur[2];
			Joueur j1 = new Joueur('O', Color.GREEN);
			IA ia = new IA('X', myframe.getDifficulty());
			ia.setJSuivant(j1); j1.setJSuivant(ia);
			mesjoueurs[0] = j1;	mesjoueurs[1] = ia;
			Jeu jeu = new Jeu(graphismes, myframe.getNewLignes(), myframe.getNewColonnes(), myframe.getNewObjectif(), mesjoueurs, iaEnabled, ia);
			if (!graphismes) {jeu.jouer(iaEnabled);}
			myframe.dispose();
		}
		else {
			Joueur[] mesjoueurs = new Joueur[myframe.getNbJoueurs()];
			int indice = 0;
			Joueur[] tabj = myframe.getTabJoueur();
			for (int i = 0; i < myframe.getNbJoueurs(); i ++) {
				if (tabj[i] != null) {mesjoueurs[indice] = tabj[i]; indice++;}
			}
			Jeu jeu = new Jeu(graphismes, myframe.getNewLignes(), myframe.getNewColonnes(), myframe.getNewObjectif(), mesjoueurs, iaEnabled, null);
			if (!graphismes) {jeu.jouer(iaEnabled);}
			myframe.dispose();
		}
	}

}

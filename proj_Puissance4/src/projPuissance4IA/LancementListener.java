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
	 * La LaunchFrame servant � r�cup�rer les caract�ristiques de la partie, quis eront pass�es au mod�le et au contr�leur
	 * @see LaunchFrame
	 */
	private LaunchFrame myframe;
	/**
	 * Un bool�en repr�sentant le choix de l'utilisateur, concernant un affichage graphique (true) ou console (false)
	 */
	private boolean graphismes;
	/**
	 * Un bool�en repr�sentant si le mode 1v1 Humain vs Machine a �t� s�lectionn� (true) ou non (false)
	 */
	private boolean iaEnabled;
	
	/**
	 * Constructeur du LancementListener
	 * @param launchFrame la LaunchFrame pour r�cup�rer les param�tres de la partie
	 * @param graph le bool�en pour r�cuperer le mode d'affichage de la partie
	 * @param iaisEnabled le bool�en pour activer ou non l'IA
	 * @see LaunchFrame
	 */
	public LancementListener(LaunchFrame launchFrame, boolean graph, boolean iaisEnabled) {
		myframe = launchFrame;
		graphismes = graph;
		iaEnabled = iaisEnabled;
	}

	/**
	 * M�thode qui va instancier les contr�leurs et le mod�le n�c�ssaire pour permettre une partie, en focntion des param�tres sp�cifi�s
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

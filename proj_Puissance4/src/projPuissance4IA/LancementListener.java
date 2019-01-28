package projPuissance4IA;

import java.awt.Color;
import java.awt.event.*;

public class LancementListener implements ActionListener {

	private LaunchFrame myframe;
	private boolean graphismes;
	private boolean iaEnabled;
	public LancementListener(LaunchFrame launchFrame, boolean graph, boolean iaisEnabled) {
		myframe = launchFrame;
		graphismes = graph;
		iaEnabled = iaisEnabled;
	}

	@Override
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

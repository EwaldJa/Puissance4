package projPuissance4;

import java.awt.event.*;

public class LancementListener implements ActionListener {

	private LaunchFrame myframe;

	public LancementListener(LaunchFrame launchFrame) {
		myframe = launchFrame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		boolean graphismes = true;
		Joueur[] mesjoueurs = new Joueur[myframe.getNbJoueurs()];
		int indice = 0;
		Joueur[] tabj = myframe.getTabJoueur();
		for (int i = 0; i < myframe.getNbJoueurs(); i ++) {
			if (tabj[i] != null) {mesjoueurs[indice] = tabj[i]; indice++;}
		}
		Jeu jeu = new Jeu(graphismes, myframe.getNewLignes(), myframe.getNewColonnes(), myframe.getNewObjectif(), mesjoueurs);
		if (!graphismes) {jeu.jouer();}
		myframe.dispose();
	}

}

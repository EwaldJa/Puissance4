package projPuissance4IA;

import java.awt.Color;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RejouerListener implements ActionListener {
	
	private Jeu jeu;
	private Frame myframe;
	private boolean iaEnabled;

	public RejouerListener(Frame frame, Jeu jeu, boolean iaisEnabled) {
		this.jeu = jeu;
		myframe = frame;
		iaEnabled = iaisEnabled;
	}

	@Override
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
		myframe.dispose();
	}

}

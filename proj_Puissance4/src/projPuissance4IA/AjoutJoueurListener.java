package projPuissance4IA;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class AjoutJoueurListener implements ActionListener {

	private LaunchFrame myframe;
	private int joueurCourant;
	private int[] couleursChoisies = new int[10];
	private boolean iaEnabled;

	public AjoutJoueurListener(LaunchFrame launchFrame, boolean iaisEnabled) {
		iaEnabled = iaisEnabled;
		myframe = launchFrame;
		joueurCourant = 9;
		Arrays.fill(couleursChoisies, -1);
	}

	public void actionPerformed(ActionEvent arg0) {
		if (iaEnabled) {
			Choice tabchoix = myframe.getChoixCouleur();
			int choix = tabchoix.getSelectedIndex();
			myframe.setDifficulty(trouverDifficulte(choix));
		}
		else {
			if (joueurCourant >= 0) {
				Choice tabchoix = myframe.getChoixCouleur();
				int choix = tabchoix.getSelectedIndex();
				if (choix == -1) {choix = 0;}
				if (verifCouleur(choix)) {new FrameCouleurPrise(tabchoix.getSelectedItem());}
				else {
					couleursChoisies[9-joueurCourant] = choix;
					char newmotif = myframe.getNewMotif();
					Label[][] liste = myframe.getListeJoueurs();
					liste[9-joueurCourant][0].setText(Integer.toString(10-joueurCourant));
					liste[9-joueurCourant][1].setText(Character.toString(newmotif));
					liste[9-joueurCourant][2].setText(myframe.getTabColor().get(choix));
					Color newcouleur = trouverCouleur(choix);
					Joueur newj = new Joueur(newmotif, newcouleur);
					Joueur[] tabj = myframe.getTabJoueur();
					tabj[9-joueurCourant] = newj;
					joueurCourant--;
					myframe.setTabJoueur(tabj);
					myframe.setNbJoueurs(myframe.getNbJoueurs() + 1);
				}
			}
			else {new FrameJoueursPleins();}	
		}
	}
	
	public boolean verifCouleur(int choix) {
		for(int i=0; i < couleursChoisies.length; i++) {
			if (couleursChoisies[i] == choix) {
				return true;
			}
		}
		return false;
	}
	
	public Color trouverCouleur(int indice) {
		ArrayList<String> tabcolor = myframe.getTabColor();
		switch (tabcolor.get(indice)) {
			case"Rouge":
				return Color.RED;
			case"Jaune":
				return Color.YELLOW;
			case"Cyan":
				return Color.CYAN;
			case"Vert":
				return Color.GREEN;
			case"Orange":
				return Color.ORANGE;
			case"Bleu":
				return Color.BLUE;
			case"Noir":
				return Color.BLACK;
			case"Magenta":
				return Color.MAGENTA;
			case"Rose":
				return Color.PINK;
			case"Blanc":
				return Color.WHITE;
			default:
				return Color.DARK_GRAY;
		}
	}
	
	public int trouverDifficulte(int indice) {
		ArrayList<String> tabdiff = myframe.getTabDiff();
		switch (tabdiff.get(indice)) {
			case"Facile":
				return 1;
			case"Moyen":
				return 2;
			case"Difficile":
				return 3;
			case"Hardcore":
				return 5;
			default:
				return 1;
		}
	}

}

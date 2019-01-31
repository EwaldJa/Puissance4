package projPuissance4;

import java.awt.*;
import java.awt.event.*;
import java.util.*;

/**
 * Cette classe est un �couteur d'un bouton sur une instance de la frame LaunchFrame. Appel� � chaque clic
 * sur ce bouton, il permet d'ajouter des joueurs � la liste des joueurs qui participeront � la partie, dans
 * la limite de 10 joueurs (pour une question de visualisation des joueurs sur la grille).
 * Dans le cas d'une partie 1v1 Joueur versus IA, ce Listener a une autre fonction, celle de valider le choix 
 * du niveau de difficult� de l'IA.
 * 
 * @see LaunchFrame
 * 
 * @author Ewald
 */
public class AjoutJoueurListener implements ActionListener {

	/**
	 * Frame de param�trage de la partie, permet de lui passer et de r�cup�rer certaines valeurs
	 * 
	 * @see LaunchFrame
	 */
	private LaunchFrame myframe;
	
	/**
	 * Symbolise le joueur en cours d'ajout dans le tableau des joueurs
	 * 
	 * @see LaunchFrame
	 * @see Joueur
	 */
	private int joueurCourant;
	
	/**
	 * Tableau permettant de v�rifier si la couleur a d�j� �t� choisie pour un Joueur
	 * 
	 * @see AjoutJoueurListener#verifCouleur
	 */
	private int[] couleursChoisies = new int[10];
	
	/**
	 * Bool�en symbolisant si le mode 1v1 joueur vs IA est activ� ou non
	 */
	private boolean iaEnabled;

	/**
	 * Constructeur du AjoutJoueurListener 
	 * 
	 * @param launchFrame la frame servant au param�trage de la partie
	 * @param iaisEnabled le bool�en qui permet de savoir si l'ia est activ�e (true) ou non (false)
	 */
	public AjoutJoueurListener(LaunchFrame launchFrame, boolean iaisEnabled) {
		iaEnabled = iaisEnabled;
		myframe = launchFrame;
		joueurCourant = 9;
		Arrays.fill(couleursChoisies, -1);
	}

	/**
	 * M�thode appel�e au clic sur le bouton d'ajout de joueur/validation de difficult� de l'IA
	 * 
	 * Permet de valider le choix de difficult� de l'IA, ou d'ajouter un joueur au tableau des joueurs de la partie 
	 */
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
	
	/**
	 * V�rifie si l'indice pass� en param�tre a d�j� �t� choisi (donc pr�sent dans le tableau)
	 * 
	 * @param choix indice correspondant � une couleur choisie sur la LaunchFrame
	 * @return un bool�en vrai si la couleur est d�j� prise, faux sinon
	 * @see LaunchFrame
	 * @see AjoutJoueurListener#couleursChoisies
	 */
	public boolean verifCouleur(int choix) {
		for(int i=0; i < couleursChoisies.length; i++) {
			if (couleursChoisies[i] == choix) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * M�thode permettant de r�cuperer une couleur gr�ce � la chaine s�l�ectionn�e dans la LaunchFrame
	 * 
	 * @param indice correspondant � une couleur s�lectionn�e dans le LaunchFrame
	 * @return la couleur correspondante
	 * @see LaunchFrame
	 * @see LaunchFrame#tabcolor
	 * @see Color
	 */
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
	
	/**
	 * M�thode permettant de r�cuperer un entier correspondant � une niveau de difficult� de l'IA
	 *  gr�ce � la chaine s�lectionn�e dans la LaunchFrame
	 * 
	 * @param indice correspondant � une difficult�e s�lectionn�e dans le LaunchFrame
	 * @return la couleur correspondante
	 * @see LaunchFrame
	 * @see LaunchFrame#tabdifficulte
	 */
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

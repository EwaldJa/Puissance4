package puissance4;

import java.awt.Color;

public class Main {

	public static void main(String[] args) throws Exception {
		Grille grille = new Grille();
		Jeu monjeu = new Jeu(new Joueur("Joueur 1", 'X'), new Joueur("Joueur2", 'O'), grille);
		//grille.affichage();
		grille.placerPion(5, new Pion(Color.RED, 'X'));
		grille.affichage();
	
	}

}

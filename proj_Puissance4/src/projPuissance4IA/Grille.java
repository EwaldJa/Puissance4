package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe est le modèle du jeu. Elle contient une matrice de pions, ainsi que toutes les méthodes
 * nécéssaires au jeu : vérification de victoire, de match nul, ajout de pions...
 * 
 * @author Ewald
 */
public class Grille {
	
	/**
	 * La matrice de pions, le 'corps' du jeu de puissance4. Dimension : (colonnes, lignes)
	 * @see Pion
	 */
	private Pion[][] grille;
	
	/**
	 * Les caractéristiques de la partie
	 */
	private int nb_ligne, nb_colonne, alignement;
	
	/**
	 * Les valeurs par défaut, pour des parties standard
	 */
	public static final int DEFAULT_LIGNE = 6, DEFAULT_COLONNE = 7, DEFAULT_ALIGNEMENT = 4;
	
	/**
	 * Entier mémorisant la dernière colonne qui a été jouée
	 */
	private int derniereColonne;
	
	/**
	 * Dernier joueur ayant placé un pion, utile à l'IA
	 * @see Joueur
	 */
	private Joueur dernierJoueur;
	
	/**
	 * Constructeur par défaut de la grille
	 */
	public Grille() {
		this(DEFAULT_COLONNE, DEFAULT_LIGNE, DEFAULT_ALIGNEMENT);
	}
	
	/**
	 * Constructeur avec des dimensions personnalisées
	 * @param colonne nombre de colonnes personnalisé
	 * @param ligne nombre de lignes personnalisé
	 */
	public Grille(int colonne, int ligne) {
		this(colonne, ligne, DEFAULT_ALIGNEMENT);
	}
	
	/**
	 * Constructeur avec toutes les caractéristiques de la partie personnalisées
	 * @param colonne nombre de colonnes personnalisé
	 * @param ligne nombre de lignes personnalisé
	 * @param align noombre de pions à aligner pour gagner
	 */
	public Grille(int colonne, int ligne, int align) {
		grille = new Pion[colonne][ligne];
		this.nb_colonne=colonne;
		this.nb_ligne=ligne;
		for(int col = 0; col < nb_colonne; col++) {
			for(int lig = 0; lig < nb_ligne; lig++) {
				 grille[col][lig]= new Pion(' ', Color.LIGHT_GRAY);
			}
		}
		alignement = align;
	}
	
	/**
	 * Méthode permettant d'ajouter un Pion à la grille, lève une exception personnalisée en cas de colonne non-valide ou de colonne pleine.
	 * 
	 * @param colonne colonne dans laquelle le joueur souhaite placer un Pion
	 * @param j Joueur actuel
	 * @return un booléen représentant l'état de la partie, true si gagnée, false sinon
	 * @throws HorsPlateauException en cas de numéro de colonne non-valide
	 * @throws ColonnePleineException en cas de colonne remplie
	 * @see Pion
	 * @see Joueur
	 * @see Grille#grille
	 */
	public boolean AjouterPion(int colonne, Joueur j) throws HorsPlateauException,ColonnePleineException {
		int ligne = nb_ligne-1;
		if(colonne>nb_colonne-1 || colonne<0) {
				throw new HorsPlateauException(colonne);
		}
		else {
			while(!(grille[colonne][ligne].getMotif() == ' ')) {
				ligne--;
				if(ligne == -1) {
					throw new ColonnePleineException(colonne);
				}
			}
		}
		grille[colonne][ligne] = j.getPion();
		this.derniereColonne = colonne;
		this.dernierJoueur = j;
		return verifGagne(colonne, ligne, j.getCouleur());
	}
	
	/**
	 * Cette méthode permet de cloner la Grille actuelle, utile pour l'IA afin de ne pas modifier la Grille actuelle mais de
	 * pouvoir simuler ses coups. Associe chque motif et chaque couleur de la Grille actuelle aux positions correspondantes
	 * dans le clone.
	 * 
	 * @return un clone de la Grille actuelle
	 * @see Grille
	 */
	public Grille clone() {
		Grille g= new Grille(nb_colonne,nb_ligne);
		for(int i=0;i<nb_ligne;i++) {
			for(int j=0;j<nb_colonne;j++) {
				g.getPion(i,j).setMotif(this.getPion(i,j).getMotif());
				g.getPion(i,j).setCouleur(this.getPion(i,j).getCouleur());
			}
		}
		return g;
	}
	
	/**
	 * Calcule la hauteur du Pion le plus haut d'une colonne donnée
	 * 
	 * @param colonne
	 * @return la hauteur du pion le plus haut de la colonne, en indices 'vision joueur'
	 * @see Pion
	 */
	public int getHeight(int colonne) {
		int cpt=0;
		for(int i=0;i<nb_ligne;i++) {
			if(grille[colonne][nb_ligne-1-i].getMotif() != ' ') {
				cpt++;
			}
			else {
				return cpt;
			}
		}
		return cpt;
	}
	
	/**
	 * Vérifie si le joueur dont la couleur est passée en paramètre a gagné la partie
	 * 
	 * @param colonne colonne dans laquelle le joueur a joué
	 * @param ligne ligne à laquelle le Pion du joueur a été placé
	 * @param couleur du Joueur dont on souhaite vérifier si il a gagné
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #verifGagne(Joueur)
	 * @see #verifGagne()
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean verifGagne(int colonne, int ligne, Color couleur) {
		return (ligneGagnee(colonne, ligne, couleur) || colonneGagnee(colonne, ligne, couleur) || diagGagnee(colonne, ligne, couleur) || antiDiagGagnee(colonne, ligne, couleur));
	}
	
	/**
	 * Cette méthode vérifie dans toute la grille si le joueur passé en paramètre a gagné. Utilise la méthode verifGagne(int colonne, int ligne, Color couleur).
	 * @param player Joueur dont on souhaite vérifier s'il a gagné
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #verifGagne(int, int, Color)
	 * @see #verifGagne()
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean verifGagne(Joueur player) {
		for(int i=0;i<nb_ligne;i++) {
			for(int j=0;j<nb_colonne;j++) {
				if (verifGagne(j, i, player.getCouleur())) {
					return true;
				}
			}
		}
		return false;
	}
	
	/**
	 * Cette méthode vérifie dans toute la grille si le dernier joueur ayant placé un Pion a gagné. Utilise la méthode verifGagne(Joueur player)
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #verifGagne(int, int, Color)
	 * @see #verifGagne(Joueur)
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean verifGagne() {
		return (verifGagne(dernierJoueur));
	}
	
	/**
	 * Cette méthode vérifie si le joueur dont la couleur est passée en paramètre a gagné dans la ligne passée en paramètre
	 * @param colonnejouee colonne dans laquelle on souhaite vérifier la victoire
	 * @param lignejouee ligne dans laquelle on souhaite vérifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite vérifier la victoire
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean ligneGagnee(int colonnejouee, int lignejouee, Color couleur) {
		int colonne = colonnejouee;
		int ligne = lignejouee;
		int compteur = 0;
		if (colonne != 0) {
			while(grille[colonne-1][ligne].getCouleur() == couleur) {
				colonne--;
				if(colonne == 0) {
					break;
				}
			}
		}
		while (grille[colonne][ligne].getCouleur() == couleur) {
			colonne ++;
			compteur ++;
			if (compteur == alignement) {
				return true;
			}
			if (colonne == nb_colonne) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Cette méthode vérifie si le joueur dont la couleur est passée en paramètre a gagné dans la colonne passée en paramètre
	 * @param colonnejouee colonne dans laquelle on souhaite vérifier la victoire
	 * @param lignejouee ligne dans laquelle on souhaite vérifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite vérifier la victoire
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #ligneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean colonneGagnee(int colonnejouee, int lignejouee, Color couleur) {
		int colonne = colonnejouee;
		int ligne = lignejouee;
		int compteur = 0;
		if (ligne != 0) {
			while(grille[colonne][ligne-1].getCouleur() == couleur) {
				ligne--;
				if(ligne == 0) {
					break;
				}
			}
		}
		while (grille[colonne][ligne].getCouleur() == couleur) {
			ligne ++;
			compteur ++;
			if (compteur == alignement) {
				return true;
			}
			if (ligne == nb_ligne) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Cette méthode vérifie si le joueur dont la couleur est passée en paramètre a gagné dans la diagonale correspondant à la ligne et
	 * à la colonne passées en paramètre
	 * @param colonnejouee colonne correspondant à la diagonale dans laquelle on souhaite vérifier la victoire
	 * @param lignejouee ligne correspondant à la diagonale dans laquelle on souhaite vérifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite vérifier la victoire
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean diagGagnee(int colonnejouee, int lignejouee, Color couleur) {
		int colonne = colonnejouee;
		int ligne = lignejouee;
		int compteur = 0;
		if ((colonne != 0) && (ligne != 0)) {
			while(grille[colonne-1][ligne-1].getCouleur() == couleur) {
				ligne--;
				colonne--;
				if ((ligne == 0) || (colonne == 0)) {
					break;
				}
			}
		}
		while (grille[colonne][ligne].getCouleur() == couleur) {
			compteur++;
			colonne++;
			ligne++;
			if (compteur == alignement) {
				return true;
			}
			if ((colonne == nb_colonne) || (ligne == nb_ligne)) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Cette méthode vérifie si le joueur dont la couleur est passée en paramètre a gagné dans l'antidiagonale correspondant à la ligne et
	 * à la colonne passées en paramètre
	 * @param colonnejouee colonne correspondant à l'antidiagonale dans laquelle on souhaite vérifier la victoire
	 * @param lignejouee ligne correspondant à l'antidiagonale dans laquelle on souhaite vérifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite vérifier la victoire
	 * @return un booléen valant true si le joueur a gagné, false sinon
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 */
	public boolean antiDiagGagnee(int colonnejouee, int lignejouee, Color couleur) {
		int colonne = colonnejouee;
		int ligne = lignejouee;
		int compteur = 0;
		if ((colonne != 0) && (ligne != (nb_ligne-1))) {
			while(grille[colonne-1][ligne+1].getCouleur() == couleur) {
				ligne++;
				colonne--;
				if ((ligne == (nb_ligne-1)) || (colonne == 0)) {
					break;
				}
			}
		}
		while (grille[colonne][ligne].getCouleur() == couleur) {
			compteur ++;
			colonne++;
			ligne--;
			if (compteur == alignement) {
				return true;
			}
			if ((colonne == nb_colonne) || (ligne == -1)) {
				return false;
			}
		}
		return false;
	}
	
	/**
	 * Méthode vérifiant si la partie actuelle est nulle, c'est à dire que toutes les cases sont remplies
	 * @return un booléen valant true si la partie est nulle, false sinon
	 */
	public boolean matchNul() {
		for(int i=0;i<nb_ligne;i++) {
			if (getHeight(i) != nb_ligne) {
				return false;
			}
		}
		return true;
	}
	/**
	 * Méthode vérifiant si la partie est terminée, c'est à dore si elle est nulle ou gagnée.
	 * 
	 * @return un booléen valant true si la partie est terminée, false sinon
	 * @see #verifGagne(int, int, Color)
	 * @see #verifGagne(Joueur)
	 * @see #verifGagne()
	 * @see #ligneGagnee(int, int, Color)
	 * @see #colonneGagnee(int, int, Color)
	 * @see #diagGagnee(int, int, Color)
	 * @see #antiDiagGagnee(int, int, Color)
	 */
	public boolean over() {
		return (matchNul() || verifGagne());
	}
	
	public int getNbLigne() {
		return nb_ligne;
	}
	public int getNbColonne() {
		return nb_colonne;
	}
	public int getAlignement() {
		return alignement;
	}
	public Pion getPion(int ligne, int colonne) {
		return grille[colonne][ligne];
	}
	public int getDerniereColonne() {
		return this.derniereColonne;
	}
	
	/**
	 * Méthode standard toString() permettant l'affichage console de l'état de la grille de Pion
	 * @return une String représentant la grille
	 * @see #grille
	 * @see Pion
	 */
	public String toString() {
		String s = "";
		for(int lig = 0; lig < nb_ligne; lig++) {
			s+="|";
			for(int col = 0; col < nb_colonne; col++) {
				s+= grille[col][lig].getMotif() + "|";
			}
			s+="\n";
		}
		for(int col = 0; col < nb_colonne; col++) {
			s+="__";
		}
		s+="\n ";
		for(int col = 0; col < nb_colonne; col++) {
			s+=(col+1)+" ";
		}
		return s;
	}

}

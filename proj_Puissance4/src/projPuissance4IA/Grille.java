package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe est le mod�le du jeu. Elle contient une matrice de pions, ainsi que toutes les m�thodes
 * n�c�ssaires au jeu : v�rification de victoire, de match nul, ajout de pions...
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
	 * Les caract�ristiques de la partie
	 */
	private int nb_ligne, nb_colonne, alignement;
	
	/**
	 * Les valeurs par d�faut, pour des parties standard
	 */
	public static final int DEFAULT_LIGNE = 6, DEFAULT_COLONNE = 7, DEFAULT_ALIGNEMENT = 4;
	
	/**
	 * Entier m�morisant la derni�re colonne qui a �t� jou�e
	 */
	private int derniereColonne;
	
	/**
	 * Dernier joueur ayant plac� un pion, utile � l'IA
	 * @see Joueur
	 */
	private Joueur dernierJoueur;
	
	/**
	 * Constructeur par d�faut de la grille
	 */
	public Grille() {
		this(DEFAULT_COLONNE, DEFAULT_LIGNE, DEFAULT_ALIGNEMENT);
	}
	
	/**
	 * Constructeur avec des dimensions personnalis�es
	 * @param colonne nombre de colonnes personnalis�
	 * @param ligne nombre de lignes personnalis�
	 */
	public Grille(int colonne, int ligne) {
		this(colonne, ligne, DEFAULT_ALIGNEMENT);
	}
	
	/**
	 * Constructeur avec toutes les caract�ristiques de la partie personnalis�es
	 * @param colonne nombre de colonnes personnalis�
	 * @param ligne nombre de lignes personnalis�
	 * @param align noombre de pions � aligner pour gagner
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
	 * M�thode permettant d'ajouter un Pion � la grille, l�ve une exception personnalis�e en cas de colonne non-valide ou de colonne pleine.
	 * 
	 * @param colonne colonne dans laquelle le joueur souhaite placer un Pion
	 * @param j Joueur actuel
	 * @return un bool�en repr�sentant l'�tat de la partie, true si gagn�e, false sinon
	 * @throws HorsPlateauException en cas de num�ro de colonne non-valide
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
	 * Cette m�thode permet de cloner la Grille actuelle, utile pour l'IA afin de ne pas modifier la Grille actuelle mais de
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
	 * Calcule la hauteur du Pion le plus haut d'une colonne donn�e
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
	 * V�rifie si le joueur dont la couleur est pass�e en param�tre a gagn� la partie
	 * 
	 * @param colonne colonne dans laquelle le joueur a jou�
	 * @param ligne ligne � laquelle le Pion du joueur a �t� plac�
	 * @param couleur du Joueur dont on souhaite v�rifier si il a gagn�
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie dans toute la grille si le joueur pass� en param�tre a gagn�. Utilise la m�thode verifGagne(int colonne, int ligne, Color couleur).
	 * @param player Joueur dont on souhaite v�rifier s'il a gagn�
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie dans toute la grille si le dernier joueur ayant plac� un Pion a gagn�. Utilise la m�thode verifGagne(Joueur player)
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie si le joueur dont la couleur est pass�e en param�tre a gagn� dans la ligne pass�e en param�tre
	 * @param colonnejouee colonne dans laquelle on souhaite v�rifier la victoire
	 * @param lignejouee ligne dans laquelle on souhaite v�rifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite v�rifier la victoire
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie si le joueur dont la couleur est pass�e en param�tre a gagn� dans la colonne pass�e en param�tre
	 * @param colonnejouee colonne dans laquelle on souhaite v�rifier la victoire
	 * @param lignejouee ligne dans laquelle on souhaite v�rifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite v�rifier la victoire
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie si le joueur dont la couleur est pass�e en param�tre a gagn� dans la diagonale correspondant � la ligne et
	 * � la colonne pass�es en param�tre
	 * @param colonnejouee colonne correspondant � la diagonale dans laquelle on souhaite v�rifier la victoire
	 * @param lignejouee ligne correspondant � la diagonale dans laquelle on souhaite v�rifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite v�rifier la victoire
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * Cette m�thode v�rifie si le joueur dont la couleur est pass�e en param�tre a gagn� dans l'antidiagonale correspondant � la ligne et
	 * � la colonne pass�es en param�tre
	 * @param colonnejouee colonne correspondant � l'antidiagonale dans laquelle on souhaite v�rifier la victoire
	 * @param lignejouee ligne correspondant � l'antidiagonale dans laquelle on souhaite v�rifier la victoire
	 * @param couleur couleur du Joueur dont on souhaite v�rifier la victoire
	 * @return un bool�en valant true si le joueur a gagn�, false sinon
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
	 * M�thode v�rifiant si la partie actuelle est nulle, c'est � dire que toutes les cases sont remplies
	 * @return un bool�en valant true si la partie est nulle, false sinon
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
	 * M�thode v�rifiant si la partie est termin�e, c'est � dore si elle est nulle ou gagn�e.
	 * 
	 * @return un bool�en valant true si la partie est termin�e, false sinon
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
	 * M�thode standard toString() permettant l'affichage console de l'�tat de la grille de Pion
	 * @return une String repr�sentant la grille
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

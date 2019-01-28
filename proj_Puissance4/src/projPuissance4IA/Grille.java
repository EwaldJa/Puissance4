package projPuissance4IA;

import java.awt.Color;

public class Grille {
	private Pion[][] grille;
	private int nb_ligne, nb_colonne, alignement;
	public static final int DEFAULT_LIGNE = 6, DEFAULT_COLONNE = 7, DEFAULT_ALIGNEMENT = 4;
	private int derniereColonne;
	private Joueur dernierJoueur;
	
	public Grille() {
		this(DEFAULT_COLONNE, DEFAULT_LIGNE, DEFAULT_ALIGNEMENT);
	}
	
	public Grille(int colonne, int ligne) {
		this(colonne, ligne, DEFAULT_ALIGNEMENT);
	}
	
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
	 * Associe chaque motif et chaque couleur avec celui de la grille a cloner
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
	 * Retourne la hauteur du pion le plus haut de la colonne
	 * 
	 * @param colonne
	 * @return
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
	
	public boolean verifGagne(int colonne, int ligne, Color couleur) {
		return (ligneGagnee(colonne, ligne, couleur) || colonneGagnee(colonne, ligne, couleur) || diagGagnee(colonne, ligne, couleur) || antiDiagGagnee(colonne, ligne, couleur));
	}
	
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
	
	public boolean verifGagne() {
		return (verifGagne(dernierJoueur));
	}
	
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
	
	public boolean matchNul() {
		for(int i=0;i<nb_ligne;i++) {
			if (getHeight(i) != nb_ligne) {
				return false;
			}
		}
		return true;
	}
	
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

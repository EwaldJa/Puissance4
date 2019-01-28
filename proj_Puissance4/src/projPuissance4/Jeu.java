package projPuissance4;

import java.io.PrintStream;

/**
 * Cette classe fait partie du contr�leur du jeu.
 * 
 *
 */
public class Jeu {

	/**
	 * Mod�le du jeu
	 * 
	 * @see Grille
	 */
	private Grille grille;
	
	/**
	 * Entier permettant de savoir de quel joueur est-ce le tour
	 */
	private int flag;
	
	/**
	 * Notre tableau des diff�rents joueurs
	 * 
	 * @see Joueur
	 */
	private Joueur[] tabjoueurs;
	
	/**
	 * Notre vue, qui sera une instance soit graphique soit console
	 * 
	 * @see Vue
	 * @see VueGrahphique
	 * @see VueConsole
	 */
	private Vue vue;
	
	/**
	 * Constructeur qui demande aux joueurs les diff�rents param�tres du jeu via la console
	 * vueGraph est un bool�en qui d�cide de la vue graphique (true) ou console (false)
	 * 
	 * @param vueGraph
	 */
	public Jeu(boolean vueGraph) {
		System.out.println("Veuillez choisir la hauteur de la grille :");
		int ligne= ClavierReader.getInt();
		if(ligne < 4) {ligne = 4;}
		System.out.println("Veuillez maintenant choisir la largeur de la grille :");
		int colonne = ClavierReader.getInt();
		this.grille= new Grille(colonne, ligne);
		System.out.println("Choisissez le nombre de joueurs :");
		int nbj = ClavierReader.getInt();
		tabjoueurs = new Joueur[nbj];
		this.flag=0;
		for (int i = 0; i < nbj; i++) {
			System.out.println("Veuillez choisir votre motif joueur " + (i+1) + ": \n (Il s'ag�t d'un charact�re)\n");

			char c = ClavierReader.getChar();
			tabjoueurs[i]=new Joueur(c);
		}
		if (vueGraph) {
			vue = new VueGraphique(this);
		}
		else {
			vue = new VueConsole(this);
		}
	}
	
	/**
	 * Constructeur dont tous les param�tres de jeu sont pass�s � l'appel, utile � la Vue Graphique
	 * 
	 * @param vueGraph
	 * @param lignes
	 * @param colonnes
	 * @param align
	 * @param tabj
	 */
	public Jeu(boolean vueGraph, int lignes, int colonnes, int align, Joueur[] tabj) {
		if(lignes < 4) {lignes = 4;}
		grille = new Grille(colonnes, lignes, align);
		tabjoueurs = tabj;
		if (vueGraph) {
			vue = new VueGraphique(this);
		}
		else {
			vue = new VueConsole(this);
		}
		flag = 0;
	}

	/**
	 * M�thode de jeu 
	 * 
	 * @return
	 */
	public boolean update() {
		int col = -1;
		try {
			vue.afficher();
			System.out.println("Dans quelle colonne voulez vous jouer, Joueur " + (flag+1) + " ? \n");
			col = ClavierReader.getInt();
			
			if( grille.AjouterPion(col-1, tabjoueurs[flag]) ) {
				vue.afficher();
				System.out.println("F�licitations, Joueur " + (flag+1) + ", vous venez de gagner la partie !");
				return true;
			}
			else {
					flag++;
			}
			if(flag == tabjoueurs.length) {
				flag = 0;
			}
			vue.afficher();
			viderAffichage(System.out);
			
		} catch(HorsPlateauException e) {
			viderAffichage(System.out);
			System.out.println(e.getMessage());
		} catch(ColonnePleineException e) {
			viderAffichage(System.out);
			System.out.println(e.getMessage());
		} catch(Exception e) {
			viderAffichage(System.out);
			e.printStackTrace();
		} 
		return false;
	}
	

	public boolean updateGraphique(int col) {
		try {
			vue.afficher();			
			if( grille.AjouterPion(col-1, tabjoueurs[flag]) ) {
				vue.afficher();
				return true;
			}
			else {
					flag++;
			}
			if(flag == tabjoueurs.length) {
				flag = 0;
			}
			vue.afficher();
			
		} catch(HorsPlateauException e) {
			new FrameErreur(e.getMessage());
			//System.out.println(e.getMessage());
		} catch(ColonnePleineException e) {
			new FrameErreur(e.getMessage());
			//System.out.println(e.getMessage());
		} catch(Exception e) {
			new FrameErreur(e.getMessage());
			//e.printStackTrace();
		} 
		return false;
	}
	
	private void viderAffichage(PrintStream ps) {
		for (int i = 0; i < 50; i++) {
			ps.println();
		}
	}
	public boolean jouer() {
		if (vue instanceof VueConsole) {while(!update()) {} return true;}
		return false;
	}
	public void dispose() {
		vue.dispose();
	}
	public Grille getGrille() {
		return grille;
	}
	public void SetGrille(Grille g, int f, Joueur[] tabj) {
		grille= g;
		flag=f;
		tabjoueurs = tabj;
	}
	public int getFlag() {
		return flag;
	}
	public Joueur[] getTabJoueurs() {
		return tabjoueurs;
	}
	public int getLignes() {
		return grille.getNbLigne();
	}
	public int getColonnes() {
		return grille.getNbColonne();
	}
	public int getAlignement() {
		return grille.getAlignement();
	}
	public boolean getGraphismes() {
		return (vue instanceof VueGraphique);
	}
}

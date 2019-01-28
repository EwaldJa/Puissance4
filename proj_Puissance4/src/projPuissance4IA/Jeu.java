package projPuissance4IA;

import java.io.PrintStream;

/**
 * Cette classe fait partie du contrôleur du jeu.
 * 
 *
 */
public class Jeu {

	/**
	 * Modèle du jeu
	 * 
	 * @see Grille
	 */
	private Grille grille;
	
	/**
	 * Entier permettant de savoir de quel joueur est-ce le tour
	 */
	private int flag;
	
	/**
	 * Notre tableau des différents joueurs
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
	 * IA pour jeu Joueur vs Ordinateur 1v1
	 * 
	 * @see IA
	 */
	private IA ia;
	
	/**
	 * Constructeur qui demande aux joueurs les différents paramètres du jeu via la console
	 * vueGraph est un booléen qui décide de la vue graphique (true) ou console (false)
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
			System.out.println("Veuillez choisir votre motif joueur " + (i+1) + ": \n (Il s'agît d'un charactère)\n");

			char c = ClavierReader.getChar();
			tabjoueurs[i]=new Joueur(c);
		}
		if (vueGraph) {
			vue = new VueGraphique(this, false);
		}
		else {
			vue = new VueConsole(this);
		}
	}
	
	/**
	 * Constructeur dont tous les paramètres de jeu sont passés à l'appel, utile à la Vue Graphique
	 * 
	 * @param vueGraph
	 * @param lignes
	 * @param colonnes
	 * @param align
	 * @param tabj
	 */
	public Jeu(boolean vueGraph, int lignes, int colonnes, int align, Joueur[] tabj, boolean iaEnabled, IA ia) {
		if(lignes < 4) {lignes = 4;}
		grille = new Grille(colonnes, lignes, align);
		tabjoueurs = tabj;
		if (vueGraph) {
			vue = new VueGraphique(this, iaEnabled);
		}
		else {
			vue = new VueConsole(this);
		}
		flag = 0;
		this.ia = ia;
	}

	/**
	 * Méthode de jeu en cas de jeu console, Joueurs v Joueurs
	 * 
	 * @return un booléen qui indique si la partie est terminée (true) ou non (false)
	 */
	public boolean update() {
		int col = -1;
		try {
			vue.afficher();
			System.out.println("Dans quelle colonne voulez vous jouer, Joueur " + (flag+1) + " ? \n");
			col = ClavierReader.getInt();
			
			if( grille.AjouterPion(col-1, tabjoueurs[flag]) ) {
				vue.afficher();
				System.out.println("Félicitations, Joueur " + (flag+1) + ", vous venez de gagner la partie !");
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
	
	/**
	 * Méthode de jeu en cas de jeu graphique, Jouerus vs Joueurs
	 * La colonne dans laquelle le joueur joue est passé en paramètre par le contrôleur
	 * @param col
	 * @return un booléen qui indique si la partie est terminée (true) ou non (false)
	 * @see CanvasPuissance4KeyListener
	 * @see CanvasPuissance4MouseListener
	 */
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
		} catch(ColonnePleineException e) {
			new FrameErreur(e.getMessage());
		} catch(Exception e) {
			new FrameErreur(e.toString());
		} 
		return false;
	}
	
	public boolean updateIAConsole() {
		int col = -1;
		System.out.println(grille.toString());
		try {
			if(flag==0) {
				System.out.println("Dans quelle colonne voulez vous jouer ? \n");
				col = ClavierReader.getInt();
				if( grille.AjouterPion(col-1, tabjoueurs[flag]) ) {
					vue.afficher();
					System.out.println("Félicitations, Joueur " + (flag+1) + ", vous venez de gagner la partie !");
					return true;
				}
				else {
					flag = 1;
				}
			}
			else {
				this.SetGrille(ia.jouer(grille), 0, new Joueur[] {tabjoueurs[0], ia});
				if (grille.verifGagne()) {
					vue.afficher();
					System.out.println("Malheureusement, Joueur " + (flag+1) + ", vous venez de perdre la partie !");
					return true;
				}
			}
		} catch(HorsPlateauException e) {
			System.out.println(e.getMessage());
		} catch(ColonnePleineException e) {
			System.out.println(e.getMessage());
		} catch(Exception e) {
			viderAffichage(System.out);
			e.printStackTrace();
		}
		return false;
		
	}
	
	public boolean updateIAGraphique(int col) {
		try {
			vue.afficher();			
			if(flag==0) {
				if( grille.AjouterPion(col-1, tabjoueurs[flag]) ) {
					vue.afficher();
					return true;
				}
				else {
					vue.afficher();
					this.SetGrille(ia.jouer(grille), 1);
					vue.afficher();
					if (grille.verifGagne()) {
						vue.afficher();
						return true;
					}
					flag = 0;
				}
			}
			if(flag == tabjoueurs.length) {
				flag = 0;
			}
			vue.afficher();
			
		} catch(HorsPlateauException e) {
			new FrameErreur(e.getMessage());
		} catch(ColonnePleineException e) {
			new FrameErreur(e.getMessage());
		} catch(Exception e) {
			new FrameErreur(e.toString());
		} 
		return false;
	}
	
	private void viderAffichage(PrintStream ps) {
		for (int i = 0; i < 50; i++) {
			ps.println();
		}
	}
	public boolean jouer(boolean iaEnabled) {
		if (iaEnabled) {if (vue instanceof VueConsole) {while(!updateIAConsole()) {} return true;}return false;}
		else {if (vue instanceof VueConsole) {while(!update()) {} return true;}return false;}
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
	public void SetGrille(Grille g, int f) {
		grille= g;
		flag=f;
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

	public IA getIA() {
		return ia;
	}
}

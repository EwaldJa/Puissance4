package projPuissance4;

/**
 * Classe abstraite servant � s'assurer la pr�sence des m�thodes d'affichage et de fin selon le type de Vue (graphique ou console)
 * 
 * @author Ewald
 * @see #afficher()
 * @see VueGraphique
 * @see VueConsole
 */
public abstract class Vue {

	/**
	 * M�thode servant � afficher la grille
	 */
	public abstract void afficher();
	
	/**
	 * M�thode appel�e pour quitter le jeu
	 */
	public abstract void dispose();
}

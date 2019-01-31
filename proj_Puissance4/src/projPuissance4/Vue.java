package projPuissance4;

/**
 * Classe abstraite servant à s'assurer la présence des méthodes d'affichage et de fin selon le type de Vue (graphique ou console)
 * 
 * @author Ewald
 * @see #afficher()
 * @see VueGraphique
 * @see VueConsole
 */
public abstract class Vue {

	/**
	 * Méthode servant à afficher la grille
	 */
	public abstract void afficher();
	
	/**
	 * Méthode appelée pour quitter le jeu
	 */
	public abstract void dispose();
}

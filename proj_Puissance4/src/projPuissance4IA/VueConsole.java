package projPuissance4IA;

/**
 * Cette classe permet l'affichage de la grille de jeu en mode console
 * 
 * @author Ewald
 * @see Grille
 * @see Jeu
 * @see Vue
 */
public class VueConsole extends Vue {
	
	/**
	 * Contr�leur actuel du jeu, servant � r�cup�rer la Grille
	 * @see Jeu
	 */
	private Jeu jeu;

	/**
	 * Constructeur de la VueConsole
	 * @param jeu le contr�leur de la manche actuelle
	 * @see Jeu
	 */
	public VueConsole(Jeu jeu) {
		this.jeu = jeu;
	}
	
	/**
	 * M�thode d'affichage : print dans le flux System.out la m�thode toString de Grille
	 * @see Jeu
	 * @see Grille
	 * @see Grille#toString()
	 */
	public void afficher() {
			System.out.println(jeu.getGrille().toString());
	}
	
	/**
	 * Affiche un petit message d'au revoir dans le System.out
	 */
	public void dispose() {
		System.out.println("Au revoir \n");
	}
}

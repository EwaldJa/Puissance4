package projPuissance4;

/**
 * Cette classe est celle qui permet, via une FramePuissance4, l'affichage graphique de la grille de jeu. Elle permet de faire le lien
 * entre le contrôleur (Jeu, qui s'occupe lui-même du modèle (Grille)) et la vue.
 * 
 * @author Ewald
 * @see FramePuissance4
 * @see Grille
 * @see Jeu
 * @see Vue
 */
public class VueGraphique extends Vue {
	
	/**
	 * Frame permettant l'affichage graphique de la grille de jeu
	 * @see FramePuissance4
	 */
	private FramePuissance4 frame;
	
	/**
	 * Constructeur de VueGraphique, passe le contrôleur dans la FramePuissance4
	 * @param jeu contrôleur de la manche actuelle
	 * @param iaEnabled booléen représentant le mode IA active (true) ou non (false), pour l'affichage graphique, qui varie un peu selon
	 * @see Jeu
	 * @see FramePuissance4
	 */
	public VueGraphique(Jeu jeu, boolean iaEnabled) {
		frame = new FramePuissance4(jeu, iaEnabled);
	}
	
	/**
	 * Méthode d'affichage, passe le relai à cette même méthode dans FramePuissance4
	 * @see FramePuissance4#affichage()
	 */
	public void afficher() {
		frame.affichage();
	}
	
	public FramePuissance4 getFrame() {
		return frame;
	}
	
	/**
	 * Méthode pour quitter, passe le relai à cette même méthode qui est générique dans FramePuissance4
	 * @see FramePuissance4#dispose()
	 */
	public void dispose() {
		frame.dispose();
	}

}

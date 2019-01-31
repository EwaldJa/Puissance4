package projPuissance4;

/**
 * Cette classe est celle qui permet, via une FramePuissance4, l'affichage graphique de la grille de jeu. Elle permet de faire le lien
 * entre le contr�leur (Jeu, qui s'occupe lui-m�me du mod�le (Grille)) et la vue.
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
	 * Constructeur de VueGraphique, passe le contr�leur dans la FramePuissance4
	 * @param jeu contr�leur de la manche actuelle
	 * @param iaEnabled bool�en repr�sentant le mode IA active (true) ou non (false), pour l'affichage graphique, qui varie un peu selon
	 * @see Jeu
	 * @see FramePuissance4
	 */
	public VueGraphique(Jeu jeu, boolean iaEnabled) {
		frame = new FramePuissance4(jeu, iaEnabled);
	}
	
	/**
	 * M�thode d'affichage, passe le relai � cette m�me m�thode dans FramePuissance4
	 * @see FramePuissance4#affichage()
	 */
	public void afficher() {
		frame.affichage();
	}
	
	public FramePuissance4 getFrame() {
		return frame;
	}
	
	/**
	 * M�thode pour quitter, passe le relai � cette m�me m�thode qui est g�n�rique dans FramePuissance4
	 * @see FramePuissance4#dispose()
	 */
	public void dispose() {
		frame.dispose();
	}

}

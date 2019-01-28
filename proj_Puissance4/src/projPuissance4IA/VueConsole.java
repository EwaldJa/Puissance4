package projPuissance4IA;

public class VueConsole extends Vue {
	
	private Jeu jeu;

	public VueConsole(Jeu jeu) {
		this.jeu = jeu;
	}
	public void afficher() {
			System.out.println(jeu.getGrille().toString());
	}
	public void dispose() {
		System.out.println("Au revoir \n");
	}
}

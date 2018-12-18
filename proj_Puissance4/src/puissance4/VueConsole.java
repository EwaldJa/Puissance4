package puissance4;

public class VueConsole extends Vue {

	public void affichage(Grille grille) {
		for (int i = 0; i < Jeu.MAX_LIGNES; i++) {
			System.out.println(grille[i].toString());
		}		
	}
}

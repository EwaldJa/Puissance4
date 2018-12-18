package puissance4;

public class VueConsole extends Vue {

	public void affichage(Pion[][] grille) {
		String affichage;
		for (int i = 0; i < Grille.NB_LIGNE; i++) {
			affichage = "";
			for (int j = 0; j < Grille.NB_COLONNE; j++) {
				if (grille[i][j] == null) {
					affichage += "| ";
				}
				else {
					affichage += "|" + grille[i][j].getMotif();
				}
			}
			System.out.println(affichage + "|");
		}
	}
}

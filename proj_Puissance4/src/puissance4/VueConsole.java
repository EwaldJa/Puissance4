package puissance4;

public class VueConsole extends Vue {

	public void affichage(Grille lagrille) {
		Pion[][] grille = lagrille.getGrille();
		String affichage;
		for (int i = 0; i < lagrille.getNbLigne(); i++) {
			affichage = "";
			for (int j = 0; j < lagrille.getNbColonne(); j++) {
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

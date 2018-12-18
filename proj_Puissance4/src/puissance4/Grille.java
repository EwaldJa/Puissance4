package puissance4;

public class Grille {

	private Pion[][] grille;
	public static int NB_LIGNE;
	public static int NB_COLONNE;
	private static final int DFAULT_NB_LIGNE = 6;
    private static final int DFAULT_NB_COLONNE = 7;

    public Grille(int nbColonne, int nbLigne) {
    	NB_LIGNE = nbLigne;
    	NB_COLONNE = nbColonne;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
    }

    public Grille() {
    	NB_LIGNE = DFAULT_NB_LIGNE;
    	NB_COLONNE = DFAULT_NB_COLONNE;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
    }

    public Pion getPion(int indLigne, int indCol) throws IndexOutOfBoundsException{
    	return grille[indLigne][indCol];
    }

	/*
    //Attributs
    private TabPion[] grille;
    private int nbColonne;

    //Methodes
    public Grille(int nbColonne, int nbPion) {
        this.nbColonne = nbColonne;
        grille = new TabPion[nbColonne];
        for (int i = 0; i < nbColonne; i++) {
            grille[i] = new TabPion(nbPion);
        }
    }


        nbColonne = Jeu.NB_DEFAULT_COLONNE;
        grille = new TabPion[nbColonne];
        for (int i = 0; i < nbColonne; i++) {
            grille[i] = new TabPion();
        }
    }

    public TabPion getTabPionIndice(int indice) throws IndexOutOfBoundsException {
    	return grille[indice];
    }

    public void placerPion(int colonne) {
        boolean libre = false;
        int indiceLigne = 0;
        do {
            libre = grille[nbColonne-indiceLigne][colonne].estLibre();
            indiceLigne++;
        } while (indiceLigne<nbColonne && !libre);
        if (indiceLigne == nbColonne) {
            System.out.println("Colonne pleine");
        }
    }

    public String toString() {
        String result = NULL;
        for (int i = 0; i<nbColonne; i++) {
            result += grille[i].toString()+'\n';
        }

        return result;
    }
    */


}

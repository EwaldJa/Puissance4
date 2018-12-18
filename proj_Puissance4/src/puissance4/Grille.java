package puissance4;

public class Grille {
	
	private Pion[][] grille;
	private int nbLigne;
	private int nbColonne;
	private static final int DFAULT_NB_LIGNE = 6;
    private static final int DFAULT_NB_COLONNE = 7;
	
    public Grille(int nbColonne, int nbLigne) {
        this.nbLigne = nbLigne;
        this.nbColonne = nbColonne;
        grille = new Pion[nbLigne][nbColonne];
        for (int i = 0; i < nbLigne; i++) {
            for (int j = 0; j < nbColonne; j++) {
            	grille[i][j] = null;
            }
        }
    }

    public Grille() {
        this(DFAULT_NB_COLONNE, DFAULT_NB_LIGNE);
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

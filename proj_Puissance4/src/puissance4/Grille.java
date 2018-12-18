package puissance4;

public class Grille {
    //Attributs
    private TabPion[] grille;
    private int nbColonne;
    private static final NB_DEFAULT_COLONNE = 6;

    //Methodes
    public Grille(int nbColonne, int nbPion) {
        this.nbColonne = nbColonne;
        grille = new tabPion[nbColonne];
        for (int i = 0; i < nbColonne; i++) {
            grille[i] = new TabPion(nbPion);
        }
    }

    public Grille(int nbColonne) {
        this.nbColonne = nbColonne;
        grille = new tabPion[nbColonne];
        for (int i = 0; i < nbColonne; i++) {
            grille[i] = new TabPion();
        }
    }

    public Grille(int nbPion) {
        this.nbColonne = NB_DEFAULT_COLONNE;
        grille = new tabPion[this.nbColonne];
        for (int i = 0; i < this.nbColonne; i++) {
            grille[i] = new TabPion(nbPion);
        }
    }

    public Grille() {
        this.nbColonne = NB_DEFAULT_COLONNE;
        grille = new tabPion[this.nbColonne];
        for (int i = 0; i < this.nbColonne; i++) {
            grille[i] = new TabPion();
        }
    }

    public TabPion getTabPionIndice(int indice) {
        if (indice < nbColonne && indice >= 0) {
            return tabPion[i]
        }else {
            System.out/println("indice incorrecte : impossible d'accéder à la colonne");
        }
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
}

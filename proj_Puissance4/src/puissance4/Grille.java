package puissance4;

public class Grille {

    //Attributs
	private Pion[][] grille;
    private static int NB_LIGNE;
    private static int NB_COLONNE;
    private static final int DEFAULT_NB_LIGNE = 6;
    private static final int DEFAULT_NB_COLONNE = 7;
    private Vue mavue;

	//Methods
    public Grille(int nbColonne, int nbLigne, Vue vue) {
    	NB_LIGNE = nbLigne;
    	NB_COLONNE = nbColonne;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
        mavue = vue;
    }

    public Grille(int nbColonne, int nbLigne) {
    	NB_LIGNE = nbLigne;
    	NB_COLONNE = nbColonne;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
        mavue = new VueConsole();
    }

    public Grille(Vue vue) {
    	NB_LIGNE = DEFAULT_NB_LIGNE;
    	NB_COLONNE = DEFAULT_NB_LIGNE;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
        mavue = vue;
    }

    public Grille() {
    	NB_LIGNE = 6;
    	NB_COLONNE = 7;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = null;
            }
        }
        mavue = new VueConsole();
    }

    public static int getNbLigne() {
        return NB_LIGNE;
    }

    public static int getNbColonne() {
        return NB_COLONNE;
    }

    public Pion getPion(int indLigne, int indCol) throws IndexOutOfBoundsException{
    	return grille[indLigne][indCol];
    }


    public int[] placerPion(int col, Pion pion) throws Exception {
    	if (col >= NB_COLONNE) {
    		throw new IndiceIncorrectException();
    	}
    	else {
    		int i = NB_LIGNE;
    		while(i>=0) {
    			if (grille[i][col] == null) {
    				grille[i][col] = pion;
    				return (new int[] {i,col});
    			}
    		}
    		throw new ColonnePleineException();
    	}
    }


    public void affichage() {
    	mavue.affichage(grille);
    }

    public Pion[][] getGrille(){
    	return grille;
    }

    public String toString() {
        String result = null;
        for (int i = 0; i<NB_COLONNE; i++) {
            for (int j =0 ; j < NB_LIGNE ; j++) {
                if (grille[i][j] == null) {
                    result+="|  ";
                }else {
                    result+="| "+grille[i][j].getMotif()+" ";
                }
            }
            result+="|\n";
        }

        return result;
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

    */
}

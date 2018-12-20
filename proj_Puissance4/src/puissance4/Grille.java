package puissance4;

public class Grille {

    //Attributs
	private Pion[][] grille;
    private int NB_LIGNE, NB_COLONNE;
    public static final int DEFAULT_NB_LIGNE = 6, DEFAULT_NB_COLONNE = 7;
    private Vue mavue;

	//Methods
    public Grille(int nbLigne, int nbColonne, Vue vue) {
    	NB_LIGNE = nbLigne;
    	NB_COLONNE = nbColonne;
        grille = new Pion[NB_LIGNE][NB_COLONNE];
        for (int i = 0; i < NB_LIGNE; i++) {
            for (int j = 0; j < NB_COLONNE; j++) {
            	grille[i][j] = new Pion();
            }
        }
        mavue = vue;
    }

    public Grille(int nbLigne, int nbColonne) {
    	this(nbColonne, nbLigne, new VueConsole());
    }

    public Grille(Vue vue) {
    	this(DEFAULT_NB_LIGNE, DEFAULT_NB_COLONNE, vue);
    }

    public Grille() {
        this(DEFAULT_NB_LIGNE, DEFAULT_NB_COLONNE, new VueGraphique());
    }

    public int getNbLigne() {
        return NB_LIGNE;
    }

    public int getNbColonne() {
        return NB_COLONNE;
    }

    public Pion getPion(int indLigne, int indCol) throws IndexOutOfBoundsException{
    	return grille[indLigne][indCol];
    }


    public int[] placerPion(int col, Pion pion) throws Exception {
    	if ( (col >= NB_COLONNE) || (col < 0) ) {
    		throw new IndiceIncorrectException("Indice non compris dans les indices de colonnes");
    	}
    	else {
    		int i = NB_LIGNE-1;
    		while(i>=0) {
    			if (grille[i][col] == null) {
    				grille[i][col] = pion;
    				return (new int[] {i,col});
    			}
    		}
    		throw new ColonnePleineException("Cette colonne est remplie.");
    	}
    }


    public void affichage() {
    	mavue.affichage(this);
    }

    public Pion[][] getGrille(){
    	return grille;
    }

    public String toString() {
        String result = null;
        for (int i = 0; i< NB_COLONNE; i++) {
            for (int j = 0; j < NB_LIGNE; j++) {
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
}

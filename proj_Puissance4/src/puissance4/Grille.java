package puissance4;

public class Grille {

    //Attributs
	private Pion[][] grille;
    private int nbLigne;
    private int nbColonne;
    private static final int DEFAULT_NB_LIGNE = 6;
    private static final int DEFAULT_NB_COLONNE = 7;
    private Vue mavue;

	//Methods
    public Grille(int nbColonne, int nbLigne, Vue vue) {
    	this.nbLigne = nbLigne;
    	this.nbColonne = nbColonne;
        grille = new Pion[this.nbLigne][this.nbColonne];
        for (int i = 0; i < this.nbLigne; i++) {
            for (int j = 0; j < this.nbColonne; j++) {
            	grille[i][j] = null;
            }
        }
        mavue = vue;
    }

    public Grille(int nbColonne, int nbLigne) {
    	this(nbColonne, nbLigne, new VueConsole());
    }

    public Grille(Vue vue) {
    	this(DEFAULT_NB_COLONNE, DEFAULT_NB_LIGNE, vue);
    }

    public Grille() {
        this(DEFAULT_NB_COLONNE, DEFAULT_NB_LIGNE, new VueConsole());
    }

    public int getNbLigne() {
        return nbLigne;
    }

    public int getNbColonne() {
        return nbColonne;
    }

    public Pion getPion(int indLigne, int indCol) throws IndexOutOfBoundsException{
    	if (0<=indLigne && indLigne< nbLigne && 0<=indCol && indCol< nbColonne) {
            return grille[indLigne][indCol];
        }else {
    	    throw new IndexOutOfBoundsException();
        }
    }


    public int[] placerPion(int col, Pion pion) throws Exception {
    	if (col >= nbColonne) {
    		throw new IndiceIncorrectException();
    	}
    	else {
    		int i = nbLigne;
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
        for (int i = 0; i< nbColonne; i++) {
            for (int j = 0; j < nbLigne; j++) {
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

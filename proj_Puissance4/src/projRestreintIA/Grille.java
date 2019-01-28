package projRestreintIA;


public class Grille {
	private Pion[][] grille;
	private int nb_ligne;
	private int nb_colonne;
	public static int IN_PROGRESS=-1;
	private Joueur jGagnant;
	private int derniereColonne;
	
	public Grille() {
		grille = new Pion[6][6];
		this.nb_colonne=6;
		this.nb_ligne=6;
		for(int i=0  ;  i<6  ;i++  ) {
			for(int j=0  ;  j<6  ;j++  ) {
				 grille[i][j]= new Pion(' ');
			}
		}
	}
	public Grille(int col, int ligne) {
		grille = new Pion[ligne][col];
		this.nb_colonne=col;
		this.nb_ligne=ligne;
		for(int i=0  ;  i<nb_ligne  ;i++  ) {
			for(int j=0  ;  j<nb_colonne  ;j++  ) {
				 grille[i][j]= new Pion(' ');
			}
		}
	}
	public Grille(Pion[][] grille) {
		this.grille=grille;
	}
	public int getNbCol() {
		return this.nb_colonne;
	}
	public int getNbLigne() {
		return this.nb_ligne;
	}
	public int getHeight(int colonne) {
		//Retourne la hauteur du pion le plus haut de la colonne
		int cpt=0;
		for(int i=0;i<nb_ligne;i++) {
			if(grille[nb_ligne-1-i][colonne].getMotif() != ' ') {
				cpt++;
			}
		}
		return cpt;
	}
	public void setGrille(Pion[][] grille) {
		this.grille=grille;
		this.nb_colonne=grille[0].length;
		this.nb_ligne=grille.length;

	}
	public Pion[][] getGrille(){
		return this.grille;
	}
	
	public String toString() {
		String s = "";
		for(int i=0;i<nb_ligne;i++) {
			s+="|";
			for(int j=0;j<nb_colonne;j++) {
				s+= grille[i][j].toString() + "|";
			}
			s+="\n";
		}
		s+="_____________\n ";
		for(int i=0; i<nb_colonne;i++) {

			s+=i+1+" ";
		}
		
		
		return s;
	}
	
	public void AjouterPion(int colonne,Joueur j) throws HorsPlateauException,ColonnePleineException
	{
		int ligneCalc=0;
		
			if(colonne>nb_colonne-1 || colonne<0) {
				throw new HorsPlateauException();
			}
			else {
			for(int i=0;i<nb_ligne;i++) {
				if(grille[i][colonne].getMotif() != ' ' ) {
					ligneCalc=i-1;
					break;
				}
					else {
					ligneCalc=nb_ligne-1;
				}
			}

		}
		if(ligneCalc<0) {
			throw new ColonnePleineException();
		}
		else {
		grille[ligneCalc][colonne].setMotif(j.getMotif());
		this.derniereColonne=colonne;
		}
		
		}
	public int getDerniereColonne() {
		return this.derniereColonne;
	}
	
	
	public boolean victoire() {
		if(victoireHorizontale()) {
			return true;
		}
		if(victoireVerticale()) {
			return true;
		}
		if (victoireDiagonalePos()) {
			return true;
		}
		if(victoireDiagonaleNeg()) {
			return true;
		}
		else return false;
	}
	public boolean victoireVerticale() {
		boolean v=false;
		for(int i=0;i<nb_colonne;i++) {
			int cpt=0;
			for(int j=0;j<nb_ligne-1;j++) {
				if(grille[j][i].getMotif()==grille[j+1][i].getMotif() && grille[j][i].getMotif()!=' ') {
					cpt++;
					if(cpt==3) {
						v=true;;
					}
				}
				else {
					cpt=0;
				}
			}
			if(v) {
				break;
			}
		}
		return v;
	}
	public boolean victoireHorizontale() {
		boolean v=false;
		for(int i=0;i<nb_ligne;i++) {
			int cpt=0;
			for(int j=0;j<nb_colonne-1;j++) {
				if(grille[i][j].getMotif()==grille[i][j+1].getMotif() && grille[i][j].getMotif()!=' ') {
					cpt++;
					if(cpt==3) {
						v=true;
						break;
					}
				}
				else {
					cpt=0;
				}

			}
			if(v) {
				break;
			}
		}
		return v;
	}
	public boolean victoireDiagonalePos() {
		boolean v=false;
		int cpt=0;
		int a=1;
		for(int i=3;i<nb_ligne;i++) {
			for(int j=0;j<nb_colonne-1;j++) {

				for(int ligne=i;ligne>i-3;ligne--) {
					if(j+a<nb_ligne) {
					if(grille[ligne][j+a-1].getMotif()  ==  grille[ligne-1][j+a].getMotif() && grille[ligne][j+a-1].getMotif()!=' ') {
						cpt++;
						a++;
						if(cpt==3) {
							v=true;
							break;
						}
					}
					else {
						cpt=0;
						a=1;
					}
					}
					else {
						a=1;
				}

				}
				if(v) {
					break;
				}
			}
			if(v) {
				break;
			}

		}
		return v;
	}
	public boolean victoireDiagonaleNeg() {
		boolean v=false;
		int cpt=0;
		int a=1;
		for(int i=0;i<nb_ligne-3;i++) {
			for(int j=0;j<nb_colonne-1;j++) {

				for(int ligne=i;ligne<i+3;ligne++) {
					if(j+a<nb_ligne) {
					if(grille[ligne][j+a-1].getMotif()  ==  grille[ligne+1][j+a].getMotif() && grille[ligne][j+a-1].getMotif()!=' ') {
						cpt++;
						a++;
						if(cpt==3) {
							v=true;
							break;
						}
					}
					else {
						cpt=0;
						a=1;
					}
					}
					else {
						a=1;
					}
				}
				if(v) {
					break;
				}
			}
			if(v) {
				break;
			}

		}
		return v;
	}
	public boolean victoireVerticale1(int x, int y) {
		int cpt=0;
		boolean f = false;
		for(int i=0;i<5;i++) {

			if(y>0 && !f) {
				if(grille[y][x].getMotif()==grille[y-1][x].getMotif() && grille[y][x].getMotif()!=' ') {
					y--;
					i=0;
					}
				else {
					f=true;
				}
			}
			else {
				if(y<nb_ligne-1) {
					if(grille[y][x].getMotif()==grille[y+1][x].getMotif() && grille[y][x].getMotif()!=' ') {	
						cpt++;
						y++;
					}
				}
			}
			if(cpt==3) {
				return true;
			}
		}
		return false;
	}
	public boolean matchNul() {
		int cpt=0;
		for(int i=0;i<nb_ligne;i++) {
			for(int j=0;j<nb_colonne;j++) {
				if(this.grille[i][j].getMotif()==' ') {
					cpt++;
				}
			}
		}
		if(cpt==0) {
			return true;
		}
		else {
			return false;
		}
	}
	public boolean over() {
		if(this.victoire()) {
			return true;
		}
		else if(this.matchNul()) {
			return true;
		}
		else {
			return false;
		}
	}
	public Grille clone() {
		//Associe chaque motif avec celui de la grille a cloner
		Grille g= new Grille(nb_colonne,nb_ligne);
		for(int i=0;i<nb_ligne;i++) {
			for(int j=0;j<nb_colonne;j++) {
				g.getGrille()[i][j].setMotif(this.getGrille()[i][j].getMotif());
			}
		}
		return g;
	}

}

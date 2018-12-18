package puissance4;

public class TabPion {
	private Pion[] tabPion;
	private int nbPion;

	public TabPion(int nbPion) {
		this.nbPion = nbPion;
		tabPion = new Pion [nbPion];
		for(int i=0; i<nbPion;i++) {
			tabPion[i] = null;
		}
	}

	public TabPion() {
		this(Jeu.NB_DEFAULT_PION);
	}
	
	public Pion[] getTabPion() {
		return tabPion;
	}
	

	public boolean estLibre(int indice) {
		if (indice < nbPion && indice >= 0) {
			return (tabPion[indice] == null);
		}else {
			return false;
		}
	}

	public void ajouterPion(int x, char motif) {
		tabPion[x]=new Pion(motif);
	}

	public String toString() {
		String s = "|";
		for(int i =0; i<nbPion;i++) {
			if (tabPion[i]==null) {
				s+=" |";
			}
			else {
				s+=tabPion[i].toString() + "|";
			}
		}

		return s;
	}

	public static void main(String[] args) {
		TabPion tab= new TabPion(6);
		tab.ajouterPion(2,'x');
		tab.ajouterPion(4,'o');
		tab.ajouterPion(5,'o');
		System.out.println();
		System.out.println(tab.toString());
	}
}

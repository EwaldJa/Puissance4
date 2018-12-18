package puissance4;

public class TabPion {
	private Pion[] tabPion;
	private int nbPion;
	private static final NB_DEFAULT_PION = 7;

	public TabPion(int nbPion) {
		this.nbPion = nbPion;
		tabPion = new Pion [nbPion];
		for(int i=0; i<nbPion;i++) {
			tabPion[i] = null;
		}
	}

	public TabPion() {
		this(NB_MAX_PION);
	}

	public boolean estLibre(int indice) {
		if (indice < nbPion && indice >= 0) {
			return tabPion[indice].getMotif() == null;
		}else {
			System.out.println("Indice incorrecte");
		}
	}

	public void AjouterPion(int x, char motif) {
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
		tab.AjouterPion(2,'x');
		tab.AjouterPion(4,'o');
		tab.AjouterPion(5,'o');
		System.out.println();
		System.out.println(tab.toString());
	}
}

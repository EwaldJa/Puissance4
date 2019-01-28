package projRestreintIA;

public class Arbre {
	public Noeud noeud;

	public Arbre() {
		this.noeud= new Noeud();
	}
	public Arbre(Grille g) {
		this.noeud= new Noeud(g);
	}
	public Noeud getNoeud() {
		return this.noeud;
	}
	public void setRacine(Noeud noeudRacine) {
		this.noeud=noeudRacine;
		
	}
}

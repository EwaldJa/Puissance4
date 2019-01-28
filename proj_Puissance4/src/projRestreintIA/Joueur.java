package projRestreintIA;

public class Joueur {
	
	protected Pion pion;
	protected Joueur jSuivant;
	public Joueur(char motif) {
		this.pion= new Pion(motif);
	}
	public Joueur() {
		//
	}
	public char getMotif() {
		return pion.getMotif();
	}
	public Joueur getSuivant() {
		return this.jSuivant;
	}
	public void setJSuivant(Joueur j) {
		this.jSuivant=j;
	}
	public void setMotif(char c) {
		this.pion = new Pion(c);
	}
	
}

package projPuissance4IA;

import java.awt.Color;

public class Joueur {
	
	protected Pion pion;
	protected Joueur jSuivant;
	
	public Joueur(char motif) {
		this.pion= new Pion(motif);
	}
	
	public Joueur(char motif, Color couleur) {
		this.pion= new Pion(motif, couleur);
	}
	
	public char getMotif() {
		return pion.getMotif();
	}
	
	public Color getCouleur() {
		return pion.getCouleur();
	}
	
	public Pion getPion() {
		return pion;
	}
	public Joueur getSuivant() {
		return this.jSuivant;
	}
	public void setJSuivant(Joueur j) {
		this.jSuivant=j;
	}
}

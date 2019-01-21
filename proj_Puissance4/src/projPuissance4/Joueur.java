package projPuissance4;

import java.awt.Color;

public class Joueur {
	
	private Pion pion;
	
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
	
}

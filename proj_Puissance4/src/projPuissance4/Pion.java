package projPuissance4;

import java.awt.Color;

public class Pion {
	private char motif;
	private Color couleur;
	
	
	public Pion(char motif) {
		this.motif=motif;
		couleur = new Color(Character.getNumericValue(motif));
	}
	
	public Pion(char motif, Color color) {
		this.motif=motif;
		couleur = color;
	}
	
	public char getMotif() {
		return motif;
	}
	
	public Color getCouleur() {
		return couleur;
	}
	
	public String toString() {
		return "Motif : " + String.valueOf(motif) + ", couleur : " + String.valueOf(couleur);
	}
	
	public void setMotif(char motif) {
		this.motif=motif;
	}
	
	public void setCouleur(Color color) {
		couleur = color;
	}
	
}

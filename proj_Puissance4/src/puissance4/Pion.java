package puissance4;

import java.awt.Color;

public class Pion {
	private char motif;
	private Color couleur;

	public Pion(char motif) {
		this.motif = motif;
	}
    public Pion(Color couleur) {
		this.couleur=couleur;
	}
    public Pion(Color couleur,char motif) {
		this.couleur=couleur;
		this.motif=motif;
	}
	public char getMotif() {
		return motif;
	}
	public String toString() {
		return String.valueOf(motif);
	}

}

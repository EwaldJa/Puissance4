package puissance4;

import java.awt.Color;

public class Pion {
	private char motif;
	private Color couleur;

    public Pion(Color couleur,char motif) {
		this.couleur=couleur;
		this.motif=motif;
	}

	public Pion(char motif) {
		this(null, motif);
	}
    public Pion(Color couleur) {
		this(couleur, null);
	}

	public char getMotif() {
		return motif;
	}

	public String toString() {
		return String.valueOf(motif);
	}

}

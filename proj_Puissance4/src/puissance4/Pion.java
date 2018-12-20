package puissance4;

import java.awt.Color;

public class Pion {
	private char motif;
	private Color color;

    public Pion(Color couleur,char motif) {
    	color=couleur;
		this.motif=motif;
	}

	public Pion(char motif) {
		this(new Color((int)(Math.random() * 255), (int)(Math.random() * 255), (int)(Math.random() * 255)), motif);
	}
	
	public Pion() {
		this(Color.LIGHT_GRAY, ' ');
	}

	public char getMotif() {
		return motif;
	}
	
	public Color getColor() {
		return color;
	}

	public String toString() {
		return String.valueOf(motif);
	}

}

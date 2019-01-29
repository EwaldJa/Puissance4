package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe permet de repr�senter les Pions des Joueurs dans la Grille
 * 
 * @author Ewald
 * @see Grille
 * @see Joueur
 */
public class Pion {
	
	/**
	 * Un caract�re, le motif qui repr�sente le Pion en affichage console
	 * @see VueConsole
	 */
	private char motif;
	
	/**
	 * La couleur servant � repr�senter le pion en vue graphique
	 * @see VueGraphique
	 */
	private Color couleur;
	
	/**
	 * Constructeur du Pion lorsque seul un motif est pass� en param�tre. La couleur est donc d�duite du code ASCII de ce caract�re.
	 * @param motif un caract�re qui repr�sente le Pion en affichage console
	 * @see #couleur
	 * @see #motif
	 */
	public Pion(char motif) {
		this.motif=motif;
		couleur = new Color(Character.getNumericValue(motif));
	}
	
	/**
	 * Constructeur du Pion lorsque un motif et une couleur sont pass�s en param�tres
	 * @param motif un caract�re qui repr�sente le Pion en affichage console
	 * @param color permet de repr�senter le pion en affichage graphique
	 * @see #couleur
	 * @see #motif
	 */
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

package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe représente un joueur, qui doit aligner des pions sur la grille pour gagner. Elle pourrait presque fusionner avec Pion, certainement
 * dans une prochaine mise à jour.
 * 
 * @author Ewald
 * @see Grille
 * @see Pion
 */
public class Joueur {
	
	/**
	 * Attribut pion du joueur, symbolisant ses caractéristiques de couleur et de motif
	 * @see Pion
	 */
	protected Pion pion;
	
	/**
	 * Attribut représentant le prochain joueur dont c'est le tour, utile à l'IA
	 * @see IA
	 */
	protected Joueur jSuivant;
	
	/**
	 * Constructeur du joueur, avec un seul paramètre, le motif. La couleur sera déduite du motif, mais sera difficilement discernable à l'oeil si 
	 * tous les joueurs sont construits selon cette méthode.
	 * @param motif un caractère, représentant le motif du pion du joueur en affichage console
	 */
	public Joueur(char motif) {
		this.pion= new Pion(motif);
	}
	
	/**
	 * Constructeur du joueur avec deux paramètres, un motif et une couleur personnalisés
	 * @param motif un caractère, représentant le motif du pion du joueur en affichage console
	 * @param couleur permettant l'affichage du pion du joueur en vue graphique
	 */
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

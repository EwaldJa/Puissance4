package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe repr�sente un joueur, qui doit aligner des pions sur la grille pour gagner. Elle pourrait presque fusionner avec Pion, certainement
 * dans une prochaine mise � jour.
 * 
 * @author Ewald
 * @see Grille
 * @see Pion
 */
public class Joueur {
	
	/**
	 * Attribut pion du joueur, symbolisant ses caract�ristiques de couleur et de motif
	 * @see Pion
	 */
	protected Pion pion;
	
	/**
	 * Attribut repr�sentant le prochain joueur dont c'est le tour, utile � l'IA
	 * @see IA
	 */
	protected Joueur jSuivant;
	
	/**
	 * Constructeur du joueur, avec un seul param�tre, le motif. La couleur sera d�duite du motif, mais sera difficilement discernable � l'oeil si 
	 * tous les joueurs sont construits selon cette m�thode.
	 * @param motif un caract�re, repr�sentant le motif du pion du joueur en affichage console
	 */
	public Joueur(char motif) {
		this.pion= new Pion(motif);
	}
	
	/**
	 * Constructeur du joueur avec deux param�tres, un motif et une couleur personnalis�s
	 * @param motif un caract�re, repr�sentant le motif du pion du joueur en affichage console
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

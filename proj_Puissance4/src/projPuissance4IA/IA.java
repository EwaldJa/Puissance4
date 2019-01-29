package projPuissance4IA;

import java.awt.Color;

/**
 * Cette classe repr�sente l'IA dans la partie en tant que Joueur, pour qu'elle puisse jouer
 * et avoir sa propre couleur et son propre motif
 * 
 * @author Luca
 * @see Joueur
 */
public class IA extends Joueur {
	
	/**
	 * Entier repr�sentant le niveau de difficult� de l'IA : multiplicateur du nombre d'it�rations
	 * effectu�es lors du calcul des coups possibles
	 */
	private int level;
	
	/**
	 * Constructeur de l'IA
	 * La couleur de l'IA est pr�d�finie par ava,ce et non-modifiable par le joueur
	 * 
	 * @param motif un caract�re repr�sentant le motif de l'IA en mode console
	 * @param level un entier repr�sentant le niveau de difficult� de l'IA
	 * @see Joueur#Joueur(char, Color)
	 * @see IA#level
	 */
	public IA(char motif, int level) {
		super(motif, new Color(255, 61, 7));
		this.level = level;
	}
	
	/**
	 * M�thode de jeu de l'IA
	 * Elle joue le coup optimal pour elle, etselon son niveau
	 * 
	 * @param grille la grille de jeu actuelle
	 * @return un nouvelle grille, dans laquelle elle a plac� son pion
	 * @throws HorsPlateauException
	 * @throws ColonnePleineException
	 * @see Grille
	 */
	public Grille jouer(Grille grille) throws HorsPlateauException, ColonnePleineException {
		ArbreDeMonteCarlo a= new ArbreDeMonteCarlo(this.level,this);
		return a.FindNextMove(grille, this);
	}
	public int getDifficulty() {
		return level;
	}
	public Color getCouleur() {
		return this.pion.getCouleur();
	}
}
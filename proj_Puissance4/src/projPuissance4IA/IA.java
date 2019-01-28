package projPuissance4IA;

import java.awt.Color;

public class IA extends Joueur {
	private int level;
	public IA(char motif, int level) {
		super(motif, new Color(255, 61, 7));
		this.level = level;
	}
	public Grille jouer(Grille grille) throws HorsPlateauException, ColonnePleineException {
		ArbreDeMonteCarlo a= new ArbreDeMonteCarlo(this.level,this,this.jSuivant);
		return a.FindNextMove(grille, this);
		
	}
	public int getDifficulty() {
		return level;
	}
	public Color getCouleur() {
		return new Color(255, 61, 7);
	}
}
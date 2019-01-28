package projRestreintIA;

public class IA extends Joueur {
	private int level;
	public IA(char motif, int level) {
		super(motif);
		this.level =level;
	}
	public Grille jouer(Grille grille) throws HorsPlateauException, ColonnePleineException {
		ArbreDeMonteCarlo a= new ArbreDeMonteCarlo(this.level,this,this.jSuivant);
		return a.FindNextMove(grille, this);
		
	}
}

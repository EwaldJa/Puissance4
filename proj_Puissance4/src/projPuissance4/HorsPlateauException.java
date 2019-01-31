package projPuissance4;

/**
 * Exception lev�e lorsqu'un joueur cherche � jouer dans une colonne qui est n'est pas dans la grille. 
 * Le message contient le num�ro de colonne (non format� � l'affichage joueur) en question.
 * 
 * @author Luca
 *
 */
public class HorsPlateauException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	public HorsPlateauException(int colonne) {
		this.message= "Vous avez rentr� un chiffre hors limite ! (" + colonne + ")\nVeuillez rejouer";
	}
	public String getMessage() {
		return this.message;	}
}

package projPuissance4;

/**
 * Exception levée lorsqu'un joueur cherche à jouer dans une colonne qui est n'est pas dans la grille. 
 * Le message contient le numéro de colonne (non formaté à l'affichage joueur) en question.
 * 
 * @author Luca
 *
 */
public class HorsPlateauException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	public HorsPlateauException(int colonne) {
		this.message= "Vous avez rentré un chiffre hors limite ! (" + colonne + ")\nVeuillez rejouer";
	}
	public String getMessage() {
		return this.message;	}
}

package projPuissance4;

/**
 * Exception levée lorsqu'un joueur cherche à jouer dans une colonne qui est pleine. Le message
 * contient le numéro de colonne (non formaté à l'affichage joueur) en question.
 * 
 * @author Luca
 *
 */
public class ColonnePleineException extends Exception {

	private static final long serialVersionUID = 1L;

	private String message;
	public ColonnePleineException(int colonne) {
		this.message="La colonne dans laquelle vous essayez de jouer (" + colonne + ") est pleine,\nchoisissez en une autre !";
		
	}
	public String getMessage() {
		return message;
	}
}

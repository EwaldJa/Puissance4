package projPuissance4IA;

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

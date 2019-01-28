package projRestreintIA;


public class ColonnePleineException extends Exception {
	private String message;
	public ColonnePleineException() {
		this.message="La colonne dans laquelle vous essayez de jouer est pleine,\nchoisissez en une autre !";
		
	}
	public String getMessage() {
		return message;
	}
}

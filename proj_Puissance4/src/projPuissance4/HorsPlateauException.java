package projPuissance4;

public class HorsPlateauException extends Exception{

	private static final long serialVersionUID = 1L;
	
	private String message;
	public HorsPlateauException(int colonne) {
		this.message= "Vous avez rentré un chiffre hors limite ! (" + colonne + ")\nVeuillez rejouer";
	}
	public String getMessage() {
		return this.message;	}
}

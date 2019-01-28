package projRestreintIA;


public class HorsPlateauException extends Exception{
	private String message;
	public HorsPlateauException() {
		this.message= "Vous avez rentré un chiffre hors limite !\nVeuillez rejouer";
	}
	public String getMessage() {
		return this.message;	}
}

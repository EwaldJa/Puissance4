package projRestreintIA;

public class Pion {
	private char motif;
	
	
	public Pion(char motif) {
		this.motif=motif;
	}
	
	public char getMotif() {
		return motif;
	}
	
	public String toString() {
		return String.valueOf(motif);
	}
	
	public void setMotif(char motif) {
		this.motif=motif;
	}
	
}

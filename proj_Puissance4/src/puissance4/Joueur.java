package puissance4;

public class Joueur {
    //Attributs
    
    private String pseudo;
    private char motif;

    //Methodes

    public Joueur(String pseudo, char motif) {
        this.pseudo = pseudo;
        this.motif = motif;
    }

    public Joueur(String prenom) {
        this(prenom, 'X');
    }

    public Joueur() {
        this("Joueur", 'X');
    }

    public char getMotif() {
        return motif;
    }

    public void setMotif(char motif) {
        this.motif = motif;
    }
    
    public String getPseudo() {
    	return pseudo;
    }
    
    public void setPseudo(String pseudo) {
    	this.pseudo = pseudo;
    }

    public String toString() {
        String result = pseudo+" ("+motif+")";

        return result;
    }

    public static void main(String[] args) {
        Joueur test = new Joueur("Nathan", 'O');

        System.out.println(test.toString());
    }
}

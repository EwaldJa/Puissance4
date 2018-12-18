package puissance4;

public class Joueur {
    //Attributs
    private String nom;
    private String prenom;
    private char motif;

    //Methodes

    public Joueur(String nom, String prenom, char motif) {
        this.nom = nom;
        this.prenom = prenom;
        this.motif = motif;
    }

    public Joueur(String nom, String prenom) {
        this(nom, prenom, 'X');
    }

    public Joueur() {
        this("Joueur", "");
    }

    public char getMotif() {
        return motif;
    }

    public void setMotif(char motif) {
        this.motif = motif;
    }

    public String toString() {
        String result = nom+" "+prenom+" ("+motif+")";

        return result;
    }

    public static void main(String[] args) {
        Joueur test = new Joueur("Nathan", "ARMANET", 'O');

        System.out.println(test.toString());
    }
}

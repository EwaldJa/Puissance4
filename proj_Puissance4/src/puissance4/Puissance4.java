package puissance4;

public class Puissance4 {

    private Jeu jeu;

    public Puissance4(){
        jeu = new Jeu();
    }

    public static void main(String[] args) {
        Puissance4 monJeu = new Puissance4();

        monJeu.jeu.menuConsole();
    }
}

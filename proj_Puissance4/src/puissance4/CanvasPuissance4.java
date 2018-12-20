package puissance4;

import java.awt.*;

public class CanvasPuissance4 extends Canvas {
	
	private Grille grille;
	
	public CanvasPuissance4() {
		this.setBackground(new Color(0, 30, 255));
	}
	
	public void affichage(Grille grille) {
		//this.grille = grille; //Permet d'actualiser la grille
		this.repaint();
	}
	
	public void paint(Graphics g) {
		Pion monpion;
		int coordX; //Initilisation de la coordonnée abscisse(colonne) de la case courante, angle gauche supérieur
		int coordY = FramePuissance4.GAP_CASE; //Initilisation de la coordonnée ordonnée(ligne) de la case courante, angle gauche supérieur
		for(int y=0; y < grille.getNbLigne(); y++) { //boucle qui parcourt les lignes (y = hauteur = ligne)
			coordX = FramePuissance4.GAP_CASE; //réinitialisation de l'indice d'affichage en colonnes quand une ligne est terminée
			for(int x=0; x < grille.getNbColonne(); x++) { //boucle qui parcourt les colonnes (x = abscisse = colonne)
				monpion = grille.getPion(y,x);
				g.setColor(Color.LIGHT_GRAY); //case vide
				g.fillRect(coordX, coordY, FramePuissance4.COTE_CASE, FramePuissance4.COTE_CASE);
				g.setColor(monpion.getColor());
				g.fillOval(coordX+5, coordY+5, FramePuissance4.COTE_CASE-10, FramePuissance4.COTE_CASE-10);
				coordX+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
			}
			coordY+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
		}
	}

}

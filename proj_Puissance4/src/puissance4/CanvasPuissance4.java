package puissance4;

import java.awt.*;

public class CanvasPuissance4 extends Canvas {
	
	private Pion[][] grille;
	
	public CanvasPuissance4() {
		this.setBackground(new Color(0, 30, 255));
	}
	
	public void affichage(Pion[][] grille) {
		this.grille = grille; //Permet d'actualiser la grille
		this.repaint();
	}
	
	public void paint(Graphics g) {
		Pion myvalue; //String qui va prendre la valeur � afficher, case par case
		int coordX; //Initilisation de la coordonn�e abscisse(colonne) de la case courante, angle gauche sup�rieur
		int coordY = FramePuissance4.GAP_CASE; //Initilisation de la coordonn�e ordonn�e(ligne) de la case courante, angle gauche sup�rieur
		for(int y=0; y < Grille.NB_LIGNE; y++) { //boucle qui parcourt les lignes (y = hauteur = ligne)
			coordX = FramePuissance4.GAP_CASE; //r�initialisation de l'indice d'affichage en colonnes quand une ligne est termin�e
			for(int x=0; x < Grille.NB_COLONNE; x++) { //boucle qui parcourt les colonnes (x = abscisse = colonne)
				g.setColor(Color.LIGHT_GRAY); //case vide
				g.fillRect(coordX, coordY, FramePuissance4.COTE_CASE, FramePuissance4.COTE_CASE);
				myvalue = grille[y][x]; //prise de la valeur
				if (myvalue != null ) {
					g.setColor(myvalue.getColor());
					g.fillOval(coordX+5, coordY+5, FramePuissance4.COTE_CASE-10, FramePuissance4.COTE_CASE-10);
				}
				coordX+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
			}
			coordY+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
		}
	}

}

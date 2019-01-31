package projPuissance4;

import java.awt.Canvas;

import java.awt.*;

/**
 * Cette classe sert � afficher la grille de jeu
 * 
 * @author Ewald
 * @see FramePuissance4
 * @see Canvas
 */
public class CanvasPuissance4 extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	/**
	 * Le mod�le grille de jeu actuelle
	 * @see Grille
	 */
	private Grille grille;
	
	/**
	 * Le contr�leur Jeu actuel
	 * @see Jeu
	 */
	private Jeu jeu;
	
	/**
	 * Un bool�en symbolisant si le mode 1v1 Joueur vs IA est activ�
	 */
	boolean iaEnabled;
	
	/**
	 * Constructeur de CanvasPuissance4
	 * @param jeu le contr�leur, pour pouvoir r�cuperer les joueurs et les afficher par la suite
	 * @param iaisEnabled un bool�en symbolisant l'activation ou non de l'IA
	 */
	public CanvasPuissance4(Jeu jeu, boolean iaisEnabled) {
		this.grille = jeu.getGrille();
		this.jeu = jeu;
		this.setBackground(new Color(0, 30, 255));
		iaEnabled = iaisEnabled;
	}
	
	/**
	 * m�thode de r�affichage de la grille de jeu
	 * @param jeu le contr�leur du jeu, pour bien avoir des informations � jour (notamment la grille)
	 */
	public void affichage(Jeu jeu) {
		this.grille = jeu.getGrille(); //Permet d'actualiser la grille
		this.paint(getGraphics());
	}
	
	/**
	 * Cette m�thode est celle appel�e qui permet de dessiner la fen�tre de jeu, et les 
	 * pions plac�s par les diff�rents joueurs (humains ou machines).
	 * Elle affiche �galement le joueur dont c'est le tour et rappelle les couleurs des joueurs
	 */
	public void paint(Graphics g) {
		Pion monpion;
		int coordX = FramePuissance4.GAP_CASE; //Initilisation de la coordonnee abscisse(colonne) de la case courante, angle gauche superieur
		int coordY = FramePuissance4.GAP_CASE; //Initilisation de la coordonnee ordonnee(ligne) de la case courante, angle gauche superieur
		for(int y=0; y < grille.getNbLigne(); y++) { //boucle qui parcourt les lignes (y = hauteur = ligne)
			coordX = FramePuissance4.GAP_CASE; //reinitialisation de l'indice d'affichage en colonnes quand une ligne est terminee
			for(int x=0; x < grille.getNbColonne(); x++) { //boucle qui parcourt les colonnes (x = abscisse = colonne)
				monpion = grille.getPion(y,x);
				g.setColor(Color.LIGHT_GRAY); //case vide
				g.fillRect(coordX, coordY, FramePuissance4.COTE_CASE, FramePuissance4.COTE_CASE);
				g.setColor(monpion.getCouleur());
				g.fillOval(coordX+5, coordY+5, FramePuissance4.COTE_CASE-10, FramePuissance4.COTE_CASE-10);
				coordX+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
			}
			coordY+=(FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE);
		}
		coordY = FramePuissance4.GAP_CASE;
		g.setColor(Color.LIGHT_GRAY); //case vide
		g.fillRect(coordX, coordY, FramePuissance4.LEGENDE, (grille.getNbLigne() * (FramePuissance4.COTE_CASE+FramePuissance4.GAP_CASE)) - FramePuissance4.GAP_CASE);
		coordX += FramePuissance4.MARGE;
		coordY += FramePuissance4.MARGE;
		if (iaEnabled) {
			g.setColor(jeu.getTabJoueurs()[0].getCouleur());
			g.fillOval(coordX, coordY, 3 * FramePuissance4.MARGE, 3 * FramePuissance4.MARGE);
			g.setColor(Color.BLACK);
			g.setFont(new Font("myfont", Font.PLAIN, 15));
			coordY += (FramePuissance4.MARGE * 3);
			g.drawString("Joueur ", coordX + (FramePuissance4.MARGE * 4), coordY);
			coordY += FramePuissance4.MARGE;
			g.setColor(jeu.getTabJoueurs()[1].getCouleur());
			g.fillOval(coordX, coordY, 3 * FramePuissance4.MARGE, 3 * FramePuissance4.MARGE);
			g.setColor(Color.BLACK);
			g.setFont(new Font("myfont", Font.PLAIN, 15));
			coordY += (FramePuissance4.MARGE * 3);
			g.drawString("IA ", coordX + (FramePuissance4.MARGE * 4), coordY);
			coordY += FramePuissance4.MARGE;
		}
		else {
			for (int i = 0; i < jeu.getTabJoueurs().length; i ++) {
				g.setColor(jeu.getTabJoueurs()[i].getCouleur());
				g.fillOval(coordX, coordY, 3 * FramePuissance4.MARGE, 3 * FramePuissance4.MARGE);
				g.setColor(Color.BLACK);
				g.setFont(new Font("myfont", Font.PLAIN, 15));
				coordY += (FramePuissance4.MARGE * 3);
				g.drawString("Joueur " + Integer.toString(i + 1), coordX + (FramePuissance4.MARGE * 4), coordY);
				coordY += FramePuissance4.MARGE;
			}
			coordY += (FramePuissance4.MARGE * 4);
			g.drawString("C'est au tour du n�" + Integer.toString(jeu.getFlag() + 1), coordX, coordY);
		}
	}

}
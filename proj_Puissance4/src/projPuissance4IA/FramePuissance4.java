package projPuissance4IA;

import java.awt.*;

/**
 * Cette classe permet l'affichage de la grille via un CanvasPuissance4. C'est la fenêtre qui va contenir le canvas.
 * 
 * @author Ewald
 * @see Frame
 * @see CanvasPuissance4
 */
public class FramePuissance4 extends Frame {


	private static final long serialVersionUID = 1L;
	
	/**
	 * Constantes statiques déterminant les tailles de cases et autres détails
	 */
	public static final int COTE_CASE = 50, GAP_CASE = 10, LEGENDE = 150, MARGE = 5, TITRE = 30;
	
	/**
	 * Dimensions de la FramePuissance4, accessibles en statique par commodité
	 * @see FramePuissance4
	 */
	public static int HAUTEUR, LARGEUR;
	
	/**
	 * Canvas servant à l'affichage de la grille
	 * @see CanvasPuissance4
	 */
	private CanvasPuissance4 canvas;
	
	/**
	 * Contrôleur de jeu actuel, pour obtenir les caractéristiques de la partie
	 * @see Jeu
	 */
	private Jeu jeu;

	/**
	 * Constructeur de la FramePuissance4
	 * @param jeu contrôleur du jeu
	 * @param iaEnabled booléen représentant le mode IA vs Humain
	 * @see FramePuissance4#jeu
	 * @see FrameListener
	 * @see CanvasPuissance4
	 * @see CanvasPuissance4KeyListener
	 * @see CanvasPuissance4MouseListener
	 */
	public FramePuissance4(Jeu jeu, boolean iaEnabled) {
		this.jeu = jeu;
		canvas = new CanvasPuissance4(jeu, iaEnabled);
		canvas.addKeyListener(new CanvasPuissance4KeyListener(jeu, this, iaEnabled));
		canvas.addMouseListener(new CanvasPuissance4MouseListener(jeu, this, iaEnabled));
		
		HAUTEUR= (jeu.getGrille().getNbLigne() * (COTE_CASE+GAP_CASE) + GAP_CASE + TITRE + MARGE);
		LARGEUR = (jeu.getGrille().getNbColonne() * (COTE_CASE+GAP_CASE) + GAP_CASE + MARGE*3 + LEGENDE);
		this.setSize(LARGEUR, HAUTEUR);
		
		this.setLayout(new BorderLayout());
		this.setTitle("Puissance 4 !");
		
		this.add(canvas, BorderLayout.CENTER);
		
		this.addWindowListener(new FrameListener(this));
		
		this.setResizable(false);
		this.setVisible(true);
		this.requestFocus();
		canvas.requestFocus();
	}
	
	/**
	 * Méthode d'affichage, pour actualiser la grille affichée sur le canvas
	 * @see CanvasPuissance4
	 */
	public void affichage() {
		canvas.affichage(jeu);
		canvas.requestFocus();
	}
	
	public int getHauteur() {
		return HAUTEUR;
	}
	
	public int getLargeur() {
		return LARGEUR;
	}
	
	public CanvasPuissance4 getCanvas() {
		return canvas;
	}


}

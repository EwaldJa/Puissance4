package projPuissance4IA;

import java.awt.*;

public class FramePuissance4 extends Frame {

	// Attributs

	private static final long serialVersionUID = 1L;
	
	public static final int COTE_CASE = 50, GAP_CASE = 10, LEGENDE = 150, MARGE = 5, TITRE = 30;
	public static int HAUTEUR, LARGEUR;
	private CanvasPuissance4 canvas;
	private Jeu jeu;

	// Methods

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

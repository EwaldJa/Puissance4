package puissance4;

import java.awt.*;

public class FramePuissance4 extends Frame {

	// Attributs

	public static final int COTE_CASE = 50, GAP_CASE = 10;
	private int HAUTEUR, LARGEUR;
	private CanvasPuissance4 canvas;

	// Methods

	public FramePuissance4() {
		canvas = new CanvasPuissance4();
		
		this.setLayout(new BorderLayout());
		this.setTitle("Puissance 4 !");
		
		this.add(canvas, BorderLayout.CENTER);
		
		this.addWindowListener(new FrameListener(this));
		
		this.setResizable(false);
		this.setVisible(true);
		this.requestFocus();
	}
	
	public void affichage(Grille grille) {
		canvas.affichage(grille);
		HAUTEUR= (grille.getNbLigne() * (COTE_CASE+GAP_CASE) + GAP_CASE + 30);
		LARGEUR = (grille.getNbColonne() * (COTE_CASE+GAP_CASE) + GAP_CASE + 5);
		this.setSize(LARGEUR, HAUTEUR);
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

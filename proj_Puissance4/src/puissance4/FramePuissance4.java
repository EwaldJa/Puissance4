package puissance4;

import java.awt.*;

public class FramePuissance4 extends Frame {
	
	public static final int COTE_CASE = 50, GAP_CASE = 10;
	public static final int HAUTEUR = (Grille.NB_LIGNE * (COTE_CASE+GAP_CASE) + GAP_CASE),LARGEUR = (Grille.NB_COLONNE * (COTE_CASE+GAP_CASE) + GAP_CASE);
	
	private CanvasPuissance4 canvas;
	
	public FramePuissance4() {
		canvas = new CanvasPuissance4();
		
		this.setSize(LARGEUR, HAUTEUR);
		this.setLayout(new BorderLayout());
		this.setTitle("Puissance 4 !");
		
		this.add(canvas, BorderLayout.CENTER);
		
		this.addWindowListener(new FrameListener(this));
		
		this.setVisible(true);
		this.requestFocus();
	}
	
	public void affichage(Pion[][] grille) {
		canvas.affichage(grille);
	}
	
	public CanvasPuissance4 getCanvas() {
		return canvas;
	}
}

package puissance4;

import java.awt.Frame;

public class FramePuissance4 extends Frame {
	
	private static int HAUTEUR,LARGEUR;
	
	private CanvasPuissance4 canvas;
	
	public FramePuissance4() {
		canvas = new CanvasPuissance4();
		
	}
	
	public void affichage(Pion[][] grille) {
		canvas.affichage(grille);
	}
	
	public CanvasPuissance4 getCanvas() {
		return canvas;
	}
}

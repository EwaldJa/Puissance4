package projPuissance4;

import java.awt.Frame;
import java.awt.event.*;

public class CanvasPuissance4MouseListener extends MouseAdapter {
	
	private Jeu jeu;
	private Frame frame;

	public CanvasPuissance4MouseListener(Jeu jeu, Frame frame) {
		this.jeu = jeu;
		this.frame = frame;
	}

	public void mousePressed(MouseEvent e) {
		int clicX = e.getX();
		if ((clicX > FramePuissance4.GAP_CASE) && (clicX < (jeu.getColonnes() * (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) + FramePuissance4.GAP_CASE + FramePuissance4.LEGENDE))) {
			int colonne = 1;
			while(clicX > FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) {
				colonne++;
				clicX -= (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE);
			}
			if(jeu.updateGraphique(colonne)) {new FrameVictoire(jeu); frame.dispose();}
		}

	}

}

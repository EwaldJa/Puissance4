package projPuissance4IA;

import java.awt.Frame;
import java.awt.event.*;

public class CanvasPuissance4MouseListener extends MouseAdapter {
	
	private Jeu jeu;
	private Frame frame;
	private boolean iaEnabled;

	public CanvasPuissance4MouseListener(Jeu jeu, Frame frame, boolean iaisEnabled) {
		this.jeu = jeu;
		this.frame = frame;
		iaEnabled = iaisEnabled;
	}

	public void mousePressed(MouseEvent e) {
		int clicX = e.getX();
		if ((clicX > FramePuissance4.GAP_CASE) && (clicX < (jeu.getColonnes() * (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) + FramePuissance4.GAP_CASE + FramePuissance4.LEGENDE))) {
			int colonne = 1;
			while(clicX > FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE) {
				colonne++;
				clicX -= (FramePuissance4.GAP_CASE + FramePuissance4.COTE_CASE);
			}
			if (iaEnabled) {if(jeu.updateIAGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
			else {if(jeu.updateGraphique(colonne)) {new FrameVictoire(jeu, iaEnabled, frame);}}
		}

	}

}

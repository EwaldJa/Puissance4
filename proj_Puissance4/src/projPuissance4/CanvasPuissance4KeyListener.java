package projPuissance4;

import java.awt.*;
import java.awt.event.*;


public class CanvasPuissance4KeyListener extends KeyAdapter implements KeyListener {

	private Jeu jeu;
	private Frame frame;
	
	public CanvasPuissance4KeyListener(Jeu jeu, Frame frame) {
		this.jeu = jeu;
		this.frame = frame;
	}
	
	public void keyPressed(KeyEvent e) {
		switch(e.getKeyCode()) {
		case KeyEvent.VK_1:
			if(jeu.updateGraphique(1)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_2:
			if(jeu.updateGraphique(2)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_3:
			if(jeu.updateGraphique(3)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_4:
			if(jeu.updateGraphique(4)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_5:
			if(jeu.updateGraphique(5)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_6:
			if(jeu.updateGraphique(6)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_7:
			if(jeu.updateGraphique(7)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_8:
			if(jeu.updateGraphique(8)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		case KeyEvent.VK_9:
			if(jeu.updateGraphique(9)) {new FrameVictoire(jeu); frame.dispose();}			
			break;
		}
	}

}

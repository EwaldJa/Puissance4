package projPuissance4;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Un écouteur de fenêtre générique, permettant de fermer les fenêtres qui lui sont passées lorsque 
 * l'utilisateur clique sur la croix
 * 
 * @author Ewald
 *
 */
public class FrameListener implements WindowListener {
	
	/**
	 * Frame principale à fermer
	 */
	private Frame myframe;
	
	/**
	 * Frame secondaire à fermer
	 */
	private Frame myframe2;

	/**
	 * Constructeur à une fenêtre de FrameListener
	 * 
	 * @param frame la fenêtre à écouter
	 * @see FrameListener
	 */
	public FrameListener(Frame frame) {
		myframe = frame;
		myframe2 = null;
	}
	
	/**
	 * Constructeur à dexu fenêtres de FrameListener. il sert quand on veut afficher une FrameVictoire et en
	 * même temps garder la FramePuissance4 avec la grille affichée à la fin de la partie
	 * 
	 * @param frame la fenêtre à écouter
	 * @param frame2 la fenêtre secondaire à fermer
	 * @see FrameListener
	 * @see FrameVictoire
	 * @see FramePuissance4
	 */
	public FrameListener(Frame frame, Frame frame2) {
		myframe = frame;
		myframe2 = frame2;
	}
	
	@Override
	public void windowActivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosed(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowClosing(WindowEvent arg0) {
		if (myframe2 != null) {myframe2.dispose();}
		myframe.dispose();
	}

	@Override
	public void windowDeactivated(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowDeiconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowIconified(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

	@Override
	public void windowOpened(WindowEvent arg0) {
		// TODO Auto-generated method stub

	}

}
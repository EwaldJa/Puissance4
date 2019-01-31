package projPuissance4;

import java.awt.Frame;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

/**
 * Un �couteur de fen�tre g�n�rique, permettant de fermer les fen�tres qui lui sont pass�es lorsque 
 * l'utilisateur clique sur la croix
 * 
 * @author Ewald
 *
 */
public class FrameListener implements WindowListener {
	
	/**
	 * Frame principale � fermer
	 */
	private Frame myframe;
	
	/**
	 * Frame secondaire � fermer
	 */
	private Frame myframe2;

	/**
	 * Constructeur � une fen�tre de FrameListener
	 * 
	 * @param frame la fen�tre � �couter
	 * @see FrameListener
	 */
	public FrameListener(Frame frame) {
		myframe = frame;
		myframe2 = null;
	}
	
	/**
	 * Constructeur � dexu fen�tres de FrameListener. il sert quand on veut afficher une FrameVictoire et en
	 * m�me temps garder la FramePuissance4 avec la grille affich�e � la fin de la partie
	 * 
	 * @param frame la fen�tre � �couter
	 * @param frame2 la fen�tre secondaire � fermer
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
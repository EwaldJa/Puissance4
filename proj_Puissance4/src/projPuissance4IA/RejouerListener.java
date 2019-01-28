package projPuissance4IA;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RejouerListener implements ActionListener {
	
	private Jeu jeu;
	private Frame myframe;
	private boolean iaEnabled;

	public RejouerListener(Frame frame, Jeu jeu, boolean iaisEnabled) {
		this.jeu = jeu;
		myframe = frame;
		iaEnabled = iaisEnabled;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		IA ia = null;
		if (iaEnabled){
			ia = new IA('X', jeu.getIA().getDifficulty());
		}
		Jeu newjeu = new Jeu(jeu.getGraphismes(), jeu.getLignes(), jeu.getColonnes(), jeu.getAlignement(), jeu.getTabJoueurs(), iaEnabled, ia);
		if (!newjeu.getGraphismes()) {newjeu.jouer(iaEnabled);}
		myframe.dispose();
	}

}

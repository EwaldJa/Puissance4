package projPuissance4;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RejouerListener implements ActionListener {
	
	private Jeu jeu;
	private Frame myframe;

	public RejouerListener(Frame frame, Jeu jeu) {
		this.jeu = jeu;
		myframe = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		Jeu newjeu = new Jeu(jeu.getGraphismes(), jeu.getLignes(), jeu.getColonnes(), jeu.getAlignement(), jeu.getTabJoueurs());
		if (!newjeu.getGraphismes()) {newjeu.jouer();}
		myframe.dispose();
	}

}

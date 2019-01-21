package projPuissance4;

import java.awt.*;

public class FrameVictoire extends Frame {

	private static final long serialVersionUID = 1L;

	public FrameVictoire(Jeu jeu) {
		this.setSize(550, 200);
		this.setBackground(new Color(164, 168, 165));
		Label lbltxt1 = new Label("Bravo, Joueur " + (jeu.getFlag() + 1) + " !!!!!!!!"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = new Label("Vous venez de gagner cette partie !"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt3 = new Label("Que souhaitez-vous faire à présent ?"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
		
		Button bRejouer = new Button("Rejouer"); bRejouer.setBackground(new Color(242, 201, 157)); bRejouer.addActionListener(new RejouerListener(this, jeu));
		Button bQuitter = new Button("Quitter"); bQuitter.setBackground(new Color(242, 201, 157));; bQuitter.addActionListener(new QuitterListener(this));
		Panel bPanel = new Panel(new GridLayout(1,2,10,10));
		bPanel.add(bRejouer); bPanel.add(bQuitter);
		
		this.setLayout(new GridLayout(4,1,10,10));
		this.add(lbltxt1); this.add(lbltxt2); this.add(lbltxt3); this.add(bPanel);
		this.setTitle("Victoire !!!");
		this.addWindowListener(new FrameListener(this));
		this.setVisible(true);
		this.requestFocus();
	}

}

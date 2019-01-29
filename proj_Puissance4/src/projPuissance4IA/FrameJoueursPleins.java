package projPuissance4IA;

import java.awt.*;

/**
 * Frame notifiant au joueur que lle nombre maximal de joueurs sur la partie a déjà été atteint, et qu'il
 * ne peut plus en rajouter.
 * 
 * @author Ewald
 *
 */
public class FrameJoueursPleins extends Frame {
	
	private static final long serialVersionUID = 1L;

	/**
	 * Contructeur d'une frame notifiant au joueur que le nombre max de joueurs (10) est atteint
	 * 
	 * @see FrameListener
	 * @see Joueur
	 */
	public FrameJoueursPleins() {
		this.setSize(500, 175);
		this.setBackground(new Color(164, 168, 165));
		Label lbltxt1 = new Label("Le nombre de joueurs max (10)"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = new Label("a déjà été atteint ! Veuillez"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt3 = new Label("fermer la fenêtre et lancer le jeu."); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
		this.setLayout(new GridLayout(3,1,10,10));
		this.add(lbltxt1); this.add(lbltxt2); this.add(lbltxt3); 
		this.setTitle("Erreur !!!");
		this.addWindowListener(new FrameListener(this));
		this.setVisible(true);
		this.requestFocus();
	}
}

package projPuissance4IA;

import java.awt.*;

/**
 * Cette frame est appel�e � la fin d'une partie. Elle sert � afficher un message � l'utilisateur en cas de victoire
 * d'un joueur (en mode IA ou Joueurs vs Joueurs), de d�faite du joueur face � l'IA, ou alors d'un match nul.
 * Elle permet �galement de rejouer en gardant la m�me configuration de partie, de recommencer une partie en 
 * reconfigurant, ou de quitter le jeu.
 * 
 * @author Ewald
 */
public class FrameVictoire extends Frame {

	private static final long serialVersionUID = 1L;
	
	private Frame myframe;

	/**
	 * Constructeur d'une FrameVictoire, appel� � la fin d'une partie
	 * @param jeu contr�leeur de jeu actuel, pour r�cuperer les caract�ristiques de la partie, pour pouvoir rejouer
	 * @param iaEnabled bool�en repr�sentant l'activation ou non du mode IA
	 * @param frame la FramePuissance4 affichant la grille, qui sera ferm�e � la fin, mais permet de garder la grille affich�e en fin de partie
	 * @see FrameListener
	 * @see RejouerListener
	 * @see QuitterListener
	 * @see RecommencerListener
	 */
	public FrameVictoire(Jeu jeu, boolean iaEnabled, Frame frame) {
		myframe = frame;
		this.setSize(550, 200);
		this.setBackground(new Color(164, 168, 165));
		Label lbltxt1;
		Label lbltxt2;
		Label lbltxt3;
		if (jeu.verifNul()) {
			lbltxt1 = new Label("Vous venez de faire un match nul !"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
			lbltxt2 = new Label("Vous pouvez mesurer � nouveau votre"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
			lbltxt3 = new Label("talent, ou quitter la partie : "); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
			this.setTitle("Hmm hmm...");
		}
		else {
			if (iaEnabled && jeu.getFlag()==1) {
				lbltxt1 = new Label("Honte � vous, Joueur !"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
				lbltxt2 = new Label("Vous venez de perdre contre l'IA !"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
				lbltxt3 = new Label("Que souhaitez-vous faire � pr�sent ?"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
				this.setTitle("Bouuuuuh !!!");
			}
			else {
				lbltxt1 = new Label("Bravo, Joueur " + (jeu.getFlag() + 1) + " !!!!!!!!"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
				lbltxt2 = new Label("Vous venez de gagner cette partie !"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
				lbltxt3 = new Label("Que souhaitez-vous faire � pr�sent ?"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
				this.setTitle("Victoire !!!");
			}
		}
		
		Button bRejouer = new Button("Rejouer"); bRejouer.setBackground(new Color(242, 201, 157)); bRejouer.addActionListener(new RejouerListener(this, jeu, iaEnabled));
		Button bRecommencer = new Button("Reparam�trer"); bRecommencer.setBackground(new Color(242, 201, 157)); bRecommencer.addActionListener(new RecommencerListener(this));
		Button bQuitter = new Button("Quitter"); bQuitter.setBackground(new Color(242, 201, 157)); bQuitter.addActionListener(new QuitterListener(this));
		Panel bPanel = new Panel(new GridLayout(1,3,10,10));
		bPanel.add(bRejouer); bPanel.add(bRecommencer); bPanel.add(bQuitter);
		
		this.setLayout(new GridLayout(4,1,10,10));
		this.add(lbltxt1); this.add(lbltxt2); this.add(lbltxt3); this.add(bPanel);
		this.addWindowListener(new FrameListener(this, myframe));
		this.setVisible(true);
		this.requestFocus();
	}
	
	/**
	 * M�thode permettant de quitter les deux frames
	 */
	public void quitter() {
		myframe.dispose();
		this.dispose();
	}

}

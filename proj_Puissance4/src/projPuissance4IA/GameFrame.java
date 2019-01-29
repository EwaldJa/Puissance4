package projPuissance4IA;

import java.awt.Frame;

import java.awt.*;

/**
 * Cette classe contient le main. Elle affiche une fenêtre qui permet, au lancement du jeu, de choisir entre un
 * affichage console et un affichage graphique, et entre un mode joueur vs IA ou joueur versus joueur.
 * 
 * @author Ewald
 */
public class GameFrame extends Frame {
	
	
	public static void main(String[] args) {
		new GameFrame();

	}

	private static final long serialVersionUID = 1L;
	
	/**
	 * Checkbox permettant de déterminer le type d'affichage du jeu : graphique (par défaut), ou console
	 */
	private Checkbox vue;

	/**
	 * Constructeur de la frame du début de jeu
	 * @see FrameListener
	 * @see ConfigListener
	 * @see LaunchFrame
	 */
	public GameFrame() {

		this.setSize(500, 300);
		
		this.setLayout(new BorderLayout());
		this.setTitle("Configuration du Puissance 4 !");		
		this.setBackground(new Color(164, 168, 165));
		
		Panel welcomPanel = new Panel(new GridLayout(4,1));
		Panel controlPanel = new Panel(new GridLayout(1,2,10,10));
		
		Label lbltxt1 = new Label("Bienvenue sur le Puissance 4 !"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = new Label("Choisissez de jouer 1v1 contre notre IA, ou "); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 20));
		Label lbltxt3 = new Label("joueurs contre joueurs ! Paramétrez une vue"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 20));
		Label lbltxt4 = new Label("graphique (par défaut) ou console !"); lbltxt4.setFont(new Font("myfont", Font.PLAIN, 20));
		welcomPanel.add(lbltxt1); welcomPanel.add(lbltxt2); welcomPanel.add(lbltxt3); welcomPanel.add(lbltxt4); 
		this.add(welcomPanel, BorderLayout.NORTH);
		
		
		
		vue = new Checkbox("Vue graphique", true);
		Button bLancerIA = new Button("Jouer en 1v1 IA"); bLancerIA.setBackground(new Color(242, 201, 157));
		bLancerIA.addActionListener(new ConfigListener(this, true));
		Button bLancerJJ = new Button("Jouer en JvJ"); bLancerJJ.setBackground(new Color(242, 201, 157));
		bLancerJJ.addActionListener(new ConfigListener(this, false));
		controlPanel.add(vue); controlPanel.add(bLancerIA); controlPanel.add(bLancerJJ);
		
		
		this.add(controlPanel, BorderLayout.SOUTH);
		
		this.addWindowListener(new FrameListener(this));
		
		this.setResizable(false);
		this.setVisible(true);
		this.requestFocus();
	}
	
	public boolean getVue() {
		return this.vue.getState();
	}
}


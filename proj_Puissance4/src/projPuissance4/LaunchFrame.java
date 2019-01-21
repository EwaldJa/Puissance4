package projPuissance4;

import java.awt.*;
import java.util.*;

public class LaunchFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	private ArrayList<String> tabcolor = new ArrayList<String>(Arrays.asList(new String[] {"Rouge", "Jaune", "Cyan", "Vert", "Orange", "Bleu", "Noir", "Magenta", "Rose", "Blanc"}));
	private TextField newlignes,newcolonnes,newobjectif,newmotif;
	private Joueur[] tabjoueurs = {null, null, null, null, null, null, null, null, null, null};
	private Choice choixCouleur = new Choice();
	private Label[][] liste= new Label[10][3];
	private Button bLancer;
	private int nbjoueurs = 0;
	// Methods

	public LaunchFrame() {
		
		this.setSize(500, 500);
		
		this.setLayout(new BorderLayout());
		this.setTitle("Configuration du Puissance 4 !");		
		this.setBackground(new Color(164, 168, 165));
		
		Panel welcomPanel = new Panel(new GridLayout(3,1));
		Panel listePanel = new Panel(new GridLayout(11,3));
		Panel playerPanel = new Panel(new GridLayout(1,4,10,10));
		Panel controlPanel = new Panel(new GridLayout(1,2,10,10));
		Panel optionPanel = new Panel(new GridLayout(1,6,5,5));
		Panel grosPanel = new Panel(new GridLayout(3,1,10,10));
		
		Label lbltxt1 = new Label("Bienvenue sur le Puissance 4 !"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = new Label("Ajoutez des joueurs à la liste ci-dessous via le panel,"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 20));
		Label lbltxt3 = new Label("puis amusez-vous bien dans un belle partie. Joueurs :"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 20));
		welcomPanel.add(lbltxt1); welcomPanel.add(lbltxt2); welcomPanel.add(lbltxt3); 
		this.add(welcomPanel, BorderLayout.NORTH);
		
		listePanel.add(new Label("Numéro")); listePanel.add(new Label("Symbole")); listePanel.add(new Label("Couleur"));
		for (int i = 0; i < 10; i++) {for (int j = 0; j < 3; j++) {liste[i][j] = new Label(""); listePanel.add(liste[i][j]);}}
		this.add(listePanel, BorderLayout.CENTER);
		
		for (int i = 0; i < tabcolor.size(); i++) {choixCouleur.addItem(tabcolor.get(i));}
		Label lblmotif = new Label("Symbole : "); newmotif = new TextField("X",1);
		Button bAddPlayer = new Button("Ajouter joueur"); bAddPlayer.setBackground(new Color(242, 201, 157));
		bAddPlayer.addActionListener(new AjoutJoueurListener(this));
		playerPanel.add(lblmotif);playerPanel.add(newmotif);playerPanel.add(choixCouleur);playerPanel.add(bAddPlayer);
		
		Label lbllignes = new Label("Nb lignes : "); newlignes = new TextField("6",2);
		Label lblcolonnes = new Label("Nb col : "); newcolonnes = new TextField("7",2);
		Label lblobjectif = new Label("Objectif : "); newobjectif = new TextField("4",2);
		optionPanel.add(lbllignes);optionPanel.add(newlignes);
		optionPanel.add(lblcolonnes);optionPanel.add(newcolonnes);
		optionPanel.add(lblobjectif);optionPanel.add(newobjectif);
		
		Label lbllancement = new Label("Après configuration, vous pouvez ensuite ");
		bLancer = new Button("Lancer le jeu !"); bLancer.setBackground(new Color(242, 201, 157));
		bLancer.addActionListener(new LancementListener(this)); bLancer.setEnabled(false);
		controlPanel.add(lbllancement); controlPanel.add(bLancer);
		
		grosPanel.add(playerPanel);grosPanel.add(optionPanel);grosPanel.add(controlPanel);
		this.add(grosPanel, BorderLayout.SOUTH);
		
		this.addWindowListener(new FrameListener(this));
		
		this.setResizable(false);
		this.setVisible(true);
		this.requestFocus();
	}
	
	public int getNbJoueurs() {
		return nbjoueurs;
	}
	
	public void setNbJoueurs(int nb) {
		nbjoueurs = nb;
		if (nbjoueurs >= 2) {bLancer.setEnabled(true);}
	}
	
	public void setTabJoueur(Joueur[] tabj) {
		tabjoueurs = tabj;
	}
	
	public Joueur[] getTabJoueur() {
		return tabjoueurs;
	}
	
	public void setTabColor(ArrayList<String> tabc) {
		tabcolor = tabc;
	}
	
	public Choice getChoixCouleur() {
		return choixCouleur;
	}
	
	public ArrayList<String> getTabColor() {
		return tabcolor;
	}
	
	public Label[][] getListeJoueurs(){
		return liste;
	}
	
	public void setListeJoueurs(Label[][] newlist){
		liste = newlist;
	}
	
	public char getNewMotif() {
		return (newmotif.getText()).charAt(0);
	}
	
	public int getNewLignes() {
		return (Integer.parseInt(newlignes.getText()));
	}
	
	public int getNewColonnes() {
		return (Integer.parseInt(newcolonnes.getText()));
	}
	
	public int getNewObjectif() {
		return (Integer.parseInt(newobjectif.getText()));
	}
}

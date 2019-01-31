package projPuissance4;

import java.awt.*;
import java.util.*;

/**
 * Cette Frame est la seconde affichée au lancement d'une partie après la GameFrame. Elle permet de choisir les caractéristiques de la partie
 * de puissance 4 qui va être jouée.
 * 
 * @author Ewald
 * @see GameFrame
 */
public class LaunchFrame extends Frame {

	private static final long serialVersionUID = 1L;
	
	/**
	 * ArrayList de String représentant les couleurs possibles pour des joueurs
	 * @see ArrayList
	 * @see String
	 * @see Color
	 */
	private ArrayList<String> tabcolor = new ArrayList<String>(Arrays.asList(new String[] {"Rouge", "Jaune", "Cyan", "Vert", "Orange", "Bleu", "Noir", "Magenta", "Rose", "Blanc"}));
	
	/**
	 * ArrayList de String représentant les niveaux de difficulté possibles pour l'IA
	 * @see IA#level
	 * @see ArrayList
	 * @see String
	 */
	private ArrayList<String> tabdifficulte = new ArrayList<String>(Arrays.asList(new String[] {"Facile", "Moyen", "Difficile", "Hardcore"}));
	
	/**
	 * TextField permettant la saisie des caractéristiques de la partie
	 * @see TextField
	 */
	private TextField newlignes,newcolonnes,newobjectif,newmotif;
	
	/**
	 * Tableau représentant les joueurs qui joueront la partie
	 */
	private Joueur[] tabjoueurs = {null, null, null, null, null, null, null, null, null, null}; 
	
	/**
	 * Liste déroulante, permettant de choisir soit la couleur d'un joueur à ajouter, soit 
	 *le niveau de difficulté de l'IA.
	 *
	 *@see IA#Level
	 *@see Joueur#pion#couleur
	 */
	private Choice choixCouleur = new Choice();
	
	/**
	 * Matrice de Label, utile à l'affichage des caractéristiques des joueurs
	 * @see Label
	 */
	private Label[][] liste= new Label[10][3];
	
	/**
	 * Bouton permettant de lancer la partie
	 */
	private Button bLancer;
	
	/**
	 * Compteur de joueurs ajoutés à la partie
	 */
	private int nbjoueurs = 0;
	
	/**
	 * Entier représentant le niveau de l'IA
	 * 
	 * @see IA#level
	 */
	private int ia_difficulty;

	/**
	 * Constructeur de la frame de paramétrage de la partie
	 * 
	 * @param graph représentant le type de vue choisi par le joueur : graphique (true) ou console (false)
	 * @param iaEnabled représentant le mode 1v1 Joueur vs IA, si valeur à true
	 * @see LancementListener
	 * @see AjoutJoueurListener
	 * @see FrameListener
	 */
	public LaunchFrame(boolean graph, boolean iaEnabled) {

		this.setSize(600, 600);
		ia_difficulty = 1;
		
		this.setLayout(new BorderLayout());
		this.setTitle("Configuration du Puissance 4 !");		
		this.setBackground(new Color(164, 168, 165));
		
		Panel welcomPanel = new Panel(new GridLayout(5,1));
		Panel listePanel = new Panel(new GridLayout(11,3));
		Panel playerPanel = new Panel(new GridLayout(1,4,10,10));
		Panel controlPanel = new Panel(new GridLayout(1,2,10,10));
		Panel optionPanel = new Panel(new GridLayout(1,6,5,5));
		Panel grosPanel = new Panel(new GridLayout(3,1,10,10));
		
		
		Label lbltxt1 = new Label("Bienvenue sur le Puissance 4 !"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = null;
		Label lbltxt3 = null;
		Label lbltxt4 = null;
		if (iaEnabled) {
			lbltxt2 = new Label("Vous avez choisi de jouer contre l'IA, choisissez les"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 20));
			lbltxt3 = new Label("paramètres de jeu (taille, etc). Vous ne pouvez malheureusement"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 20));
			lbltxt4 = new Label("pas encore choisir les caractéristiques du Joueur, à venir !"); lbltxt4.setFont(new Font("myfont", Font.PLAIN, 20));
			
			listePanel.add(new Label("Numéro")); listePanel.add(new Label("Symbole")); listePanel.add(new Label("Couleur"));
			liste[0][0] =  new Label("1");liste[0][1] =  new Label("O");liste[0][2] =  new Label("Vert");
			listePanel.add(liste[0][0]);listePanel.add(liste[0][1]);listePanel.add(liste[0][2]);
			for (int i = 1; i < 10; i++) {for (int j = 0; j < 3; j++) {liste[i][j] = new Label(""); listePanel.add(liste[i][j]);}}
			this.add(listePanel, BorderLayout.CENTER);
			
			for (int i = 0; i < tabdifficulte.size(); i++) {choixCouleur.addItem(tabdifficulte.get(i));}
			Label lblmotif = new Label("Difficulté IA : ");
			Button bAddPlayer = new Button("Valider"); bAddPlayer.setBackground(new Color(242, 201, 157));
			bAddPlayer.addActionListener(new AjoutJoueurListener(this, true));
			playerPanel.add(lblmotif);playerPanel.add(choixCouleur);playerPanel.add(bAddPlayer);
		}
		else {
			lbltxt2 = new Label("Vous avez choisi de jouer Joueurs versus Joueurs :"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 20));
			lbltxt3 = new Label("Ajoutez des joueurs à la liste ci-dessous via le panel,"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 20));
			lbltxt4 = new Label("puis amusez-vous bien dans un belle partie. Joueurs :"); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 20));
			
			listePanel.add(new Label("Numéro")); listePanel.add(new Label("Symbole")); listePanel.add(new Label("Couleur"));
			for (int i = 0; i < 10; i++) {for (int j = 0; j < 3; j++) {liste[i][j] = new Label(""); listePanel.add(liste[i][j]);}}
			this.add(listePanel, BorderLayout.CENTER);
			
			for (int i = 0; i < tabcolor.size(); i++) {choixCouleur.addItem(tabcolor.get(i));}
			Label lblmotif = new Label("Symbole : "); newmotif = new TextField("X",1);
			Button bAddPlayer = new Button("Ajouter joueur"); bAddPlayer.setBackground(new Color(242, 201, 157));
			bAddPlayer.addActionListener(new AjoutJoueurListener(this, false));
			playerPanel.add(lblmotif);playerPanel.add(newmotif);playerPanel.add(choixCouleur);playerPanel.add(bAddPlayer);
		}
		Label lbltxt5 = null;
		if (graph) {
			lbltxt5 = new Label("Vous avez choisi une jolie vue graphique !"); lbltxt5.setFont(new Font("myfont", Font.PLAIN, 20));
		}
		else {
			lbltxt5 = new Label("Vous avez choisi une vue console, ouvrez celle-ci pour la suite !"); lbltxt5.setFont(new Font("myfont", Font.PLAIN, 20));
		}
		
		welcomPanel.add(lbltxt1); welcomPanel.add(lbltxt2); welcomPanel.add(lbltxt3); welcomPanel.add(lbltxt4); welcomPanel.add(lbltxt5);
		this.add(welcomPanel, BorderLayout.NORTH);
		
		Label lbllignes = new Label("Nb lignes : "); newlignes = new TextField(Integer.toString(Grille.DEFAULT_LIGNE),2);
		Label lblcolonnes = new Label("Nb col : "); newcolonnes = new TextField(Integer.toString(Grille.DEFAULT_COLONNE),2);
		Label lblobjectif = new Label("Objectif : "); newobjectif = new TextField(Integer.toString(Grille.DEFAULT_ALIGNEMENT),2);
		optionPanel.add(lbllignes);optionPanel.add(newlignes);
		optionPanel.add(lblcolonnes);optionPanel.add(newcolonnes);
		optionPanel.add(lblobjectif);optionPanel.add(newobjectif);
		
		Label lbllancement = new Label("Après configuration, vous pouvez ensuite ");
		bLancer = new Button("Lancer le jeu !"); bLancer.setBackground(new Color(242, 201, 157));
		bLancer.addActionListener(new LancementListener(this, graph, iaEnabled)); bLancer.setEnabled(iaEnabled);
		
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
	
	public void setDifficulty(int diff) {
		ia_difficulty = diff;
	}
	
	public int getDifficulty() {
		return ia_difficulty;
	}
	public Choice getChoixCouleur() {
		return choixCouleur;
	}
	
	public ArrayList<String> getTabDiff(){
		return tabdifficulte;
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

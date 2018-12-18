package puissance4;

import java.util.Scanner;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Grille maGrille;
	//valeur que l'on récupére a chaque fois que l'on ajoute un pion à la grille
	private int[] positionDernierPion;

	public Jeu(Joueur joueur1, Joueur joueur2, Grille maGrille) {
		this.joueur1 = joueur1;
		this.joueur2 = joueur2;
		this.maGrille = maGrille;
		positionDernierPion = new int[2];
		menuConsole();
	}

	public Jeu(Joueur joueur1, Joueur joueur2) {
		this(joueur1, joueur2, new Grille());
	}

	public Jeu() {
		this(new Joueur("Joueur 1", 'X'), new Joueur("Joueur2", 'O'), new Grille());
	}

	public void menuConsole() {
		String res; 
		
		System.out.println("Voulez vous lancer une partie ? O/N");
		Scanner sc = new Scanner(System.in);
		res = sc.nextLine();
		sc.close();
		if(res=="O") {
			//lancer une partie
		}
		else
		{
			System.exit(0);
		}
	}
	
	public void jouerTour(Joueur leJoueur) {
		int colonne; 
		Pion lePion;
		boolean verifColonnePleine = false;
		while (!verifColonnePleine) {
			//tant que l'on ne place pas le pion dans une collone vide on recommence 
			
			System.out.println("Dans quelle colonne voulez vous ajoueter votre pion ? \n");
			System.out.println("Veuillez entrer un nombre entre 1 et" + Grille.NB_COLONNE);    //(ajouter nombre de colonne de notre grille)
			maGrille.affichage();
			Scanner sc = new Scanner(System.in);
			colonne = sc.nextInt();
			sc.close();
			lePion = new Pion(/*Color.WHITE,*/leJoueur.getMotif());
			//On récupére la collone dans laquel le joueur souhaite jouer.
			//et on crée le pion qu'il va placer en fonction de son symbole
			
			
			verifColonnePleine = true;
			try{
				positionDernierPion =  maGrille.placerPion(colonne-1,lePion); //J'ai corrig� l'indice de colonne qui doit commencer � 0 ;)
				
			}catch (IndiceIncorrectException e) {
				//System.out.println("L'indice que vous avez entr� n'existe pas, recommencez.");
				System.out.println(e.getMessage());
				verifColonnePleine = false;
			}catch (ColonnePleineException e) {
				//System.out.println("La colonne que vous essayer de remplir est d�j�pleine !");
				System.out.println(e.getMessage());
				verifColonnePleine = false;
				
			}catch (Exception e) {
				System.out.println("Erreur, placement du pion impossible");
			}
			//On ajoute le pion dans notre grille, si la collone est pleine ou si l'indice entrée n'existe pas dans le tableau on affiche un message et on recommence
			
		}
		
		
	}


	public  boolean partieGagne() {
		int ligne = positionDernierPion[0];
		int colonne = positionDernierPion[1];
		
		boolean l = gagneeLigne(ligne, colonne, maGrille);
		boolean c = gagneeColonne(ligne, colonne, maGrille);
		boolean d = gagneeDiag(ligne, colonne, maGrille);
		boolean ad = gagneeAntiDiag(ligne, colonne, maGrille);

		return false;
	}
	
	private boolean gagneeLigne(int indLigne, int indColonne, Grille g) {
		int ligne = indLigne;
		int colonne =indColonne;
		int cpt=0;
		if(ligne!=0) {
			if(g.getGrille()[ligne][colonne].getMotif() == g.getGrille()[ligne][colonne-1].getMotif()) {
				colonne--;
			}
		}
		for(int i =0;i<Grille.NB_LIGNE;i++) {
			if(cpt==3) {
				return true;
			}
			if(g.getGrille()[ligne][colonne].getMotif() == g.getGrille()[ligne][colonne+1].getMotif()) {
				cpt++;
				colonne++;
			}
			else
			{
				cpt=0;
			}
			
		}
		return false;
	}
	
	public boolean gagneeColonne(int indLigne, int indColonne, Grille g) {
		int ligne = indLigne;
		int colonne =indColonne;
		int cpt=0;
		if(ligne!=0) {
			if(g.getGrille()[ligne][colonne].getMotif() == g.getGrille()[ligne-1][colonne].getMotif()) {
				ligne--;
			}
		}
		for(int i =0;i<Grille.NB_LIGNE;i++) {
			if(cpt==3) {
				return true;
			}
			if(g.getGrille()[ligne][colonne].getMotif() == g.getGrille()[ligne+1][colonne].getMotif()) {
				cpt++;
				ligne++;
			}
			else
			{
				cpt=0;
			}
			
		}
		return false;
		
	}
	
	private boolean gagneeDiag(int indLigne, int indColonne, Grille g) {
		// TODO Auto-generated method stub
		return false;
	}
	
	private boolean gagneeAntiDiag(int indLigne, int indColonne, Grille g) {
		// TODO Auto-generated method stub
		return false;
	}

	
	public void jouerPartie() {
		boolean laPartieGagne = false; 
		Joueur joueurGagnant;
		//implenter un choix alétoire du premier joueurs
		//Certainement grace a des pointeur premierJoueur et secondJoueur qui pointe soit sur joueur1 soit sur joueur2
		
		int nbTour = 0;
		
		while (!laPartieGagne || (nbTour < maGrille.getNbColonne()*maGrille.getNbLigne())) {
			// TODO : verifier si la partie est gagné seulement pour le dernoer pion posé (vérifié seulement autour du pion)
			if (nbTour%2 == 0) {
				jouerTour(joueur1);
			}
			else {
				jouerTour(joueur2);
			}
			laPartieGagne=partieGagne();
			nbTour++;
		}

		if (nbTour == maGrille.getNbColonne()*maGrille.getNbLigne()) {
			System.out.println("C'est un match nul !"); //Attention, il peut gagner sur le coup final !
		}else if((nbTour-1)%2==0) {
			//plus propre si la methode partieGangne me renvois un pointeur vers le gagnant
			 System.out.println("Felicitation " + joueur1.getPseudo() + " vous avez gagnez !");
		}else {
			System.out.println("Felicitation " + joueur2.getPseudo() + " vous avez gagnez !");
		}
	}
}

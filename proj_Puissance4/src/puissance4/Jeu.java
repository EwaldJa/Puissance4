package puissance4;

import java.awt.Color;
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
		if(res == "O") {
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
		boolean verifCollonePleine = false;
		while (verifCollonePleine==false) {
			//tant que l'on ne place pas le pion dans une collone vide on recommence 
			
			System.out.println("Dans quelle colonne voulez vous ajoueter votre pion ? \n");
			System.out.println("Veuilliez entrer un nombre entre 1 et (ajouter nombre de collone de notre grille)" );
			maGrille.affichage();
			Scanner sc = new Scanner(System.in);
			colonne = sc.nextInt();
			lePion = new Pion(Color.WHITE,leJoueur.getMotif());
			//On récupére la collone dans laquel le joueur souhaite jouer.
			//et on crée le pion qu'il va placer en fonction de son symbole
			
			
			verifCollonePleine = true;
			try{
				positionDernierPion =  maGrille.placerPion(colonne,lePion);
				
			}catch (IndiceIncorrectException e) {
				System.out.println("L'indice que vous avez entrez n'existe pas, recommencer");
				verifCollonePleine = false;
			}catch (ColonnePleineException e) {
				System.out.println("La collone que vous essayer de remplir est déjà pleine");
				verifCollonePleine = false;
				
			}catch (Exception e) {
				System.out.println("Placement du pion impossible");
			}
			//On ajoute le pion dans notre grille, si la collone est pleine ou si l'indice entrée n'existe pas dans le tableau on affiche un message et on recommence
			
		}
		
		
	}

	public  boolean partieGagne() {

		//TODO : implémenter cette methode

		return false;
	}
	
	public void jouerPartie() {
		boolean laPartieGagne = false; 
		Joueur joueurGagnant;
		//implenter un choix alétoire du premier joueurs
		//Certainement grace a des pointeur premierJoueur et secondJoueur qui pointe soit sur joueur1 soit sur joueur2
		
		int nbTour = 0;
		
		while (!laPartieGagne || (maGrille.getNbColonne()*maGrille.getNbLigne()==nbTour)) {
			if (nbTour%2 == 0) {
				jouerTour(joueur1);
			}
			else {
				jouerTour(joueur2);
			}
			laPartieGagne=partieGagne();
			nbTour++;
		}
		
		if((nbTour-1)%2==0) {
			//plus propre si la methode partieGangne me renvois un pointeur vers le gagnant
			 System.out.println("Felicitation " + joueur1.getPseudo() + " vous avez gagnez ! ");
		}else {
			System.out.println("Felicitation " + joueur2.getPseudo() + " vous avez gagnez ! ");
		}
	}
}

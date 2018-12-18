package puissance4;

import java.awt.Color;
import java.util.Scanner;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Grille maGrille;
	
	public Jeu() {
		joueur1 = new Joueur("Joueur1",'X');
		joueur2 = new Joueur("Joueur2",'O');
		//Créer une nouvelle grille
		menuConsole();
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
		int collone; 
		Pion lePion;
		boolean verifCollonePleine = false;
		while (verifCollonePleine==false) {
			//tant que l'on ne place pas le pion dans une collone vide on recommence 
			System.out.println("Dans quelle colonne voulez vous ajoueter votre pion ? \n");
			System.out.println("Veuilliez entrer un nombre entre 1 et (ajouter nombre de collone de notre grille)" );
			Scanner sc = new Scanner(System.in);
			collone = sc.nextInt();
			lePion = new Pion(Color.WHITE,leJoueur.getMotif());
			//On récupère la collone dans laquel le joueur souhaite jouer.
			//et on crée le pion qu'il va placer en fonction de son symbole 
			
			verifCollonePleine = maGrille.placerPion(collone,lePion);
			//On ajoute le pion dans notre grille, si la collone est pleine on affiche un message et on recommence 
			if (verifCollonePleine==false) {
				System.out.println("La collone dans laquelle vous voulez placer le pion est pleine, recommencer");
			}
		}
		
		
	}
	
	public void jouerPartie() {
		boolean laPartieGagne = false; 
		Joueur joueurGagnant;
		//implenter un choix alétoire du premier joueurs
		//Certainement grace a des pointeur premierJoueur et secondJoueur qui pointe soit sur joueur1 soit sur joueur2
		
		int nbTour = 0;
		
		while (laPartieGagne = false) {
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
			System.out.println("Felicitation " + joueur1.getPseudo() + " vous avez gagnez ! ");
		}
	}
	
	public  boolean partieGagne() {
		return false;
	}
}

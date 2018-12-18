package puissance4;

import java.awt.Color;
import java.util.Scanner;

public class Jeu {
	private Joueur joueur1;
	private Joueur joueur2;
	private Grille maGrille;
	private int[] positionDernierPion;//valeur que l'on récupère a chaque fois que l'on ajoute un pion à la grille
	
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
		int colonne; 
		Pion lePion;
		boolean verifCollonePleine = false;
		while (verifCollonePleine==false) {
			//tant que l'on ne place pas le pion dans une collone vide on recommence 
			
			System.out.println("Dans quelle colonne voulez vous ajoueter votre pion ? \n");
			System.out.println("Veuilliez entrer un nombre entre 1 et (ajouter nombre de collone de notre grille)" );
			grille.afficher();
			colonne = sc.nextInt();
			lePion = new Pion(Color.WHITE,leJoueur.getMotif());
			//On récupère la collone dans laquel le joueur souhaite jouer.
			//et on crée le pion qu'il va placer en fonction de son symbole 
			
			
			verifCollonePleine = true;
			try{
				dernierPion =  maGrille.placerPion(colonne,lePion);
				
			}
			catch (IndiceIncorrectException e) {
				System.out.println("L'indice que vous avez entrez n'existe pas, recommencer");
				verifCollonePleine = false;
			}
			catch (ColonnePleineException e) {
				System.out.println("La collone que vous essayer de remplir est déjà pleine");
				verifCollonePleine = false;
				
			}
			//On ajoute le pion dans notre grille, si la collone est pleine ou si l'indice entrée n'existe pas dans le tableau on affiche un message et on recommence 
			
		}
		
		
	}
	
	public void jouerPartie() {
		boolean laPartieGagne = false; 
		Joueur joueurGagnant;
		//implenter un choix alétoire du premier joueurs
		//Certainement grace a des pointeur premierJoueur et secondJoueur qui pointe soit sur joueur1 soit sur joueur2
		
		int nbTour = 0;
		
		while (laPartieGagne = false || maGrille.NB_COLONNE * maGrille.NB_LIGNE==nbTour) {
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
			System.out.println("Felicitation " + joueur1.getPseudo() + " vous avez gagnez ! ");//plus propre si la methode partieGangne me renvois un pointeur vers le gagnant
		}
	}
	
	public  boolean partieGagne() {
		return false;
	}
}

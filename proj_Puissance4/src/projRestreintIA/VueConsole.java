package projRestreintIA;

import java.util.Scanner;

public class VueConsole {

	private Grille grille;
	private int flag;
	private Joueur j1,j2;
	private IA ia;
	
	public VueConsole() {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 =  new Scanner(System.in);
		System.out.println("Veuillez choisir la hauteur de la grille :");
		int a= sc.nextInt();
		System.out.println("Veuillez maintenant choisir la largeur de la grille :");
		int b = sc.nextInt();
		this.grille= new Grille(b,a);
		this.flag=0;
		System.out.println("Veuillez choisir votre motif joueur 1 : \n (Il s'agît d'un charactère)\n");
		String s = sc2.nextLine();
		char c = s.charAt(0);
		this.j1=new Joueur(c);
		System.out.println("Maintenant au tour du joueur 2 de choisir : \n");
		s= sc2.nextLine();
		char c1=s.charAt(0);
		this.j2=new Joueur(c1);
		j1.setJSuivant(j2);
	}
	public VueConsole(Joueur j1) {
		Scanner sc = new Scanner(System.in);
		Scanner sc2 =  new Scanner(System.in);
		System.out.println("Bienvenue dans le mode Humain VS IA \nVeuillez choisir la hauteur de la grille :");
		int a= sc.nextInt();
		System.out.println("Veuillez maintenant choisir la largeur de la grille :");
		int b = sc.nextInt();
		this.grille= new Grille(b,a);
		this.flag=0;
		System.out.println("Veuillez choisir votre motif joueur 1 : \n (Il s'agît d'un charactère)\n");
		String s = sc2.nextLine();
		char c = s.charAt(0);
		j1.setMotif(c);
		this.j1 = j1;
		System.out.println("Veuillez choisir un niveau de difficulté pour l'IA (entre 1 et 3)\n");
		int i= sc2.nextInt();
		this.ia= new IA('X',i);
		ia.setJSuivant(j1);
		j1.setJSuivant(ia);
	}
	public void SetGrille(Grille g, int f,Joueur j1, Joueur j2) {
		this.grille= g;
		this.flag=f;
		this.j1=j1;
		this.j2=j2;
	}
	public Grille getGrille() {
		return this.grille;
	}
	public void update() {
		Scanner sc = new Scanner(System.in);
		System.out.println(grille.toString());
		System.out.println("Dans quelle colonne voulez vous jouer ? \n");
		int col = sc.nextInt();
		try {
		if(flag==0) {
			grille.AjouterPion(col-1, j1);
			flag=1;
		}
		else {
			grille.AjouterPion(col-1, j2);
			flag=0;
		}} catch(HorsPlateauException e) {
			System.out.println(e.getMessage());
		}
		catch(ColonnePleineException e) {
			System.out.println(e.getMessage());
		}
		
	}
	public void update2() {
		Scanner sc = new Scanner(System.in);
		System.out.println(grille.toString());
		try {
		if(flag==0) {
			System.out.println("Dans quelle colonne voulez vous jouer ? \n");
			int col = sc.nextInt();
			grille.AjouterPion(col-1, j1);
			flag=1;
		}
		else {
			this.SetGrille(ia.jouer(grille), 0, j1, ia);
		}} catch(HorsPlateauException e) {
			System.out.println(e.getMessage());
		}
		catch(ColonnePleineException e) {
			System.out.println(e.getMessage());
		}
		
	}
}

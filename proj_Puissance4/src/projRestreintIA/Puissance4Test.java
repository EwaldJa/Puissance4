package projRestreintIA;

import java.util.Scanner;

public class Puissance4Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.println("Quel mode voulez vous jouer ?\n");
		System.out.println("1 pour PlayerVSPlayer\n");
		System.out.println("2 pour PlayerVSIA\n");
		int a = sc.nextInt();
		if(a==1) {
			VueConsole vue = new VueConsole();
			while(!vue.getGrille().over()) {
				vue.update();
			}
			vue.getGrille().toString();
		}
		if(a==2) {
			Joueur j1=new Joueur();
			VueConsole vue = new VueConsole(j1);
			while(!vue.getGrille().over()) {
				vue.update2();
			}
			vue.getGrille().toString();
		}
	}	

}

package projPuissance4IA;

import java.util.ArrayList;
import java.util.Random;

public class Etat {
	private Grille grille;
	private Joueur joueur;
	private int nbVisite;
	private double score;
	
	public Etat() {
		this.nbVisite=0;
		this.score=0;
	}
	
	public Etat(Grille grille) {
		this.grille=grille;
		this.nbVisite=0;
		this.score=0;
	}
	public ArrayList<Etat> getEtatPossible() throws HorsPlateauException, ColonnePleineException
	{
		ArrayList<Etat> TabEtat = new ArrayList<Etat>();
		for(int i=0;i<this.grille.getNbColonne();i++) {
			if(this.grille.getHeight(i)<this.grille.getNbLigne()) {
				Grille g = this.grille.clone();
				g.AjouterPion(i, joueur);
				Etat e= new Etat();
				e.setGrille(g);
				TabEtat.add(e);
				g=null;
			}
			
		}
		return TabEtat;
	}
	public void randomMove() throws HorsPlateauException, ColonnePleineException {
		ArrayList<Etat> TabEtat=this.getEtatPossible();
		Random rdObj= new Random();
		boolean f=true;
		/*while(f) {
			int rdCol = rdObj.nextInt(this.grille.getNbCol());
			if(grille.getHeight(rdCol)<grille.getNbLigne()) {
				grille.AjouterPion(rdCol, joueur);
				this.joueur=this.joueur.getSuivant();
			}
			f=false;
		}*/
		if(TabEtat.size()>0) {
			while(f) {
				int rdIndex = rdObj.nextInt(TabEtat.size());
				if(grille.getHeight(TabEtat.get(rdIndex).getGrille().getDerniereColonne())<grille.getNbLigne()) {
					this.grille = TabEtat.get(rdIndex).getGrille();
					f=false;
				}
			}
			
		this.joueur = joueur.getSuivant();
		}
		else {
			System.out.println(this.getGrille().toString());
		}
		
	}
	public int randomPartie(Joueur joueur) throws HorsPlateauException, ColonnePleineException {
		this.joueur=joueur;
		while(!this.getGrille().over()) {
			this.randomMove();
		}
		if(this.joueur == joueur) {
			return 0;
		}
		else {
			return 1;
		}
	}

	public Grille getGrille() {
		return grille;
	}

	public void setGrille(Grille grille) {
		this.grille = grille;
	}

	public Joueur getJoueur() {
		return joueur;
	}

	public void setJoueur(Joueur joueur) {
		this.joueur = joueur;
	}

	public int getNbVisite() {
		return nbVisite;
	}

	public void setNbVisite(int nbVisite) {
		this.nbVisite = nbVisite;
	}

	public double getScore() {
		return score;
	}

	public void setScore(double score) {
		this.score = score;
	}
	
}


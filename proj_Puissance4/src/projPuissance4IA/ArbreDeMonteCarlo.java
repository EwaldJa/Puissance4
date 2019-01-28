package projPuissance4IA;
import java.util.ArrayList;

public class ArbreDeMonteCarlo {
	int niveauDiff;
	Joueur joueur;
	Joueur joueur2;
	public ArbreDeMonteCarlo(int i,Joueur joueur,Joueur joueur2) {
		this.niveauDiff=i;
		this.joueur=joueur;
		this.joueur2=joueur2;
		
	}
	
	public Grille FindNextMove(Grille grille, Joueur joueur) throws HorsPlateauException, ColonnePleineException {
		int nbBoucle=niveauDiff*10000;
		Arbre arbre= new Arbre(grille);
		Noeud noeudRacine=arbre.getNoeud();
		noeudRacine.getEtat().setGrille(grille);
		noeudRacine.getEtat().setJoueur(joueur);
		for(int i=0;i<grille.getNbColonne();i++) {
			Grille gtest= grille.clone();
			if(gtest.getHeight(i)<gtest.getNbLigne()) {
				gtest.AjouterPion(i,joueur.getSuivant());
				if(gtest.verifGagne()) {
					grille.AjouterPion(i, joueur);
					return grille;
				}
			}
		}
		for(int i=0;i<nbBoucle;i++) {
			  if(noeudRacine.getTabEnfant().size()==0) {
				expand(noeudRacine);
			  }
				Noeud meilleurEnfant= selectPromisingNode(noeudRacine);
		           if (!meilleurEnfant.getEtat().getGrille().over()) {
		        	   if(meilleurEnfant.getTabEnfant().size()==0) {
		                     expand(meilleurEnfant);
		        	   		}
		                 }
		                 Noeud nodeToExplore = meilleurEnfant;
		                 if (meilleurEnfant.getTabEnfant().size() > 0) {
		                     nodeToExplore = meilleurEnfant.getRandomEnfant();
		                 }
				Etat e= nodeToExplore.getEtat();
				int resultat=e.randomPartie(joueur);
				nodeToExplore.setEtat(e);
				backPropagation(nodeToExplore,resultat);
		}
		Noeud meilleurNoeud=noeudRacine.getMeilleurEnfant();
		arbre.setRacine(meilleurNoeud);
		return meilleurNoeud.getEtat().getGrille();
	}

	private void expand(Noeud no) throws HorsPlateauException, ColonnePleineException {
		ArrayList<Noeud> tabNoeud=new ArrayList<Noeud>();
		ArrayList<Etat> tabEtat=no.getEtat().getEtatPossible();

		for(int i=0;i<tabEtat.size();i++) {
			Noeud n = new Noeud();
			n.setEtat(tabEtat.get(i));
			n.setParent(no);
			n.getEtat().setJoueur(joueur.getSuivant());;
			
			tabNoeud.add(n);
		}
		no.setTabEnfant(tabNoeud);
	}
	private Noeud selectPromisingNode(Noeud rootNode) {
	    Noeud node = rootNode;
	    while (node.getTabEnfant().size() != 0) {

	        node = UCT.findBestNodeWithUCT(node);
	    }
	    return node;
	}
	public void backPropagation(Noeud n, int resultat) {
		while(n!=null) {
			n.getEtat().setNbVisite(n.getEtat().getNbVisite()+1);
			n.getEtat().setScore(n.getEtat().getScore()+resultat);
			n=n.getParent();
		}
	}
}


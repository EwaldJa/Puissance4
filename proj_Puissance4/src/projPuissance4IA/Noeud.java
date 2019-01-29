package projPuissance4IA;

import java.util.ArrayList;
import java.util.Random;

/**
 * Permet de représenter un noeud possible pour l'IA
 * 
 * @author Luca
 */
public class Noeud {
	private Etat etat;
	private Noeud parent;
	private ArrayList<Noeud> TabEnfant;
	public Noeud() {
		this.etat=new Etat();
		this.TabEnfant= new ArrayList<Noeud>();
	}
	public Noeud(Grille g) {
		this.etat=new Etat(g);
		this.TabEnfant= new ArrayList<Noeud>();
	}
	public Etat getEtat() {
		return etat;
	}
	public void setEtat(Etat etat) {
		this.etat = etat;
	}
	public Noeud getParent() {
		return parent;
	}
	public void setParent(Noeud parent) {
		this.parent = parent;
	}
	public ArrayList<Noeud> getTabEnfant() {
		return TabEnfant;
	}
	public void setTabEnfant(ArrayList<Noeud> tabEnfant) {
		TabEnfant = tabEnfant;
	}
	public Noeud getRandomEnfant() {
		// 
		Random rd=new Random();
		int rdIndex=rd.nextInt(this.TabEnfant.size());
		return this.TabEnfant.get(rdIndex);
	}
	public Noeud getMeilleurEnfant() {
		//
		Noeud n = new Noeud();
		for(int i=0;i<this.TabEnfant.size();i++) {
			if(n.getEtat().getScore()<this.TabEnfant.get(i).getEtat().getScore()) {
				n=this.TabEnfant.get(i);
			}
		}

        return n;
          
	}
	
	
	

}


package projRestreintIA;

import java.util.Collections;
import java.util.Comparator;

public class UCT {

	public static double UCTvalue(int TotalVisite,double nbWin,int nbVisite) {
		if(nbVisite==0) {
			return Integer.MAX_VALUE;
		}
		else {
			return ((double)nbWin /(double)nbVisite ) + 1.41*(Math.log(TotalVisite)/(double)nbVisite);
		}
	}
    public static Noeud findBestNodeWithUCT(Noeud n) {
        int parentVisit = n.getEtat().getNbVisite();
        return Collections.max(
          n.getTabEnfant(),
          Comparator.comparing(c -> UCTvalue(parentVisit, 
            c.getEtat().getScore(), c.getEtat().getNbVisite())));
    }
}

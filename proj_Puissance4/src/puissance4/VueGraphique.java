package puissance4;

public class VueGraphique extends Vue {
	
	private FramePuissance4 frame;
	
	public VueGraphique() {
		this.frame = new FramePuissance4();
	}
	
	public void affichage(Grille grille) {
		frame.affichage(grille);
	}
	
	public FramePuissance4 getFrame() {
		return frame;
	}

}

package projPuissance4;

public class VueGraphique extends Vue {
	
	private FramePuissance4 frame;
	
	public VueGraphique(Jeu jeu) {
		frame = new FramePuissance4(jeu);
	}
	
	public void afficher() {
		frame.affichage();
	}
	
	public FramePuissance4 getFrame() {
		return frame;
	}
	
	public void dispose() {
		frame.dispose();
	}

}

package projPuissance4IA;

public class VueGraphique extends Vue {
	
	private FramePuissance4 frame;
	
	public VueGraphique(Jeu jeu, boolean iaEnabled) {
		frame = new FramePuissance4(jeu, iaEnabled);
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

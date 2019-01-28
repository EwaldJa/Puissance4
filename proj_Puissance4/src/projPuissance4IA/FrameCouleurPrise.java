package projPuissance4IA;

import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.Label;

public class FrameCouleurPrise extends Frame {

	private static final long serialVersionUID = 1L;
	
	public FrameCouleurPrise(String couleur) {
		this.setSize(550, 175);
		this.setBackground(new Color(164, 168, 165));
		Label lbltxt1 = new Label("La couleur " + couleur + " a déjà été"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt2 = new Label("sélectionnée pour un joueur. Veuillez"); lbltxt2.setFont(new Font("myfont", Font.PLAIN, 30));
		Label lbltxt3 = new Label("fermer la fenêtre et corriger."); lbltxt3.setFont(new Font("myfont", Font.PLAIN, 30));
		this.setLayout(new GridLayout(3,1,10,10));
		this.add(lbltxt1); this.add(lbltxt2); this.add(lbltxt3); 
		this.setTitle("Erreur !!!");
		this.addWindowListener(new FrameListener(this));
		this.setVisible(true);
		this.requestFocus();
	}

}

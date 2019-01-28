package projPuissance4IA;

import java.awt.*;

public class FrameErreur extends Frame {
	
	private static final long serialVersionUID = 1L;

	public FrameErreur(String message) {
		this.setSize(550, 400);
		this.setBackground(new Color(164, 168, 165));
		Label lbltxt1 = new Label("Vous venez de rencontrer une erreur :"); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 30));
		TextArea errMessage = new TextArea(message, 10, 50);
		Label lbltxt2 = new Label("Prenez en connaissance puis quittez la fenêtre."); lbltxt1.setFont(new Font("myfont", Font.PLAIN, 20));
		this.setLayout(new GridLayout(3,1,10,10));
		this.add(lbltxt1); this.add(errMessage); this.add(lbltxt2);
		this.setTitle("Erreur !!!");
		this.addWindowListener(new FrameListener(this));
		this.setVisible(true);
		this.requestFocus();
	}

}

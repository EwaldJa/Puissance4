package projPuissance4IA;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ConfigListener implements ActionListener {

	private GameFrame myframe;
	boolean iaEnabled;
	public ConfigListener(GameFrame gameFrame, boolean iaisEnabled) {
		myframe = gameFrame;
		iaEnabled = iaisEnabled;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		new LaunchFrame(myframe.getVue(), iaEnabled);
		myframe.dispose();
	}

}

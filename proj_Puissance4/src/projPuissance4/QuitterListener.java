package projPuissance4;

import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class QuitterListener implements ActionListener {
	
	private Frame myframe;

	public QuitterListener(Frame frame) {
		myframe = frame;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		myframe.dispose();
	}

}

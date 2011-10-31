package button;

import java.awt.event.MouseEvent;

import javax.swing.SwingUtilities;

/**
 * @author seka
 * 
 */
public class CommandButtonMouseListener implements java.awt.event.MouseListener {


	@Override
	public void mousePressed(MouseEvent event) {

		if (event.getSource().getClass() == (CommandButtonStart.class)) {
			CommandButtonStart button = (CommandButtonStart) event.getSource();
			if (SwingUtilities.isLeftMouseButton(event)) {
				
				button.starteSpiel();
			}
		}else if (event.getSource().getClass() == (CommandButtonReset.class)) {
			CommandButtonReset button = (CommandButtonReset) event.getSource();
			if (SwingUtilities.isLeftMouseButton(event)) {
				button.starteSpielNeu();
			}
		}
	}

//nicht benutzte Methoden des Interface	
	
	@Override
	public void mouseReleased(MouseEvent arg0) {
		// nix
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// nix
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// nix
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// nix
	}
}

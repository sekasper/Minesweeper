package View;

import java.awt.event.MouseEvent;
import javax.swing.JButton;
import javax.swing.SwingUtilities;
import Controller.GameController;

public class RestartButtonListener implements java.awt.event.MouseListener {
	
	private GameController controller;
	
	RestartButtonListener(GameController controller){
		this.controller = controller;
	}
	
	
		@Override
		public void mousePressed(MouseEvent event) {

			if (SwingUtilities.isLeftMouseButton(event)) {
				controller.restartGame();
			}		
		}

		// nicht benutzte Methoden des Interface

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

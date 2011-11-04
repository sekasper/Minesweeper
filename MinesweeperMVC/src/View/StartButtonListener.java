package View;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.SwingUtilities;
import Controller.GameAdministrationController;

public class StartButtonListener implements MouseListener {
	
	private GameAdministrationController administrationContr;
	
	StartButtonListener(GameAdministrationController administrationContr){
	this.administrationContr = administrationContr;
	}
	
	
		@Override
		public void mousePressed(MouseEvent event) {
			if (SwingUtilities.isLeftMouseButton(event)) {
				administrationContr.handleStartButtonEvent();
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

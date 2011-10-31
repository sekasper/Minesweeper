package button;

import java.awt.event.MouseEvent;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

import window.FensterSpiel;

/**
 * @author seka
 * 
 */
public class FeldMouseListener implements java.awt.event.MouseListener {

	@Override
	public void mousePressed(MouseEvent event) {// Später in Klassen lösen

		Feld button = (Feld) event.getSource();
		String command = button.getActionCommand();
		if (SwingUtilities.isLeftMouseButton(event) && button.isEnabled()) {
			if (button.isMine()) {
				button.getSpielfeld().getFenster().niederlage(button);
			} else {
				button.zeigeFeldwert();
				System.out.println(command + "leftClick");
				if(button.getSpielfeld().checkAufgedeckteFelder()){
					button.getSpielfeld().getFenster().sieg(button);
				}
			}
		} else if (SwingUtilities.isRightMouseButton(event)) {
			if (button.getIcon() != null) {
				button.setIcon(null);
			} else if (button.isEnabled()) {
				button.setIcon((Icon) new ImageIcon("images/flagge.gif"));
			}
		}
	}

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

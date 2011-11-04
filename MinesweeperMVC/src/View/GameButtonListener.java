package View;

import java.awt.event.MouseEvent;
import javax.swing.SwingUtilities;

import Controller.GameController;

/**
 * @author seka
 * 
 */
public class GameButtonListener implements java.awt.event.MouseListener {
	private GameController controller;

	GameButtonListener(GameController gameContr) {
		this.controller = gameContr;
	}

	@Override 
	public void mousePressed(MouseEvent event) {// Später in Klassen lösen
		GameButton button = (GameButton) event.getSource();
		if (SwingUtilities.isLeftMouseButton(event) && button.isEnabled()) {
			controller.SquareEventLeftClick(button, true);
			Integer buttonX = button.getThisX();
			Integer buttonY = button.getThisY();
			System.out.println(buttonY+""+buttonX);
		} else if (SwingUtilities.isRightMouseButton(event) && button.isEnabled()) {
			controller.SquareEventLeftClick(button, false);
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

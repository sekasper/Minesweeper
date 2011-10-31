package window;

import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

import spiel.Spielfeld;


public class SpielfeldSchlieﬂen implements WindowListener{

	@Override
	public void windowOpened(WindowEvent e) {
		//nix
		
	}

	@Override
	public void windowClosing(WindowEvent e) {
		if((e.getSource().getClass()) == FensterSpiel.class){
			Spielfeld spielfeld = (Spielfeld)((FensterSpiel)e.getSource()).getSpielfeld();
			spielfeld.getSpielinstanz().removeSpielfeld(spielfeld);
		}

	}

	@Override
	public void windowClosed(WindowEvent e) {
		// nix

	}

	@Override
	public void windowIconified(WindowEvent e) {
		// nix
		
	}

	@Override
	public void windowDeiconified(WindowEvent e) {
		// nix
		
	}

	@Override
	public void windowActivated(WindowEvent e) {
		// nix
		
	}

	@Override
	public void windowDeactivated(WindowEvent e) {
		// nix
		
	}

	public static void reset(FensterSpiel spielinstanz) {
		// nix
		
	}
}

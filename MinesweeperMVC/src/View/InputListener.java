package View;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

import Model.GamekonfigValidator;

public class InputListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent event) {
		String string = ((JTextField) event.getSource()).getText();
		if (string.equals("Zahl < 60 eingeben!")||string.equals("Zahl < 20 eingeben!")||string.equals("Zahl eingeben!")||string.equals("Zahl < x*y eingeben!")) {
			((JTextField) event.getSource()).setText("");
		}
	}


	@Override
	public void focusLost(FocusEvent event) {
		String string = ((JTextField) event.getSource()).getText();
		if (!(string == null)) {
			try {
				Integer eingabewert = Integer.valueOf(string);

				if (((JTextField) event.getSource()).getName().equals("minen")) {
					
					if (eingabewert > 400){//ungünstige Prüfung, da maximale Minianzahl von der Spielfeldgröße abhängig ist. Die Values für die Kantenlängen werden jedoch u.U. erst nach der Minenanzahl vom Spieler eingegeben.
						((JTextField) event.getSource()).setText("Zahl < x*y eingeben!");
					}
				}
				else{
					if (!GamekonfigValidator.validateKantenlaenge(eingabewert)) {
						((JTextField) event.getSource()).setText("Zahl < 20 eingeben!");
					}
				}
				

			} catch (NumberFormatException e) {
				((JTextField) event.getSource()).setText("Zahl eingeben!");
			}
		}
	}
}

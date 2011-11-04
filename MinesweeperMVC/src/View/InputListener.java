package View;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class InputListener implements FocusListener {

	@Override
	public void focusGained(FocusEvent event) {
		String minenString = ((JTextField) event.getSource()).getText();
		if (minenString.equals("Zahl < 60 eingeben!")) {
			((JTextField) event.getSource()).setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		String minenString = ((JTextField) event.getSource()).getText();
		if (!(minenString == null)) {
			try {
				Integer eingabewert = Integer.valueOf(minenString);

				if (((JTextField) event.getSource()).getName().equals("minen")) {
					System.out.println("sdlfaklbhfl");
					if (eingabewert > 60) {
						((JTextField) event.getSource()).setText("Zahl < 60 eingeben!");
					}
				}
				else{
					if (eingabewert > 11) {
						((JTextField) event.getSource()).setText("Zahl < 10 eingeben!");
					}
				}
				

			} catch (NumberFormatException e) {
				((JTextField) event.getSource()).setText("Zahl < 60 eingeben!");
			}
		}
	}
}

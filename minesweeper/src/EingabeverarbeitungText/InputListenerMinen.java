package EingabeverarbeitungText;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class InputListenerMinen implements FocusListener {

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
				Integer minenInteger = Integer.valueOf(minenString);
				
				System.out.println(((JTextField) event.getSource()).getClass());
				if (minenInteger > 60) {
					((JTextField) event.getSource()).setText("Zahl < 60 eingeben!");
				}

			} catch (NumberFormatException e) {
				((JTextField) event.getSource()).setText("Zahl < 60 eingeben!");
			}
		}
	}
}

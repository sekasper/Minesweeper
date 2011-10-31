package EingabeverarbeitungText;

import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class InputListenerAchse implements FocusListener {

	@Override
	public void focusGained(FocusEvent event) {
		String minenString = ((JTextField) event.getSource()).getText();
		if (minenString.equals("Zahl < 10 eingeben!")) {
					((JTextField) event.getSource()).setText("");
		}
	}

	@Override
	public void focusLost(FocusEvent event) {
		String achseString = ((JTextField) event.getSource()).getText();
		
		if (achseString != null) {
			try {
				Integer achseInteger = Integer.valueOf(achseString);
				
				if (achseInteger > 11) {
					((JTextField) event.getSource()).setText("Zahl < 10 eingeben!");
				}

			} catch (NumberFormatException e) {
				((JTextField) event.getSource()).setText("Zahl < 10 eingeben!");
			}
		}
	}
}

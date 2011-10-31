package button;

import java.awt.Dimension;
import javax.swing.AbstractButton;
import window.FensterSpiel;

public class CommandButtonReset extends CommandButton{
	
		static final long serialVersionUID = 0L;
		private FensterSpiel spielFenster;
		// Constructor

		public CommandButtonReset(String funktion, FensterSpiel fensterSpiel) {
			super(funktion, fensterSpiel);
			this.spielFenster = fensterSpiel;
		}

		@Override public void definiereButton() {
			this.setVerticalTextPosition(AbstractButton.CENTER);
			this.setHorizontalTextPosition(AbstractButton.RIGHT);
			this.setEnabled(true);
			this.setActionCommand("starte Spiel");
			this.setPreferredSize(new Dimension(140,20));
		}

		// Exemplarmethoden
	public void starteSpielNeu(){	
		this.spielFenster.getSpielfeld().reset();
		}
	}


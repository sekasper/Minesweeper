package button;

import java.awt.Dimension;

import javax.swing.AbstractButton;

import spiel.Spielinterface;

public class CommandButtonStart extends CommandButton{
	
	static final long serialVersionUID = 0L;
	private Spielinterface spielinstanz;
	// Constructor

	public CommandButtonStart(String funktion, Spielinterface spielinstanz) {
		super(funktion, spielinstanz);
		this.spielinstanz = spielinstanz;
		spielinstanz.getSpielmenue().wirdMinesweeperButton(this);
	}

	@Override public void definiereButton() {
		this.setVerticalTextPosition(AbstractButton.CENTER);
		this.setHorizontalTextPosition(AbstractButton.RIGHT);
		this.setEnabled(true);
		this.setActionCommand("starte Spiel");
		this.setPreferredSize(new Dimension(140,20));
	}

	// Exemplarmethoden
	public void starteSpiel() {

		try{
		Integer kanteX = (Integer) new Integer(this.getSpielinstanz().getSpielmenue().getxAchse().getText());
		Integer kanteY = (Integer) new Integer(this.getSpielinstanz().getSpielmenue().getyAchse().getText());
		Integer minen = (Integer) new Integer(this.getSpielinstanz().getSpielmenue().getMinen().getText());	
		this.setText("Starte noch eins!");
		spielinstanz.erstelleSpielfeld(kanteX,kanteY,minen);			
		}
		catch(java.lang.NumberFormatException e){
		}
	
		

		}

	public Spielinterface getSpielinstanz() {
		return spielinstanz;
	}

	public void setSpielinstanz(Spielinterface spielinstanz) {
		this.spielinstanz = spielinstanz;
	}
	
}

package spiel;

import java.util.ArrayList;
import button.CommandButtonReset;
import button.CommandButtonStart;
import config.ISpielkonfig;
import config.SpielkonfigQuadratisch;
import config.SpielkonfigRechteckig;
import config.SpielkonfigValidator;

import window.FensterMenue;

public class Spielinterface {

	private FensterMenue spielmenue;
	private ArrayList<Spielfeld> spielfelder = new ArrayList<Spielfeld>();
	private Integer nummer = 1;
	private CommandButtonStart startbutton;
	private CommandButtonReset resetbutton;

	protected Spielinterface() {
		this.spielmenue = new FensterMenue("Spielverwaltung");
		this.startbutton = new CommandButtonStart("neues Spiel", this);
		this.spielmenue.fensterSichtbarMachen();
	}

	Integer getSpielfelderanzahl() {
		return spielfelder.size();
	}


	public void erstelleSpielfeld(Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		boolean valid1 = SpielkonfigValidator.validateKantenlaengeX(kantenlaengeX);
		boolean valid2 = SpielkonfigValidator.validateKantenlaengeY(kantenlaengeY);
		boolean valid3 = SpielkonfigValidator.validateMinenanzahl(anzahlMinen,kantenlaengeX,kantenlaengeY);
		if (this.nummer < 5 && valid1 && valid2 && valid3) {
			if (kantenlaengeY.equals(kantenlaengeX)) {
				ISpielkonfig konfiguration = new SpielkonfigQuadratisch(kantenlaengeX);
				erstelleSpielfeldMit(konfiguration, anzahlMinen);

			} else {
				ISpielkonfig konfiguration = new SpielkonfigRechteckig(kantenlaengeX, kantenlaengeY);
				erstelleSpielfeldMit(konfiguration, anzahlMinen);
			}
		}

	}

	private void erstelleSpielfeldMit(ISpielkonfig konfiguration, Integer anzahlMinen) {
		// nix
		String bezeichnung = "Spielfeld " + nummer;
		spielfelder.add(new Spielfeld(this, bezeichnung, konfiguration.kantenlaengeX(), konfiguration.kantenlaengeY(), anzahlMinen));
	}

	public void removeSpielfeld(Spielfeld spielfeld) {
		spielfelder.remove(spielfeld);
		nummer = nummer - 1;
	}

	public Integer getNummer() {
		return nummer;
	}

	public void setNummer(Integer nummerInt) {
		this.nummer = nummerInt;
	}

	public FensterMenue getSpielmenue() {
		return spielmenue;
	}

	public CommandButtonStart getStartbutton() {
		return startbutton;
	}

	public void setStartbutton(CommandButtonStart startbutton) {
		this.startbutton = startbutton;
	}

	public CommandButtonReset getResetbutton() {
		return resetbutton;
	}

	public void setResetbutton(CommandButtonReset resetbutton) {
		this.resetbutton = resetbutton;
	}
}

package spiel;

import java.util.Collections;
import java.util.Stack;

import button.Feld;

import window.FensterSpiel;

public class Spielfeld {

	private Spielinterface spielinstanz;
	private Feld[][] spielfeld;
	private Stack<Boolean> minenfeld = new Stack<Boolean>();
	private Integer felder;
	private Integer kantenlaengeX;
	private Integer kantenlaengeY;
	private Integer minen;
	private Integer aufgedeckteFelder = 0;


	private FensterSpiel fenster;

	public void macheMinenfeld() {// Anzahl Minen beschränken
		for (int i = 0; i < felder; i++) {
			if (i < this.minen) {
				minenfeld.add(true);
			} else {
				minenfeld.add(false);
			}
		}
		Collections.shuffle(minenfeld);
	}

	Spielfeld(Spielinterface spielinstanz, String bezeichnung, Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		this.spielinstanz = spielinstanz;
		this.fenster = new FensterSpiel(this, bezeichnung, kantenlaengeX, kantenlaengeY);
		this.kantenlaengeY = kantenlaengeY;
		this.kantenlaengeX = kantenlaengeX;
		felder = kantenlaengeX * kantenlaengeY;
		this.minen = anzahlMinen;
		macheMinenfeld();
		spielfeld = new Feld[kantenlaengeX][kantenlaengeY];
		for (int x = 0; x < kantenlaengeX; x++) {
			for (int y = 0; y < kantenlaengeY; y++) {
				spielfeld[x][y] = new Feld(this, x, y, minenfeld.pop());
			}
		}
		this.spielinstanz.setNummer(this.spielinstanz.getNummer() + 1);
		this.fenster.fensterSichtbarMachen();
	}

	public void reset() {
		this.fenster.dispose();
		this.spielinstanz.erstelleSpielfeld(this.kantenlaengeX, this.kantenlaengeY, this.minen);
		spielinstanz.removeSpielfeld(this);
	}
	public Integer getAufgedeckteFelder() {
		return aufgedeckteFelder;
	}

	public void setAufgedeckteFelder(Integer aufgedeckteFelder) {
		this.aufgedeckteFelder = aufgedeckteFelder;
	}
	public boolean checkAufgedeckteFelder(){
		if(this.aufgedeckteFelder >= (this.felder-this.minen)){
			return true;
			}
			else return false;
	}
	public void setMinen(Integer minen) {
		this.minen = minen;
	}

	public Spielinterface getSpielinstanz() {
		return spielinstanz;
	}

	public Feld getFeldAt(Integer x, Integer y) {
		return spielfeld[x][y];
	}

	public Integer getKantenlaengeX() {
		return kantenlaengeX;
	}

	public FensterSpiel getFenster() {
		return fenster;
	}

	public Integer getKantenlaengeY() {
		return kantenlaengeY;
	}

	public Feld[][] getSpielfeld() {
		// nix
		return this.spielfeld;
	}

	public Integer getMinen() {
		return minen;
	}

}

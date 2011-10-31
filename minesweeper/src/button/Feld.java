package button;

import javax.swing.AbstractButton;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;

import spiel.Spielfeld;

public class Feld extends JButton {
	static final long serialVersionUID = 0L;
	private boolean mine;
	private Integer umliegendeMinen = 0;
	private Integer thisX;
	private Integer thisY;
	private Spielfeld spielfeld;
	private Boolean istGeprueft = false;

	// Constructor

	public boolean isMine() {
		return this.mine;
	}

	public Feld(Spielfeld spielfeld, Integer x, Integer y, boolean istMine) {
		super(x.toString() + y.toString());
		this.thisX = x;
		this.thisY = y;
		this.mine = istMine;
		definiereButton();
		spielfeld.getFenster().wirdMinesweeperButton(this);
		this.spielfeld = spielfeld;
		System.out.println(this.mine);
	}

	Feld(String buttonName) {
		super(buttonName);
	}
	public Spielfeld getSpielfeld(){
		return this.spielfeld;
	}

	public void definiereButton() {
		this.setVerticalTextPosition(AbstractButton.CENTER);
		this.setHorizontalTextPosition(AbstractButton.RIGHT);
		this.setEnabled(true);
		this.setActionCommand(this.umliegendeMinen.toString());
	}

	// Exemplarmethoden
	public String check(boolean durchLeeresFeldAufgerufen) {
		if (this.mine == true) {
			return "m";
		} else {
			werdeUntersucht(durchLeeresFeldAufgerufen);
			if (this.umliegendeMinen == 0) {
				if (durchLeeresFeldAufgerufen) {
					this.check(false);
				}
				if (!durchLeeresFeldAufgerufen && this.isEnabled()) {
					this.zeigeFeldwert();
				}
				return "";
			} else {
				return this.umliegendeMinen.toString();
			}

		}

	}
	
	public void zeigeFeldwert() {
		this.setEnabled(false);
		String buttonText = this.check(true);
		this.setText(buttonText);
		this.getSpielfeld().setAufgedeckteFelder(this.getSpielfeld().getAufgedeckteFelder()+1);
		if(buttonText.equals("m")){
			this.setIcon((Icon) new ImageIcon("images/mine.gif"));
			this.setText("");
		}
	}
	
	public void werdeUntersucht(boolean aufrufDurchKlick) {
		for (Integer x = -1; x < 2; x++) {
			for (Integer y = -1; y < 2; y++) {
				if (!(x == 0 && y == 0)) {
					Integer getAtX = this.thisX + x;
					Integer getAtY = this.thisY + y;
					if(spielfeld.getKantenlaengeX()>getAtX && getAtX>=0 && spielfeld.getKantenlaengeY()>getAtY && getAtY>=0 ) {
						Feld untersuchtesFeld = spielfeld.getFeldAt(getAtX,
								getAtY);
						if (untersuchtesFeld.isMine() == true && this.istGeprueft ==false) {
							this.umliegendeMinen = this.umliegendeMinen + 1;
						} else if (!aufrufDurchKlick && this.getMinenanzahl() == 0 && this.istGeprueft == true){
								if(untersuchtesFeld.isMine() == false && untersuchtesFeld.isEnabled()==true && untersuchtesFeld.getIstGeprueft() == false){
									untersuchtesFeld.zeigeFeldwert();
							}
						}
					}
				}
			}
		}
		this.istGeprueft = true;
	}

	public Integer getMinenanzahl() {
		return this.umliegendeMinen;
	}

	public Boolean getIstGeprueft() {
		return this.istGeprueft;
	}
}

package window;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.Stack;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import button.CommandButtonReset;
import button.Feld;
import button.FeldMouseListener;
import button.CommandButtonMouseListener;
import java.awt.Image;
import java.awt.Toolkit;

import spiel.Spielfeld;

public class FensterSpiel extends Fenster {

	private Spielfeld spielfeld;
	protected Stack<Feld> buttons = new Stack<Feld>();
	private JLabel bild1;
	private JLabel bild2;
	private JPanel panelGame;
	private JPanel panelTop;
	private JPanel panelTopLeft;
	private JPanel panelTopMiddle;
	private JPanel panelTopRight;
	private JPanel panelAll;
	private CommandButtonReset resetbutton;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public FensterSpiel(Spielfeld spielfeld, String bezeichnung, Integer kantenlaengeX, Integer kantenlaengeY) {
		super(bezeichnung);
		implementLayout(kantenlaengeX, kantenlaengeY);
		this.spielfeld = spielfeld;
		this.addWindowListener(new SpielfeldSchlieﬂen());
	}

	public void implementLayout(Integer kantenlaengeX, Integer kantenlaengeY) {

		BorderLayout layoutAll = new BorderLayout();
		this.panelAll = new JPanel(layoutAll);
		this.bild1 = new JLabel();
		this.bild2 = new JLabel();
		this.panelTop = new JPanel();
		this.panelTopLeft = new JPanel();
		this.panelTopRight = new JPanel();
		this.panelTopMiddle = new JPanel();
		this.resetbutton = new CommandButtonReset("Starte Spiel neu ", this);
		resetbutton.addMouseListener(new CommandButtonMouseListener());
		this.bild1.setIcon(new ImageIcon("Images/soldier-smiley.png"));
		this.bild2.setIcon(new ImageIcon("Images/soldier-smiley.png"));
		this.panelTop.add((panelTopLeft.add(this.bild1)), BorderLayout.EAST);
		this.panelTop.add((panelTopMiddle.add(this.resetbutton)), BorderLayout.CENTER);		
		this.panelTop.add((panelTopRight.add(this.bild2)), BorderLayout.WEST);
		;
		GridLayout layout2 = new GridLayout(kantenlaengeX, kantenlaengeY);
		this.panelGame = new JPanel(layout2);
	}

	public void fensterSichtbarMachen() {
		for (JButton ButtonToPanel : buttons) {
			ButtonToPanel.addMouseListener(new FeldMouseListener());
			panelGame.add(ButtonToPanel);
		}
		this.panelAll.add(this.panelTop, BorderLayout.NORTH);
		this.panelAll.add(this.panelGame, BorderLayout.CENTER);
		this.getContentPane().add(this.panelAll);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

	public void wirdMinesweeperButton(Feld buttonAdded) {
		// nix
		buttons.push(buttonAdded);
	}

	public void youLoseImage() {		
		this.bild1.setIcon(new ImageIcon("Images/explosion.jpg"));
		this.bild2.setIcon(new ImageIcon("Images/explosion.jpg"));
		this.setVisible(true);
	}
	
	public void youWinImage() {		
		this.bild1.setIcon(new ImageIcon("Images/win.jpeg"));
		this.bild2.setIcon(new ImageIcon("Images/win.jpeg"));
		this.setVisible(true);
	}

	public void niederlage(Feld button) {
		this.youLoseImage();
		for (Feld feldInSpiel : this.getButtons()) {
			feldInSpiel.zeigeFeldwert();
		}
	}
	public void sieg(Feld button){
		this.youWinImage();
		for (Feld feldInSpiel : this.getButtons()) {
			feldInSpiel.setEnabled(false);
		}
	}
	public Stack<Feld> getButtons() {
		return buttons;
	}

	public Spielfeld getSpielfeld() {
		return spielfeld;
	}
}

package window;

import java.awt.Dimension;
import java.awt.FlowLayout;

import java.util.Stack;

import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import EingabeverarbeitungText.InputListenerAchse;
import EingabeverarbeitungText.InputListenerMinen;
import button.CommandButtonMouseListener;


public class FensterMenue extends Fenster {

	private Stack<JPanel> panels = new Stack<JPanel>();
	private static final long serialVersionUID = 1L;

	public FensterMenue(String bezeichnung) {
		super(bezeichnung);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		implementLayout();
	}
	private JPanel panelMitUeberschrift = new JPanel();
	private JLabel ueberschrift = new JLabel("Minesweeper");
	private JPanel panelMitXAchsenabfrage = new JPanel();
	private JLabel eingabeaufforderungX = new JLabel("Höhe max(4-20):");
	private JTextField xAchse;
	private JPanel panelMitYAchsenabfrage = new JPanel();
	private JLabel eingabeaufforderungY = new JLabel("Breite max(4-20):");
	private JTextField yAchse;
	private JPanel panelMitMinenanzahlAbfrage = new JPanel();
	private JLabel eingabeaufforderungM = new JLabel("Minen max(Breite*Höhe):");
	private JTextField minen;

	public void implementLayout() {
		setLayout(new FlowLayout());
	}

	public void fensterSichtbarMachen() {
		xAchse = new JTextField();
		xAchse.setName("xAchse");
		xAchse.addFocusListener(new InputListenerAchse());
		xAchse.setColumns(10);
		
		yAchse = new JTextField();
		yAchse.setName("yAchse");
		yAchse.addFocusListener(new InputListenerAchse());
		yAchse.setColumns(10);

		minen = new JTextField();
		minen.setName("minen");
		minen.addFocusListener(new InputListenerMinen());
		minen.setColumns(10);

		panelMitUeberschrift.add(ueberschrift);
		panelMitUeberschrift.setPreferredSize(new Dimension(140, 20));
		panelMitXAchsenabfrage.add(eingabeaufforderungX);
		panelMitXAchsenabfrage.add(xAchse);
		panelMitYAchsenabfrage.add(eingabeaufforderungY);
		panelMitYAchsenabfrage.add(yAchse);
		panelMitMinenanzahlAbfrage.add(eingabeaufforderungM);
		panelMitMinenanzahlAbfrage.add(minen);

		this.getContentPane().add(panelMitUeberschrift);
		this.getContentPane().add(panelMitXAchsenabfrage);
		this.getContentPane().add(panelMitYAchsenabfrage);
		this.getContentPane().add(panelMitMinenanzahlAbfrage);
		this.setSize(300, 200);
		this.setVisible(true);
		this.setResizable(false);

		for (JPanel buttonToContent : panels) {
			this.getContentPane().add(buttonToContent);
		}
	}

	public void wirdMinesweeperButton(JButton buttonAdded) {
		buttonAdded.addMouseListener(new CommandButtonMouseListener());
		JPanel neuesPanel = new JPanel();
		neuesPanel.add(buttonAdded);
		panels.push(neuesPanel);
	}

	public JTextField getxAchse() {
		return this.xAchse;
	}

	public void setxAchse(JFormattedTextField xAchse) {
		this.xAchse = xAchse;
	}

	public JTextField getyAchse() {
		return this.yAchse;
	}

	public void setyAchse(JFormattedTextField yAchse) {
		this.yAchse = yAchse;
	}

	public JTextField getMinen() {
		return this.minen;
	}
}

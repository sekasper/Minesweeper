package View;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.Stack;
import javax.swing.AbstractButton;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import Controller.GameAdministrationController;
import View.InputListener;
import View.StartButtonListener;

public class GameAdministrationWindow extends JFrame {

	private Stack<JPanel> panels = new Stack<JPanel>();
	private static final long serialVersionUID = 1L;
	private JTextField xAxis;
	private JTextField yAxis;
	private JTextField mines;

	public GameAdministrationWindow(String bezeichnung, GameAdministrationController administrationContr) {
		super(bezeichnung);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(new FlowLayout());

		// Überschrifft für das Fenster

		JPanel panelMitUeberschrift = new JPanel();
		JLabel ueberschrift = new JLabel("Minesweeper");
		panelMitUeberschrift.add(ueberschrift);
		panelMitUeberschrift.setPreferredSize(new Dimension(140, 20));
		this.getContentPane().add(panelMitUeberschrift);

		// xAchse Textfeld mit inputListener einbetten, um Benutzereingaben zu
		// registrieren

		this.xAxis = new JTextField();
		textFieldConfiguration(this.xAxis, "xAchse", "Höhe max(4-20):");// ToDo
																		// :
																		// String
																		// aus
																		// konfigurationsdatei
																		// generieren
		this.yAxis = new JTextField();
		textFieldConfiguration(this.yAxis, "yAchse", "Breite max(4-20):");// ToDo
																			// :String
																			// aus
																			// konfigurationsdatei
																			// generieren
		this.mines = new JTextField();
		textFieldConfiguration(this.mines, "minen", "Minen max(Breite*Höhe):");// ToDo
																				// :String
																				// aus
																				// konfigurationsdatei
																				// generieren

		// Startbutton erstellen und zum Fenster hinzufügen

		JButton startbutton = addButton("startbutton");
		startbutton.addMouseListener(new StartButtonListener(administrationContr));
		for (JPanel panel : panels) {
			this.getContentPane().add(panel);
		}

		// Fenster Anzeigen

		this.setSize(300, 200);
		this.setVisible(true);
		this.setResizable(false);
	}

	public void textFieldConfiguration(JTextField textfield, String name, String bemerkung) {

		// Panel für Textfeld und Beschreibung

		JPanel panelForTextfield = new JPanel();

		// Label für Textfeldbeschreinung wird erzeugt und zum panel hinzugefügt

		JLabel labelWithInstruction = new JLabel(bemerkung);
		panelForTextfield.add(labelWithInstruction);

		// Textfeld wird Konfiguriert mit einem Listener für die Validierung
		// versehen und hinzugefügt

		textfield.setName(name);
		textfield.addFocusListener(new InputListener());
		textfield.setColumns(10);
		panelForTextfield.add(textfield);
		this.getContentPane().add(panelForTextfield);

	}

	public void fensterSichtbarMachen() {
		for (JPanel buttonToContent : panels) {
			this.getContentPane().add(buttonToContent);
		}
		this.setSize(300, 200);
		this.setVisible(true);
		this.setResizable(false);

	}

	public JButton addButton(String headline) {
		JButton buttonAdded = new JButton(headline);
		buttonAdded.setVerticalTextPosition(AbstractButton.CENTER);
		buttonAdded.setHorizontalTextPosition(AbstractButton.RIGHT);
		buttonAdded.setEnabled(true);
		buttonAdded.setActionCommand("starte Spiel");
		buttonAdded.setPreferredSize(new Dimension(140, 20));
		JPanel newPanel = new JPanel();
		newPanel.add(buttonAdded);
		panels.push(newPanel);
		return buttonAdded;
	}

	// public Vector Textfields update (change due to Error);

	public JTextField getxAxis() {
		return xAxis;
	}

	public void setxAxis(JTextField xAxis) {
		this.xAxis = xAxis;
	}

	public JTextField getyAxis() {
		return yAxis;
	}

	public void setyAxis(JTextField yAxis) {
		this.yAxis = yAxis;
	}

	public JTextField getMines() {
		return mines;
	}

	public void setMines(JTextField mines) {
		this.mines = mines;
	}
}
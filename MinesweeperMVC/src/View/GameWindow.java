package View;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

//import spiel.Spielfeld;
import Controller.GameController;

/**
 * @author seka
 *Spielfenster für die Darstellung des Spiels
 */
public class GameWindow extends JFrame {

	private GameButton[][] buttons;
	private JLabel bild1;
	private JLabel bild2;
	private JPanel panelGame;
	private JPanel panelTop;
	private JPanel panelTopLeft;
	private JPanel panelTopMiddle;
	private JPanel panelTopRight;
	private JPanel panelAll;
	private JButton resetbutton;
	private GameController gameContr;
	private static final long serialVersionUID = 1L;

//Fenster erstellen. Das Fenster bildet das Spielfeld aus Game ab. Zur Kommunikation von Änderungen an den GameController werden MouseListener eingebunden.
	
	public GameWindow(GameController gameContr, String bezeichnung, Integer kantenlaengeX, Integer kantenlaengeY) {
		super(bezeichnung);
		this.gameContr = gameContr;
		implementLayout();
		createButtonArea(kantenlaengeX, kantenlaengeY);
		organizePanels();
		this.setDefaultCloseOperation(HIDE_ON_CLOSE);

	}

	public void implementLayout() {

		BorderLayout layoutAll = new BorderLayout();
		this.panelAll = new JPanel(layoutAll);
		this.bild1 = new JLabel();
		this.bild2 = new JLabel();
		this.panelTop = new JPanel();
		this.panelTopLeft = new JPanel();
		this.panelTopRight = new JPanel();
		this.panelTopMiddle = new JPanel();
		this.resetbutton = new JButton("Starte Spiel neu ");
		resetbutton.addMouseListener(new RestartButtonListener(gameContr));
		inGameImage();
		this.panelTop.add((panelTopLeft.add(this.bild1)), BorderLayout.EAST);
		this.panelTop.add((panelTopMiddle.add(this.resetbutton)), BorderLayout.CENTER);
		this.panelTop.add((panelTopRight.add(this.bild2)), BorderLayout.WEST);

	}

	public void createButtonArea(Integer sizeX, Integer sizeY) {
		GridLayout layout2 = new GridLayout(sizeX, sizeY);
		this.panelGame = new JPanel(layout2);
		buttons = new GameButton[sizeX][sizeY];
		for (int x = 0; x < sizeX; x++) {
			for (int y = 0; y < sizeY; y++) {
				buttons[x][y] = new GameButton(x, y);
				buttons[x][y].listenerWithController(gameContr);
				panelGame.add(buttons[x][y]);
			}
		}
	}

	public void organizePanels() {

		this.panelAll.add(this.panelTop, BorderLayout.NORTH);
		this.panelAll.add(this.panelGame, BorderLayout.CENTER);
		this.getContentPane().add(this.panelAll);
		this.pack();
		this.setVisible(true);
		this.setResizable(false);
	}

//	Methoden für die Darstellung der Statusbilder. 
	
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
	
	public void inGameImage() {
		this.bild1.setIcon(new ImageIcon("Images/soldier-smiley.png"));
		this.bild2.setIcon(new ImageIcon("Images/soldier-smiley.png"));
		this.setVisible(true);
	}
//getter & setter
	
	public GameButton getButton(Integer x, Integer y){
	return buttons[x][y];
	}
	public GameButton [][] getButtons(){
	return buttons;
	}
}
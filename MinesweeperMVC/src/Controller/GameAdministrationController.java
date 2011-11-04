package Controller;

import Model.GameAdministration;
import Model.Game;
import Model.IGamekonfig;
import View.GameAdministrationWindow;

/**
 * @author seka Dieser Controller ist f�r die Kommunikation von Eingaben an die
 *         Spieladministration zust�ndig und regelt die Aktualisierung der Werte
 *         in den Eingabefeldern des Administrationsfensters.
 * 
 */
public class GameAdministrationController {

	private GameAdministration administration;
	private GameAdministrationWindow administrationWindow;

	/**
	 * Mit einer Instanz des Controllers werden das Administrationsfenster f�r
	 * das Spiel und die Spieladministration erzeugt.
	 */
	public GameAdministrationController() {
		this.administration = new GameAdministration();// erstelle die View f�r
														// die Spielverwaltung
		this.administrationWindow = new GameAdministrationWindow("Spielverwaltung", this);
	}

	/**
	 * Bei einem Klick auf den Spielstartbutton (CommandButtonStart) ausgeloest.
	 * Validiert in letzter Instanz die Eingabe. Der Catch Block kann leer
	 * bleiben, weil der Spieler eine Fehlerbeschreibung �ber den betroffenen
	 * InputListener bekomt.
	 */
	public void handleStartButtonEvent() {

		try {
			Integer kanteX = new Integer(this.administrationWindow.getxAxis().getText());
			Integer kanteY = new Integer(this.administrationWindow.getyAxis().getText());
			Integer minen = new Integer(this.administrationWindow.getMines().getText());
			boolean isValid = administration.validateInput(kanteX, kanteY, minen);
			if (isValid) {
				IGamekonfig konfig = administration.defineKonfiguration(kanteX, kanteY, minen);
				Game game = this.administration.createGame(konfig, minen);
				new GameController(game);
			}
		} catch (java.lang.NumberFormatException e) {
		}

	}
}
package Model;

import java.util.ArrayList;
import java.util.List;

import Model.IGamekonfig;
import Model.Game;
import Model.GamekonfigQuadrate;
import Model.GamekonfigRectangle;
import Model.GamekonfigValidator;

/**
 * @author seka Diese Klasse ist für das Erstellen der Models für die
 *         Minesweepergames zustädig.
 */
public class GameAdministration {

	private List<Game> games = new ArrayList<Game>();

	/**
	 * Die Methode erstellt Spiele nach den Nutzereingaben unter Einbindung des
	 * Spielinterfaces mit vorheriger Validierung. Ist die Anzahl der Spiele
	 * nicht kleiner 5 wird kein weiteres Spiel erstellt.
	 * 
	 * @param kantenlaengeX
	 * @param kantenlaengeY
	 * @param anzahlMinen
	 * 
	 */
	public boolean validateInput(Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		boolean valid = true;
		valid &= GamekonfigValidator.validateKantenlaenge(kantenlaengeX);
		valid &= GamekonfigValidator.validateKantenlaenge(kantenlaengeY);
		valid &= GamekonfigValidator.validateMinenanzahl(anzahlMinen, kantenlaengeX, kantenlaengeY);
		valid &= this.games.size() < 6;
		return valid;
	}

	/**
	 * @param kantenlaengeX
	 * @param kantenlaengeY
	 * @param anzahlMinen
	 * @return Definiert die Spielkonfiguration danach ob ein spielfeld
	 *         Quadratisch oder Rechteckig ist mithilfe des
	 *         IGamekonfiginterfaces.
	 */
	public IGamekonfig defineKonfiguration(Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		if (kantenlaengeY.equals(kantenlaengeX)) {
			IGamekonfig konfiguration = new GamekonfigQuadrate(kantenlaengeX);
			createGame(konfiguration, anzahlMinen);
			return konfiguration;

		} else {
			IGamekonfig konfiguration = new GamekonfigRectangle(kantenlaengeX, kantenlaengeY);
			createGame(konfiguration, anzahlMinen);
			return konfiguration;
		}

	}

	/**
	 * @param konfiguration
	 * @param anzahlMinen
	 *            erstellt das Spiel als Model durch den Aufruf des Konstruktors
	 *            von Game.
	 */
	public Game createGame(IGamekonfig konfiguration, Integer anzahlMinen) {
		String bezeichnung = "Spielfeld " + games.size() + 1;
		Game game = new Game(this, bezeichnung, konfiguration.kantenlaengeX(), konfiguration.kantenlaengeY(), anzahlMinen);
		games.add(game);
		return game;

	}
}
package Model;

import java.util.ArrayList;
import java.util.List;

import Model.IGamekonfig;
import Model.Game;
import Model.GamekonfigQuadrate;
import Model.GamekonfigRectangle;
import Model.GamekonfigValidator;

/**
 * @author seka
 *Diese Klasse ist für das Erstellen der Models für die Minesweepergames zustädig. Es weiß wieviele Spiele erstellt sind. 
 */
/**
 * @author seka
 *
 */
/**
 * @author seka
 *
 */
public class GameAdministration {

	private List<Game> games = new ArrayList<Game>();
	private Integer nummer = 0;
	/**
	 * @param kantenlaengeX
	 * @param kantenlaengeY
	 * @param anzahlMinen 
	 * Die Methode erstellt Spiele nach den Nutzereingaben unter Einbindung des Spielinterfaces mit vorheriger Validierung. 
	 * Ist die Anzahl der Spiele nicht kleiner 5 wird kein weiteres Spiel erstellt.
	 * 
	 */
	public boolean validateInput(Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen) {
		boolean valid = true;
		valid &= GamekonfigValidator.validateKantenlaengeX(kantenlaengeX);
		valid &= GamekonfigValidator.validateKantenlaengeY(kantenlaengeY);
		valid &= GamekonfigValidator.validateMinenanzahl(anzahlMinen, kantenlaengeX, kantenlaengeY);
		valid &= this.nummer < 5;
		return valid;
	}	
	
	public IGamekonfig getKonfiguration(Integer kantenlaengeX, Integer kantenlaengeY, Integer anzahlMinen){
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
	 * erstellt das Spiel als Model durch den Aufruf des Konstruktors von Game.
	 */
	public Game createGame(IGamekonfig konfiguration, Integer anzahlMinen) {
		// nix
		String bezeichnung = "Spielfeld " + nummer;
		Game game = new Game(this, bezeichnung, konfiguration.kantenlaengeX(), konfiguration.kantenlaengeY(), anzahlMinen);
		games.add(game);
		return game;
	
	}

	Integer getSpielfelderanzahl() {
	return games.size();
	}


  public void Administration() {
	  
  }    

  public void getGameFieldModel() {
  }

  public void getGameFieldLatestChange() {
  }
}
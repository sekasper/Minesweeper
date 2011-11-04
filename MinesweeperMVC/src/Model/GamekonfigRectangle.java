package Model;

public class GamekonfigRectangle implements IGamekonfig {
	Integer kantenlaengeX;
	Integer kantenlaengeY;

	public GamekonfigRectangle( int breiteSpielfeld,int hoeheSpielfeld) {
		this.kantenlaengeY = hoeheSpielfeld;
		this.kantenlaengeX = breiteSpielfeld;
	}

	@Override
	public Integer kantenlaengeX() {
		return kantenlaengeX;
	}

	@Override
	public Integer kantenlaengeY() {
		return kantenlaengeY;
	}
}
